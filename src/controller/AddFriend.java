package controller;

import db.DbException;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddFriend extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person person=(Person) request.getSession().getAttribute("user");
        String friendId =request.getParameter("friendId");
        Person friend = getPersonService().getPerson(friendId+"@ucll.be");

        boolean reedstoegevoegd=false;

        for(Person p: person.getFriends() ){
            if(p.getUserId().equals(friend.getUserId())){
                reedstoegevoegd=true;
            }
        }
        if(person.getUserId().equals(friend.getUserId())){
            reedstoegevoegd=true;
        }
        if(reedstoegevoegd==false ){
            person.addFriend(friend);
            friend.addFriend(person);
        }
        return null;
    }
}
