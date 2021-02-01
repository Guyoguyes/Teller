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
        String sql = "INSERT INTO category (cat_id, category_name) values (?, ?)";
        try(Connection conn = sql2o.open()){
            UUID id = (UUID) conn.createQuery(sql, true)
                    .bind(category)
                    .executeUpdate()
                    .getKey();
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
    public Category findbyId(UUID id) {
        String sql = "SELECT * FROM category WHERE cat_id = :cat_id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("cat_id", id)
                    .executeAndFetchFirst(Category.class);
        }
    }
}
