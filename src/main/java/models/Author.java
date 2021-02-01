package models;

import java.util.Objects;
import java.util.UUID;

public class Author {
    private UUID authorId;
    private String firstName;
    private String lastName;
    private String title;

    public Author(String firstName, String lastName, String title){
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = UUID.randomUUID();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(authorId, author.authorId) && Objects.equals(firstName, author.firstName) && Objects.equals(lastName, author.lastName) && Objects.equals(title, author.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, firstName, lastName, title);
    }
}
