import DTO.CategoryDTO;
import com.google.gson.Gson;
import models.Category;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;


public class Main {
    public static void main(String[] args) {
        CategoryDTO categoryDTO;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://localhost:5432/tellernews";
        Sql2o sql2o = new Sql2o(connectionString, "guyo","password");
        categoryDTO = new CategoryDTO(sql2o);
        conn = sql2o.open();

        post("/api/category", "application/json", (req, res) ->{
            Category category = gson.fromJson(req.body(), Category.class);
            categoryDTO.createCategory(category);
            res.status(201);
            res.type("application/json");
            return gson.toJson(category);
        });

        get("/api/category", "application/json", (req, res) ->{
            res.type("application/json");
            return gson.toJson(categoryDTO.findAll());
        });
    }
}
