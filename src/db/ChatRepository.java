package db;

import domain.Message;
import domain.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChatRepository {

    private List<Message> messages = new ArrayList<Message>();
    PersonRepository personRepository = new PersonRepositoryStub();

    public ChatRepository() {
        super();
        Message m1 = new Message( ((PersonRepositoryStub)personRepository).get("jan@ucll.be"), "Hey!", ((PersonRepositoryStub)personRepository).get("an@ucll.be"));
        messages.add(m1);
        Message m2 = new Message( ((PersonRepositoryStub)personRepository).get("an@ucll.be"), "Hi, how are you doing?", ((PersonRepositoryStub)personRepository).get("jan@ucll.be"));
        messages.add(m2);
        Message m3 = new Message( ((PersonRepositoryStub)personRepository).get("jan@ucll.be"), "I'am doing fantastic", ((PersonRepositoryStub)personRepository).get("an@ucll.be"));
        messages.add(m3);
    }

    public List<Message> getAll () {
        return messages;
    }

    public void addmsg(Message newmsg) {
        messages.add(newmsg);
    }
}

