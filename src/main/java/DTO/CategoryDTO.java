package DTO;

import DAO.CategoryDAO;
import models.Category;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class CategoryDTO implements CategoryDAO {
    private final Sql2o sql2o;

    public CategoryDTO(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void createCategory(Category category) {
        System.out.println(category);
        String sql = "INSERT INTO category (category_name) VALUES (:categoryName)";
        try(Connection conn = sql2o.open()){
            long id = (long) conn.createQuery(sql, true )
                    .bind(category)
                    .executeUpdate()
                    .getKey(Long.class);
            category.setCatId(id);
        }
    }

    @Override
    public List<Category> findAll() {
        String sql = "SELECT * FROM category";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(Category.class);
        }
    }

    @Override
    public Category findbyId(int id) {
        String sql = "SELECT * FROM category WHERE catId = :catId";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("catId", id)
                    .executeAndFetchFirst(Category.class);
        }
    }
}
