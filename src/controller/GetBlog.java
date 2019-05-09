package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Comment;
import domain.Topic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetBlog extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        List <Topic> topics =  getTopicService().getAll();
        response.setContentType("text/json");
        try {
            String topicsJson = this.blogtoJSON(topics);
            response.setContentType("application/json");
            response.getWriter().write(topicsJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private String blogtoJSON(List<Topic> topics) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(topics);
    }
}
