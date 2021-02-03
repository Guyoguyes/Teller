package DAO;

import models.Author;

import java.util.List;

public interface AuthorDAO {
    //create author
    void createAuthor(Author author);

    //find all
    List<Author> getAllAuthor();

    //find by id
    Author findById(long id);
}
