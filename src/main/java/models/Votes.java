package models;

import java.util.Objects;

public class Votes {
    private long voteId;
    private long newsId;
    private int votes;


    public Votes(long newsId, int votes) {
        this.newsId = newsId;
        this.votes = votes;
    }

    public long getVoteId() {
        return voteId;
    }

    public void setVoteId(long voteId) {
        this.voteId = voteId;
    }

    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(long newsId) {
        this.newsId = newsId;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Votes votes1 = (Votes) o;
        return voteId == votes1.voteId && newsId == votes1.newsId && votes == votes1.votes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(voteId, newsId, votes);
    }

    @Override
    public String toString() {
        return "Votes{" +
                "voteId=" + voteId +
                ", newsId=" + newsId +
                ", votes=" + votes +
                '}';
    }
}
