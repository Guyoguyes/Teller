import DTO.*;
import Exceptions.ApiException;
import com.google.gson.Gson;
import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;


public class Main {
    public static void main(String[] args) {
        CategoryDTO categoryDTO;
        AuthorDTO authorDTO;
        NewsDTO newsDTO;
        CommentDTO commentDTO;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://localhost:5432/tellernews";
        Sql2o sql2o = new Sql2o(connectionString, "guyo","password");
        categoryDTO = new CategoryDTO(sql2o);
        authorDTO = new AuthorDTO(sql2o);
        newsDTO = new NewsDTO(sql2o);
        commentDTO = new CommentDTO(sql2o);
        conn = sql2o.open();

        //CATEGORY
        post("api/category", "application/json", (req, res) ->{
            Category category = gson.fromJson(req.body(), Category.class);
            categoryDTO.createCategory(category);
            res.status(201);
            return gson.toJson(category);
        });

        get("api/category", "application/json", (req, res) ->{
            return gson.toJson(categoryDTO.getAllCategory());
        });

        get("api/category/:catId", "application/json", (req, res) ->{
            int categoryId = Integer.parseInt(req.params("catId"));
            res.status(200);
            return gson.toJson(categoryDTO.findById(categoryId));
        });


        delete("api/category/:catId", "application/json", (req, res) ->{
            int categoryId = Integer.parseInt(req.params("catId"));
            Category category = categoryDTO.findById(categoryId);
            if(category == null){
                return "{\"message\":\"no category found\"}";
            }else{
                return gson.toJson(categoryDTO.deleteCategory(categoryId));
            }
        });

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

        get("api/author/:authorId", "application/json", (req, res) ->{
            int authorId = Integer.parseInt(req.params("authorId"));
            res.status(200);
            return gson.toJson(authorDTO.findById(authorId));
        });



        //NEWS
        post("api/category/:categoryId/news", "application/json", (req, res) ->{
            int categoryId = Integer.parseInt(req.params("categoryId"));
            Category category = categoryDTO.findById(categoryId);
            if(category == null){
                return "{\"message\":\"no category found\"}";
            }else{
                News news = gson.fromJson(req.body(), News.class);
                newsDTO.createNews(news);
                res.status(201);
                return gson.toJson(news);
            }
        });

        get("api/news", "application/json", (req, res) ->{
            res.status(201);
            return gson.toJson(newsDTO.getAllNews());
        });

        get("api/news/:newsId", "application/json", (req, res) ->{
            int newsId = Integer.parseInt(req.params("newsId"));
            News news = newsDTO.findNewsById(newsId);
            if(news == null){
                return "{\"message\":\"no news found\"}";
            }else{
                return gson.toJson(news);
            }
        });

//        get("api/category/:catId/news/:newsId", "application/json", (req, res) ->{
//            int categoryId = Integer.parseInt(req.params("catId"));
//            Category category = categoryDTO.findById(categoryId);
//            if(category == null){
//                return "{\"message\":\"no news found\"}";
//            }else{
//                int newsId= Integer.parseInt(req.params("newsId"));
//                res.status(200);
//                return gson.toJson((newsDTO.findNewsById(newsId)));
//            }
//        });

        get("api/news/author/:authorId", "application/json", (req, res) ->{
            int authorId = Integer.parseInt(req.params("authorId"));
            Author author = authorDTO.findById(authorId);
            if(author == null){
                return "{\"message\":\"no news found\"}";
            }else{
                return gson.toJson(newsDTO.getAllNewsByAuthor(authorId));
            }
        });

        get("api/category/:catId/news", "application/json", (req, res) ->{
            int catId = Integer.parseInt(req.params("catId"));
            Category category = categoryDTO.findById(catId);
            if(category == null){
                return "{\"message\":\"no news found\"}";
            }else{
                return gson.toJson(newsDTO.getAllNewsByCategory(catId));
            }


        });




        //COMMENTS
        post("api/news/:newsId/comment", "application/json", (req, res) ->{
            int newsId = Integer.parseInt(req.params("newsId"));
            News news = newsDTO.findNewsById(newsId);
            if(news == null){
                return "{\"message\":\"no news found\"}";
            }else{
                Comment comment = gson.fromJson(req.body(), Comment.class);
                commentDTO.postComment(comment);
                res.status(200);
                return gson.toJson(comment);
            }
        });

        get("api/news/:newsId/comment", "application/json", (req, res) ->{
            int newsId = Integer.parseInt(req.params("newsId"));
            News news = newsDTO.findNewsById(newsId);
            if(news == null){
                return "{\"message\":\"no news found\"}";
            }else{
                return gson.toJson(commentDTO.getAllCommentByNews(newsId));
            }
        });

        get("api/news/:newsId/comment/count", "application/json", (req, res) ->{
            int newsId = Integer.parseInt(req.params("newsId"));
            newsDTO.findNewsById(newsId);
            res.status(200);
            return gson.toJson(commentDTO.totalCommentByNews(newsId));
        });

        delete("api/news/:newsId/comment/:commentId/delete",  "application/json", (req, res) ->{
            int newsId = Integer.parseInt(req.params("newsId"));
            News news = newsDTO.findNewsById(newsId);
            if(news == null){
                return "{\"message\":\"no news found\"}";
            }else{
                int commentId = Integer.parseInt(req.params("commentId"));
                Comment comment = commentDTO.findCommentById(commentId);
                if(comment == null){
                    return "{\"message\":\"no comment found\"}";
                }else{
                    res.status(200);

                    return gson.toJson(commentDTO.deleteComment(commentId));
                }
            }
        });

        post("api/news/:newsId/comment/:commentId/review", "application/json", (req, res) -> {
            int newsId = Integer.parseInt(req.params("newsId"));
            News news = newsDTO.findNewsById(newsId);
            if(news == null){
                return "{\"message\":\"no news found\"}";
            }else{
                int commentId = Integer.parseInt(req.params("commentId"));
                Comment comment = commentDTO.findCommentById(commentId);
                if(comment == null){
                    return "{\"message\":\"no comment found\"}";
                }else{
                    Comment review = gson.fromJson(req.body(), Comment.class);
                    review.setNewsId(newsId);
                    review.setReviewId(comment.getCommentId());
                    commentDTO.postReview(review);
                    res.status(200);
                    return gson.toJson(review);
                }
            }
        });

        //filters
        exception(ApiException.class, (exc, req, res) ->{
            ApiException err = (ApiException) exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("err", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });

        after((req, res) ->{
            res.type("application/json");
        });
    }
}
