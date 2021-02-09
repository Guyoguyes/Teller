package DAO;

import models.Replies;

public interface RepliesDAO {

    //create a reply to a comment
    void postReply(Replies replies);
}
