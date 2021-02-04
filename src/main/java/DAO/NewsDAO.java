package DAO;

import com.google.gson.JsonElement;
import models.News;

import java.util.List;

public interface NewsDAO {

    //create news
    void createNews(News news);

    //get all news
    List<News> getAllNews();

    //get all news by category
    List<News> getAllNewsByCategory(long catid);
}
