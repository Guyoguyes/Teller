package models;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

public class News {
    private UUID newsId;
    private UUID categoryId;
    private UUID authorId;
    private String content;
    private Timestamp createdAt;

    public News(UUID categoryId, UUID authorId, String content, Timestamp createdAt){
        this.categoryId = categoryId;
        this.authorId = authorId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public UUID getNewsId() {
        return newsId;
    }

    public void setNewsId(UUID newsId) {
        this.newsId = UUID.randomUUID();
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(newsId, news.newsId) && Objects.equals(categoryId, news.categoryId) && Objects.equals(authorId, news.authorId) && Objects.equals(content, news.content) && Objects.equals(createdAt, news.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsId, categoryId, authorId, content, createdAt);
    }
}
