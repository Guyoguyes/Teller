package DAO;

import com.google.gson.JsonElement;
import models.News;

import java.util.List;

public interface NewsDAO {

    //create news
    void createNews(News news);

    //get all news
    List<News> getAllNews();

    //Find by id
    News findNewsById(long newsid);

    //get all news by category
    List<News> getAllNewsByCategory(long catid);

    //get all news by author
    List<News> getAllNewsByAuthor(long authorid);

    //update votes by news
    void upVote( int likes);
}
