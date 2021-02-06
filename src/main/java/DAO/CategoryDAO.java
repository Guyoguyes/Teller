package DAO;

import com.google.gson.JsonElement;
import models.Category;

import java.util.List;

public interface CategoryDAO {

    //create category
    void createCategory(Category category);

    // find all
    List<Category> getAllCategory();

    //findById
    Category findById(long id);

    //delete by id
    JsonElement deleteCategory(long id);

}
