package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.*;

import java.io.IOException;

public abstract class RequestHandler {
	
	private PersonService personService;
	private TopicService topicService;
	
	public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void setModel (PersonService personService) {
		this.personService = personService;
	}
	public void setTopicService(TopicService topicService){this.topicService=topicService;}

	public PersonService getPersonService() {
		return personService;
	}
	public TopicService getTopicService(){ return topicService; }
	
	protected boolean isFromUserWithRole (HttpServletRequest request, Role role) {
		Person person = (Person) request.getSession().getAttribute("user");
		if (person != null && person.getRole().equals(role)) {
			return true;
		}
		return false;
	}

}
