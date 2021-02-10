package DTO;

import DAO.CategoryDAO;
import com.google.gson.JsonElement;
import models.Category;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class CategoryDTO implements CategoryDAO {
    private final Sql2o sql2o;

    public CategoryDTO(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void createCategory(Category category) {
        System.out.println(category);
        String sql = "INSERT INTO category (categoryname) VALUES (:categoryName)";
        try(Connection conn = sql2o.open()){
            long id = (long) conn.createQuery(sql, true )
                    .bind(category)
                    .executeUpdate()
                    .getKey(Long.class);
            category.setCatId(id);
        }
    }

    @Override
    public List<Category> getAllCategory() {
        System.out.println("works");
        try(Connection conn = sql2o.open()){
         return conn.createQuery("SELECT * FROM category")
                 .executeAndFetch(Category.class);
        }
    }

    @Override
    public Category findById(long id) {
        String sql = "SELECT * FROM category WHERE catid = :catId";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("catId", id)
                    .executeAndFetchFirst(Category.class);
        }
    }

    @Override
    public JsonElement deleteCategory(long id) {
        String sql = "DELETE FROM category WHERE categoryid = :catId";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("catId", id)
                    .executeUpdate();
        }
        return null;
    }
}
