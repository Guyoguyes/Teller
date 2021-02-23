package DTO;

import DAO.CommentDAO;
import com.google.gson.JsonElement;
import models.Comment;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class CommentDTO implements CommentDAO {
    private final Sql2o sql2o;

    public CommentDTO(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void postComment(Comment comment) {
        String sql = "INSERT INTO comment (newsid, content, commentdate) VALUES (:newsId, :content, now())";
        try(Connection conn = sql2o.open()){
            long id = conn.createQuery(sql, true)
                    .bind(comment)
                    .executeUpdate()
                    .getKey(Long.class);
            comment.setCommentId(id);
        }
    }

    @Override
    public void postReview(Comment comment) {
        String sql = "INSERT INTO comment(content, newsid, commentdate, reviewid) VALUES (:content, :newsId, :commentDate, :reviewId)";
      try(Connection conn = sql2o.open()){
          conn.createQuery(sql, true)
                  .addParameter("content", comment.getContent())
                  .addParameter("newsId", comment.getNewsId())
                  .addParameter("commentDate", comment.getCommentDate())
                  .addParameter("reviewId", comment.getReviewId())
                  .executeUpdate()
                  .getKey(Long.class);

      }
    }

    @Override
    public List<Comment> getAllCommentByNews(long newsId) {
        String sql = "SELECT * FROM comment WHERE newsid = :newsId";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("newsId", newsId)
                    .executeAndFetch(Comment.class);
        }
    }

    @Override
    public int totalCommentByNews(long newsId) {
        String sql = "SELECT COUNT(*) FROM comment WHERE newsid = :newsId";
        try(Connection conn = sql2o.open()){
            return (int) conn.createQuery(sql)
                    .addParameter("newsId", newsId)
                    .executeScalar(Integer.class);
        }
    }

    @Override
    public List<Comment> getAllReviewsByComment(long reviewid) {
        String sql = "SELECT * FROM comment WHERE reviewid = :reviewId";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("reviewId", reviewid)
                    .executeAndFetch(Comment.class);
        }
    }

    @Override
    public Comment findCommentById(long commentId) {
        String sql = "SELECT * FROM comment WHERE commentid = :commentId";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("commentId", commentId)
                    .executeAndFetchFirst(Comment.class);
        }
    }

    @Override
    public JsonElement deleteComment(long commentId) {
        String sql = "DELETE FROM comment WHERE commentid = :commentId";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("commentId", commentId)
                    .executeUpdate();
        }
        return null;
    }
}
