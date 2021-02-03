package DAO;

import models.Author;

import java.util.List;

public interface AuthorDAO {
    //create author
    void createAuthor(Author author);

    List<Author> getAllAuthor();
}
