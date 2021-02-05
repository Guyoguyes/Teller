package DAO;

import models.Comment;

import java.util.List;

public interface CommentDAO {

    //post comment
    void postComment(Comment comment);

    //get comments for a news
    List<Comment> getAllCommentByNews(long newsId);
}
