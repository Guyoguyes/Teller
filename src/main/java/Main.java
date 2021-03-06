import DTO.*;
import Exceptions.ApiException;
import com.google.gson.Gson;
import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;


public class Main {
    static int getHerokuAssignedPort(){
        ProcessBuilder processBuilder = new ProcessBuilder();
        if(processBuilder.environment().get("PORT") != null){
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
    public static void main(String[] args) {
        CategoryDTO categoryDTO;
        AuthorDTO authorDTO;
        NewsDTO newsDTO;
        CommentDTO commentDTO;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://ec2-52-204-141-94.compute-1.amazonaws.com:5432/d2vsrhhntehmj6";
        Sql2o sql2o = new Sql2o(connectionString, "edcafbglqymlwd","ba11bc5fcedc29d58f88061d68998bb932afaeb32e535852594d6807621c0173");
        categoryDTO = new CategoryDTO(sql2o);
        authorDTO = new AuthorDTO(sql2o);
        newsDTO = new NewsDTO(sql2o);
        commentDTO = new CommentDTO(sql2o);
        conn = sql2o.open();

        //CATEGORY
        post("/api/category", "application/json", (req, res) ->{
            Category category = gson.fromJson(req.body(), Category.class);
            categoryDTO.createCategory(category);
            res.status(201);
            return gson.toJson(category);
        });

        get("api/category", "application/json", (req, res) ->{
            return gson.toJson(categoryDTO.getAllCategory());
        });

        get("/api/category/:catId", "application/json", (req, res) ->{
            int categoryId = Integer.parseInt(req.params("catId"));
            res.status(200);
            return gson.toJson(categoryDTO.findById(categoryId));
        });


        delete("/api/category/:catId", "application/json", (req, res) ->{
            int categoryId = Integer.parseInt(req.params("catId"));
            Category category = categoryDTO.findById(categoryId);
            if(category == null){
                throw new ApiException(404, String.format("No category of id \"%s\" found", req.params("catId")));
            }else{
                return gson.toJson(categoryDTO.deleteCategory(categoryId));
            }
        });

        //AUTHOR
        post("/api/author", "application/json", (req, res) ->{
            Author author = gson.fromJson(req.body(), Author.class);
            authorDTO.createAuthor(author);
            res.status(201);
            return gson.toJson(author);
        });

        get("/api/author", "application/json", (req, res) ->{
            res.status(200);
            return gson.toJson(authorDTO.getAllAuthor());
        });

        get("/api/author/:authorId", "application/json", (req, res) ->{
            int authorId = Integer.parseInt(req.params("authorId"));
            res.status(200);
            return gson.toJson(authorDTO.findById(authorId));
        });



        //NEWS
        post("/api/category/:categoryId/author/:authorId/news", "application/json", (req, res) ->{
            int categoryId = Integer.parseInt(req.params("categoryId"));
            Category category = categoryDTO.findById(categoryId);
            if(category == null){
                throw new ApiException(404, String.format("No category of id \"%s\" found", req.params("catId")));
            }else{
                int authorId = Integer.parseInt(req.params("authorId"));
                Author author = authorDTO.findById(authorId);
                if(author == null){
                    throw new ApiException(404, String.format("No author of id \"%s\" found", req.params("authorId")));
                }else{
                    News news = gson.fromJson(req.body(), News.class);
                    news.setCategoryId(categoryId);
                    news.setAuthorId(authorId);
                    newsDTO.createNews(news);
                    res.status(201);
                    return gson.toJson(news);
                }

            }
        });

        get("/api/news", "application/json", (req, res) ->{
            res.status(201);
            return gson.toJson(newsDTO.getAllNews());
        });

        get("/api/news/:newsId", "application/json", (req, res) ->{
            int newsId = Integer.parseInt(req.params("newsId"));
            News news = newsDTO.findNewsById(newsId);
            if(news == null){
                throw new ApiException(404, String.format("No news of id \"%s\" found", req.params("newsId")));
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

        get("/api/news/author/:authorId", "application/json", (req, res) ->{
            int authorId = Integer.parseInt(req.params("authorId"));
            Author author = authorDTO.findById(authorId);
            if(author == null){
                throw new ApiException(404, String.format("No author of id \"%s\" found", req.params("authorId")));
            }else{
                return gson.toJson(newsDTO.getAllNewsByAuthor(authorId));
            }
        });

        get("/api/category/:catId/news", "application/json", (req, res) ->{
            int catId = Integer.parseInt(req.params("catId"));
            Category category = categoryDTO.findById(catId);
            if(category == null){
                throw new ApiException(404, String.format("No news of id \"%s\" found", req.params("newsId")));
            }else{
                return gson.toJson(newsDTO.getAllNewsByCategory(catId));
            }


        });

//        put("api/news/:newsId/likes", "application/json", (req, res) ->  {
//            int newsId = Integer.parseInt(req.params("newsId"));
//            News news = newsDTO.findNewsById(newsId);
//            if(news == null){
//                return "{\"message\":\"no news found\"}";
//            }else{
//                news.setNewsId(newsId);
////                int initVote = 0;
////                News vote = null;
////                vote.upvote();
////                int newVote = Integer.parseInt(String.valueOf(vote));
//                int vote = news.upvote();
//                News news1 = gson.fromJson(req.body(), News.class);
//                return gson.toJson(newsDTO.updateNews(news1));
//            }
//        });



        //COMMENTS
        post("/api/news/:newsId/comment", "application/json", (req, res) ->{
            int newsId = Integer.parseInt(req.params("newsId"));
            News news = newsDTO.findNewsById(newsId);
            if(news == null){
                throw new ApiException(404, String.format("No news of id \"%s\" found", req.params("newsId")));
            }else{
                Comment comment = gson.fromJson(req.body(), Comment.class);
                comment.setNewsId(newsId);
                commentDTO.postComment(comment);
                res.status(200);
                return gson.toJson(comment);
            }
        });

        get("/api/news/:newsId/comment", "application/json", (req, res) ->{
            int newsId = Integer.parseInt(req.params("newsId"));
            News news = newsDTO.findNewsById(newsId);
            if(news == null){
                throw new ApiException(404, String.format("No news of id \"%s\" found", req.params("newsId")));
            }else{
                return gson.toJson(commentDTO.getAllCommentByNews(newsId));
            }
        });

        get("/api/news/:newsId/comment/count", "application/json", (req, res) ->{
            int newsId = Integer.parseInt(req.params("newsId"));
            newsDTO.findNewsById(newsId);
            res.status(200);
            return gson.toJson(commentDTO.totalCommentByNews(newsId));
        });

        delete("/api/news/:newsId/comment/:commentId/delete",  "application/json", (req, res) ->{
            int newsId = Integer.parseInt(req.params("newsId"));
            News news = newsDTO.findNewsById(newsId);
            if(news == null){
                throw new ApiException(404, String.format("No news of id \"%s\" found", req.params("newsId")));
            }else{
                int commentId = Integer.parseInt(req.params("commentId"));
                Comment comment = commentDTO.findCommentById(commentId);
                if(comment == null){
                    throw new ApiException(404, String.format("No comment of id \"%s\" found", req.params("commentId")));
                }else{
                    res.status(200);

                    return gson.toJson(commentDTO.deleteComment(commentId));
                }
            }
        });

        //post a review on comment
        post("/api/news/:newsId/comment/:commentId/review", "application/json", (req, res) -> {
            int newsId = Integer.parseInt(req.params("newsId"));
            News news = newsDTO.findNewsById(newsId);
            if(news == null){
                throw new ApiException(404, String.format("No news of id \"%s\" found", req.params("newsId")));
            }else{
                int commentId = Integer.parseInt(req.params("commentId"));
                Comment comment = commentDTO.findCommentById(commentId);
                if(comment == null){
                    throw new ApiException(404, String.format("No comment of id \"%s\" found", req.params("commentId")));
                }else{
                    Comment review = gson.fromJson(req.body(), Comment.class);
                    review.setNewsId(newsId);
                    review.setCommentId(commentId);
                    review.setReviewId(comment.getCommentId());
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    review.setCommentDate(timestamp);
                    commentDTO.postReview(review);
                    res.status(200);
                    return gson.toJson(review);
                }
            }
        });
        
        //get all reviews by a comment
        get("/api/comment/:commentId/reviews/:reviewId", "application/json", (req, res) -> {
            int commentId = Integer.parseInt(req.params("commentId"));
            Comment comment = commentDTO.findCommentById(commentId);
            if(comment == null){
                throw new ApiException(404, String.format("No comment of id \"%s\" found", req.params("commentId")));
            }else{
                int reviewId = Integer.parseInt(req.params("reviewId"));
                return gson.toJson(commentDTO.getAllReviewsByComment(reviewId));
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
