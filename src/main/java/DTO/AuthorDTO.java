package DTO;

import DAO.AuthorDAO;
import models.Author;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

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
              //      .addParameter("firstname", author.getFirstName())
               //     .addParameter("lastname", author.getLastName())
                //    .addParameter("title", author.getTitle())
                    .bind(author)
                    .executeUpdate()
                    .getKey(Long.class);
            author.setAuthorId(id);
        }
    }
}
