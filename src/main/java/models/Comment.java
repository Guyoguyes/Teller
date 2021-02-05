package models;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

public class Comment {
    private long commentId;
    private long newsId;
    private String content;
    private Timestamp commentDate;

    public Comment(long newsId, String content, Timestamp commentDate){
        this.newsId = newsId;
        this.content = content;
        this.commentDate = commentDate;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(long newsId) {
        this.newsId = newsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Timestamp commentDate) {
        this.commentDate = commentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return Objects.equals(commentId, comment1.commentId) && Objects.equals(newsId, comment1.newsId) && Objects.equals(content, comment1.content) && Objects.equals(commentDate, comment1.commentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, newsId, content, commentDate);
    }
}
