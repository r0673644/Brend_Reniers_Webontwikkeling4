package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetStatus extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person person = (Person) request.getSession().getAttribute("user");
        String status = person.getStatus();
        System.out.println(status + " / in getstatus");
        String statusJSON = this.toJSON(status);
        response.setContentType("text/json");
        try {
            response.getWriter().write(statusJSON);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String toJSON(String status) {
        StringBuffer json = new StringBuffer();

        json.append("{ \"status\" : \"");
        json.append(status);
        json.append("\"}");

        return json.toString();
    }
}
