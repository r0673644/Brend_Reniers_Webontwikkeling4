package db;

import domain.Topic;

import java.util.List;

public interface CommentRepository {

    public abstract void add(Topic topic);
    public abstract Topic getTopic(String description);
    public abstract List<Topic> getAll();
}
