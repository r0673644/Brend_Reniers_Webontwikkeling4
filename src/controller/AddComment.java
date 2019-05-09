package controller;

import domain.Comment;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

public class AddComment extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String person = request.getParameter("author");
        String text = request.getParameter("commentText");
        String rating = request.getParameter("rating");
        String topicnr = request.getParameter("topic");

        int ratingInt = Integer.parseInt(rating);
        int topicInt = Integer.parseInt(topicnr);

        try {
            Person author = getPersonService().getPerson(person + "@ucll.be");

            Comment comment = new Comment(author, text, ratingInt);
            getTopicService().addComment(topicInt, comment);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"author not yet registered, please register or use an registered name.");
        }
        Comment c = getTopicService().getLastCommentById(topicInt);
        System.out.println(c.getComment());
       return null;
    }
}
