package models;

import java.sql.Timestamp;
import java.util.Objects;

public class Replies{
    private long replyId;
    private long commentId;
    private String content;
    private Timestamp createdDate;

    public Replies(long commentId, String content, Timestamp createdDate) {
        this.commentId = commentId;
        this.content = content;
        this.createdDate = createdDate;
    }

    public long getReplyId() {
        return replyId;
    }

    public void setReplyId(long replyId) {
        this.replyId = replyId;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Replies replies = (Replies) o;
        return replyId == replies.replyId && commentId == replies.commentId && Objects.equals(content, replies.content) && Objects.equals(createdDate, replies.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(replyId, commentId, content, createdDate);
    }

    @Override
    public String toString() {
        return "Replies{" +
                "replyId=" + replyId +
                ", commentId=" + commentId +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
