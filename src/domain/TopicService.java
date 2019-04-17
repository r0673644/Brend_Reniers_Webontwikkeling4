package domain;

import db.CommentRepository;
import db.CommentRepositoryStub;

import java.util.List;

public class TopicService implements Service {
        private CommentRepository commentRepository = new CommentRepositoryStub();

        public TopicService(){
        }

        public Topic getTopic(String description)  {
            return getCommentRepository().getTopic(description);
        }

        public List<Topic> getAll() {
            return getCommentRepository().getAll();
        }
    @Override
    public void add(Object topic) {
            getCommentRepository().add((Topic)topic);
        }

        @Override
        public void delete(Object description) {
           //getCommentRepository().delete(description);
        }

        private CommentRepository getCommentRepository() {
            return commentRepository;
        }
}
