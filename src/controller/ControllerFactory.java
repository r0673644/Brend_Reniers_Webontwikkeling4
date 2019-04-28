package controller;

import domain.PersonService;
import domain.TopicService;

public class ControllerFactory {
	
    public RequestHandler getController(String key, PersonService personService, TopicService topicService) {
        return createHandler(key, personService, topicService);
    }
    
	private RequestHandler createHandler(String handlerName, PersonService personService, TopicService topicService) {
		RequestHandler handler = null;
		try {
			Class<?> handlerClass = Class.forName("controller."+ handlerName);
			Object handlerObject = handlerClass.newInstance();
			handler = (RequestHandler) handlerObject;
			handler.setTopicService(topicService);
			handler.setModel(personService);

		} catch (Exception e) {
			throw new RuntimeException("Deze pagina bestaat niet!!!!");
		}
		return handler;
	}


}
