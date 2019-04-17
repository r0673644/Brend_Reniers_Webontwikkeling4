package controller;


import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetFriends extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person person = (Person) request.getSession().getAttribute("user");
        List<Person> friends=person.getFriends();
        String friendsJSON = toJSON(friends);
        response.setContentType("text/json");
        try{
            response.getWriter().write(friendsJSON);
        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    private String toJSON(List<Person> friends){
        StringBuilder json = new StringBuilder();
        json.append("[");
        for(Person person: friends){
            json.append("{ \"name\" : \"");
            json.append(person.getFirstName());
            json.append(" ");
            json.append(person.getLastName());
            json.append("\", \"status\" : \"");
            json.append(person.getStatus());
            json.append("\" }, ");
        }
        json.deleteCharAt(json.length()-1);
        json.deleteCharAt(json.length()-1);
        json.append("]");
        return json.toString();
    }
}
