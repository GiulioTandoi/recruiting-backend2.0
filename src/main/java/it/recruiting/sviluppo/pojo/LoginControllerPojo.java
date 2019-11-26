package it.recruiting.sviluppo.pojo;

public class LoginControllerPojo { //Questa classe mi serve quando devo passare nel responseBody della post un solo oggetto e non separatamnente 
	//email e password e quindi mi creo quest'oggetto
	
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	
	public LoginControllerPojo(String email, String password) {
		this.email=email;
		this.password=password;
	}

	
	

}
