package DAO;

import models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryDAO {

    //create category
    void createCategory(Category category);


    //all category
    List<Category> findAll();

    //find by id
    Category findbyId(int id);
}
