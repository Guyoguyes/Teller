package models;

import java.io.File;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

public class News {
    private long newsId;
    private long categoryId;
    private long authorId;
    private File folioImage;
    private String header;
    private String content;
    private Timestamp createdAt;

    //TODO likes and dislike
    private int likesCount;
    private int dislikesCount;

    //TODO news image

    public News(long categoryId, long authorId, File folioImage, String header, String content, Timestamp createdAt){
        this.categoryId = categoryId;
        this.authorId = authorId;
        this.folioImage = folioImage;
        this.header = header;
        this.content = content;
        this.createdAt = createdAt;
        this.likesCount = 0;
        this.dislikesCount = 0;
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

    public File getFolioImage() {
        return folioImage;
    }

    public void setFolioImage(File folioImage) {
        this.folioImage = folioImage;
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

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getDislikesCount() {
        return dislikesCount;
    }

    public void setDislikesCount(int dislikesCount) {
        this.dislikesCount = dislikesCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return newsId == news.newsId && categoryId == news.categoryId && authorId == news.authorId && likesCount == news.likesCount && dislikesCount == news.dislikesCount && Objects.equals(header, news.header) && Objects.equals(content, news.content) && Objects.equals(createdAt, news.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsId, categoryId, authorId, header, content, createdAt, likesCount, dislikesCount);
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", categoryId=" + categoryId +
                ", authorId=" + authorId +
                ", header='" + header + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", likesCount=" + likesCount +
                ", dislikesCount=" + dislikesCount +
                '}';
    }

    // methods
    public void upvote(){
        likesCount++;
    }

    public void downvote(){
        dislikesCount++;
    }
}
