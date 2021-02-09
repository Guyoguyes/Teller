package DTO;

import DAO.RepliesDAO;
import models.Replies;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class RepliesDTO implements RepliesDAO {
    private final Sql2o sql2o;

    public RepliesDTO(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void postReply(Replies replies) {
        String sql = "INSERT INTO replies (commentid, content, createddate) VALUES (:commentId, :content, :createdDate)";
        try(Connection conn = sql2o.open()){
            long id = conn.createQuery(sql, true)
                    .bind(replies)
                    .executeUpdate()
                    .getKey(Long.class);
            replies.setReplyId(id);
        }
    }
}
