package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.ChatRepository;
import db.PersonRepositoryStub;
import domain.Message;
import domain.Person;

@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ChatRepository chatRepository = new ChatRepository();
    private PersonRepositoryStub personRepository = new PersonRepositoryStub();

    public ChatServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        String json = "";
        if (action.equals("overview")) {
            json = this.chatToJSON(chatRepository.getAll());
            System.out.println("test");
        }


        else{
            doPost(request,response);
        }
        response.setContentType("application/json");
        response.getWriter().write(json);
    }

    public String chatToJSON (List<Message> messages) throws JsonProcessingException {
        System.out.println("chattojson");
        System.out.println(messages.size());
        System.out.println(messages.get(0).getAuthor() + ":" + messages.get(0).getText());
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("mapper");
        return mapper.writeValueAsString(messages);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        String json = "";
        if (action!=null&&action.equals("overview")){
            json = this.chatToJSON(chatRepository.getAll());
            System.out.println("test");
        }
        else {
            response.setContentType("application/json");
            response.getWriter().write(json);
            Person author = (Person) request.getSession().getAttribute("user");
            String text = request.getParameter("msgtext");
            Person reciever = personRepository.get("an");
            Message newmsg = new Message(author, text, reciever);
            chatRepository.addmsg(newmsg);
            response.setContentType("text/plain");
            response.getWriter().write("" + newmsg.toString() + "");
        }
    }

}
