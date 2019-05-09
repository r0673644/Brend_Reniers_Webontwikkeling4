package db;

import domain.Comment;
import domain.Topic;

import java.util.List;

public interface CommentRepository {

    public abstract void add(Topic topic);
    public abstract Topic getTopic(String description);
    public abstract List<Topic> getAll();
    public abstract void addComment(int topicID, Comment comment);
    public abstract Comment getLastCommentById(int id);
}
