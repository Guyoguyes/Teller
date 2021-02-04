package DTO;

import DAO.NewsDAO;
import com.google.gson.JsonElement;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class NewsDTO implements NewsDAO {
    private final Sql2o sql2o;

    public NewsDTO(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void createNews(News news) {
        System.out.println(news);
        String sql = "INSERT INTO news (catid, authorid, content, createdat) VALUES (:categoryId, :authorId, :content, :createdAt)";
        try(Connection conn = sql2o.open()){
            long id = (long) conn.createQuery(sql, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey(Long.class);
            news.setNewsId(id);
        }

    }
}
