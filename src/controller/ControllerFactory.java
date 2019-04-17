package controller;

import domain.PersonService;

public class ControllerFactory {
	
    public RequestHandler getController(String key, PersonService service) {
        return createHandler(key, service);
    }
    
	private RequestHandler createHandler(String handlerName, PersonService service) {
		RequestHandler handler = null;
		try {
			Class<?> handlerClass = Class.forName("controller."+ handlerName);
			Object handlerObject = handlerClass.newInstance();
			handler = (RequestHandler) handlerObject;
				handler.setModel(service);

		} catch (Exception e) {
			throw new RuntimeException("Deze pagina bestaat niet!!!!");
		}
		return handler;
	}


}
