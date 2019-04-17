package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CommentRepository;
import domain.PersonService;
import domain.Topic;
import domain.TopicService;

@WebServlet("/ControllerBlog")
public class ControllerBlog extends HttpServlet {
    /*private static final long serialVersionUID = 1L;

    private ControllerFactory controllerFactory = new ControllerFactory();
    private TopicService topicservice = new TopicService();

    public ControllerBlog() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String destination = "index.jsp";
        if (action != null) {
            RequestHandler handler;
            try {
                handler = controllerFactory.getController(action, topicservice);
                destination = handler.handleRequest(request, response);
            } catch (NotAuthorizedException exc) {
                List<String> errors = new ArrayList<String>();
                errors.add(exc.getMessage());
                request.setAttribute("errors", errors);
                destination = "index.jsp";
            }
        }
        RequestDispatcher view = request.getRequestDispatcher(destination);
        if (destination != null) {
            view.forward(request, response);
        }
    }*/
}
