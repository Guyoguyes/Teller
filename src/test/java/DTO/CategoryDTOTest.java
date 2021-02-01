package DTO;

import models.Category;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class CategoryDTOTest {
    private Connection conn;
    private CategoryDTO categoryDTO;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/schema.sql";
        Sql2o sql2o = new Sql2o(connectionString, "","");
        categoryDTO = new CategoryDTO(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void savesCategoryToDatabaseCorrectly() throws Exception {
        Category category = setUpAssistant();
        categoryDTO.createCategory(category);
        assertEquals("Business", category.getCategoryName());
    }

    //helper method
    public Category setUpAssistant(){
        return new Category("Business");
    }
}