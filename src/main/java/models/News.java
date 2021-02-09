package models;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

public class News {
    private long newsId;
    private long categoryId;
    private long authorId;
    private String header;
    private String content;
    private Timestamp createdAt;

    //TODO news image

    public News(long categoryId, long authorId, String header, String content, Timestamp createdAt){
        this.categoryId = categoryId;
        this.authorId = authorId;
        this.header = header;
        this.content = content;
        this.createdAt = createdAt;
    }

    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(long newsId) {
        this.newsId = newsId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
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

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", categoryId=" + categoryId +
                ", authorId=" + authorId +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
