package domain;

import java.util.List;

import db.PersonRepository;
import db.PersonRepositoryStub;

public class PersonService{
	private PersonRepository personRepository = new PersonRepositoryStub();

	public PersonService(){
	}
	
	public Person getPerson(String personId)  {
		return getPersonRepository().get(personId);
	}

	public List<Person> getAll() {
		return getPersonRepository().getAll();
	}

	public void add(Object person) {
		getPersonRepository().add((Person)person);
	}

	public void updatePersons(Person person) {
		getPersonRepository().update(person);
	}

	public void delete(Object id) {
		getPersonRepository().delete((String)id);
	}
	
	public Person getAuthenticatedUser(String email, String password) {
		return getPersonRepository().getAuthenticatedUser(email, password);
	}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}
}
