package DTO;

import DAO.AuthorDAO;
import models.Author;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class AuthorDTO implements AuthorDAO {
    private final Sql2o sql2o;

    public AuthorDTO(Sql2o sql2o){
        this.sql2o=sql2o;
    }

    @Override
    public void createAuthor(Author author) {
        System.out.println(author);
        String sql = "INSERT INTO author (firstname, lastname, title) VALUES (:firstName, :lastName, :title)";
        try(Connection conn = sql2o.open()){
            long id = (long) conn.createQuery(sql, true)
                    .bind(author)
                    .executeUpdate()
                    .getKey(Long.class);
            author.setAuthorId(id);
        }
    }

    @Override
    public List<Author> getAllAuthor() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM author")
                    .executeAndFetch(Author.class);
        }
    }

    @Override
    public Author findById(long id) {
        String sql = "SELECT * FROM author WHERE authorid = :authorId";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("authorId", id)
                    .executeAndFetchFirst(Author.class);
        }
    }
}
