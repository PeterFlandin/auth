package edu.projetfinal.gestion_bibliotheque.dto;

public class SubscriberDtoForSubscriberCrud {
	private String firstname;

	private String lastname;

	private String email;

	private String address;

	private String password;

	private String login;

	public SubscriberDtoForSubscriberCrud(String firstname, String lastname, String email, String address,
			String password, String login) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.password = password;
		this.login = login;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "SubscriberDtoForSubscriberCrud [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", address=" + address + ", password=" + password + ", login=" + login + "]";
	}

}
