package Homework3;

public class CustomerBean {
	int id;
	String firstName;
	String lastName;
	String message;
	public CustomerBean(int id, String firstName, String lastName, String message) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getMessage(){
		return message;
	}
	
	public void setMessage(String message){
		this.message = message;
	}

}
