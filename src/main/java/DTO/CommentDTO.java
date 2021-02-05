package DTO;

import DAO.CommentDAO;
import models.Comment;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class CommentDTO implements CommentDAO {
    private final Sql2o sql2o;

    public CommentDTO(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void postComment(Comment comment) {
        String sql = "INSERT INTO comment (newsid, comment, commentdate) VALUES (:newsId, :comment, :commentDate)";
        try(Connection conn = sql2o.open()){
            long id = conn.createQuery(sql, true)
                    .bind(comment)
                    .executeUpdate()
                    .getKey(Long.class);
            comment.setCommentId(id);
        }
    }
}
