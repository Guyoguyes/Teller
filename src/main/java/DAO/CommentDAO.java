package DAO;

import com.google.gson.JsonElement;
import models.Comment;

import java.util.List;

public interface CommentDAO {

    //post comment
    void postComment(Comment comment);

    //get comments for a news
    List<Comment> getAllCommentByNews(long newsId);

    //Count of comment by a news
    int totalCommentByNews(long newsId);

    //find comment by id
    Comment findCommentById(long commentId);

    //delete comment
    JsonElement deleteComment(long commentId);

    //post a review
    void postReview(Comment comment);

    //get all reviews by a comment
    List<Comment> getAllReviewsByComment(long reviewid);

}
