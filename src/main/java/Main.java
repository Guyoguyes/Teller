import DTO.AuthorDTO;
import DTO.CategoryDTO;
import com.google.gson.Gson;
import models.Author;
import models.Category;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;


public class Main {
    public static void main(String[] args) {
        CategoryDTO categoryDTO;
        AuthorDTO authorDTO;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://localhost:5432/tellernews";
        Sql2o sql2o = new Sql2o(connectionString, "guyo","password");
        categoryDTO = new CategoryDTO(sql2o);
        authorDTO = new AuthorDTO(sql2o);
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

        //filters
        //TODO: EXCEPTION PLUS EXCEPTION FILTER 2

        after((req, res) ->{
            res.type("application/json");
        });
    }
}
