package domain;

import db.CommentRepository;
import db.CommentRepositoryStub;

import java.util.List;

public class TopicService implements Service {
        private CommentRepository commentRepository = new CommentRepositoryStub();

        public TopicService(){
        }

        public Topic getTopic(String description)  {
            return commentRepository.getTopic(description);
        }

        public List<Topic> getAll() {
            return commentRepository.getAll();
        }
    @Override
    public void add(Object topic) {
            commentRepository.add((Topic)topic);
        }

        @Override
        public void delete(Object description) {
           //getCommentRepository().delete(description);
        }


}
