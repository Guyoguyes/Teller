package models;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

public class Comment {
    private UUID commentId;
    private UUID newsId;
    private String comment;
    private Timestamp commentDate;

    public Comment(UUID newsId, String comment, Timestamp commentDate){
        this.newsId = newsId;
        this.comment = comment;
        this.commentDate = commentDate;
    }

    public UUID getCommentId() {
        return commentId;
    }

    public void setCommentId(UUID commentId) {
        this.commentId = UUID.randomUUID();
    }

    public UUID getNewsId() {
        return newsId;
    }

    public void setNewsId(UUID newsId) {
        this.newsId = newsId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        return Objects.equals(commentId, comment1.commentId) && Objects.equals(newsId, comment1.newsId) && Objects.equals(comment, comment1.comment) && Objects.equals(commentDate, comment1.commentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, newsId, comment, commentDate);
    }
}
