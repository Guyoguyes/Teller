package DAO;

import models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryDAO {

    //create category
    void createCategory(Category category);

    // find all
    List<Category> getAllCategory();

    //findById
    Category findById(long id);

}
