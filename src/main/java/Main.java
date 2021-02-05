import DTO.AuthorDTO;
import DTO.CategoryDTO;
import DTO.NewsDTO;
import com.google.gson.Gson;
import models.Author;
import models.Category;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static spark.Spark.*;


public class Main {
    public static void main(String[] args) {
        CategoryDTO categoryDTO;
        AuthorDTO authorDTO;
        NewsDTO newsDTO;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://localhost:5432/tellernews";
        Sql2o sql2o = new Sql2o(connectionString, "guyo","password");
        categoryDTO = new CategoryDTO(sql2o);
        authorDTO = new AuthorDTO(sql2o);
        newsDTO = new NewsDTO(sql2o);
        conn = sql2o.open();

        //CATEGORY
        post("api/category", "application/json", (req, res) ->{
            Category category = gson.fromJson(req.body(), Category.class);
            categoryDTO.createCategory(category);
            res.status(201);
            return gson.toJson(category);
        });

        get("api/category", "application/json", (req, res) ->{
            res.status(200);
            return gson.toJson(categoryDTO.getAllCategory());
        });

        get("api/category/:catId", "application/json", (req, res) ->{
            int categoryId = Integer.parseInt(req.params("catId"));
            res.status(200);
            return gson.toJson(categoryDTO.findById(categoryId));
        });

        //TODO: DELETE ROUTE 1
//        delete("api/category/:catId", "application/json", (req, res) ->{
//
//        });

        //AUTHOR
        post("api/author", "application/json", (req, res) ->{
            Author author = gson.fromJson(req.body(), Author.class);
            authorDTO.createAuthor(author);
            res.status(201);
            return gson.toJson(author);
        });

        get("api/author", "application/json", (req, res) ->{
            res.status(200);
            return gson.toJson(authorDTO.getAllAuthor());
        });

        get("api/author/:authorId", "appilication/json", (req, res) ->{
            int authorId = Integer.parseInt(req.params("authorId"));
            res.status(200);
            return gson.toJson(authorDTO.findById(authorId));
        });

        //NEWS
        post("api/news", "application/json", (req, res) ->{
            News news = gson.fromJson(req.body(), News.class);
            newsDTO.createNews(news);
            res.status(201);
            return gson.toJson(news);
        });

        get("api/news/:newsId", "application/json", (req, res) ->{
            int newsId= Integer.parseInt(req.params("newsId"));
            res.status(200);
            return gson.toJson((newsDTO.findNewsById(newsId)));
        });

        get("api/news", "application/json", (req, res) ->{
            res.status(201);
            return gson.toJson(newsDTO.getAllNews());
        });


//        get("api/category/:catId/news", "application/json", (req, res) ->{
//            int catId = Integer.parseInt(req.params("catId"));
//            Category category = categoryDTO.findById(catId);
//            if(category == null){
//                return "{\"message\":\"no news found\"}";
//            }else{
//                return gson.toJson(newsDTO.getAllNewsByCategory(catId));
//            }
//
//
//        });

        //filters
        //TODO: EXCEPTION PLUS EXCEPTION FILTER 2

        after((req, res) ->{
            res.type("application/json");
        });
    }
}
