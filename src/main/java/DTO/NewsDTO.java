package DTO;

import DAO.NewsDAO;
import com.google.gson.JsonElement;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class NewsDTO implements NewsDAO {
    private final Sql2o sql2o;

    public NewsDTO(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void createNews(News news) {
        //debug purpose
        System.out.println(news);
        String sql = "INSERT INTO news (categoryid, authorid, content, createdat) VALUES (:categoryId, :authorId, :content, :createdAt)";
        try(Connection conn = sql2o.open()){
            long id = (long) conn.createQuery(sql, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey(Long.class);
            news.setNewsId(id);
        }
    }

    @Override
    public News findNewsById(long newsid) {
        String sql = "SELECT * FROM news WHERE newsid = :newsId";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("newsId", newsid)
                    .executeAndFetchFirst(News.class);
        }
    }

    @Override
    public List<News> getAllNews() {
        try(Connection conn = sql2o.open()){
            //debug purpose
            System.out.println("Found status ok");
            return conn.createQuery("SELECT * FROM news")
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public List<News> getAllNewsByCategory(long catid) {
        String sql = "SELECT * FROM news WHERE categoryid = :catId";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("catId", catid)
                    .executeAndFetch(News.class);
        }
    }
}
