package edu.projetfinal.gestion_bibliotheque.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Subscriber")
public class Subscriber {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id_subscriber")
	private Integer id_subscriber;

	@Column(name = "date_start_sanction")
	private Date dateStartSanction;

	@Column(name = "date_end_sanction")
	private Date dateEndSanction;

	@Column(name = "number_offences")
	private Integer numberOffences;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "login", unique = true)
	private String login;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "e_mail")
	private String email;

	@Column(name = "address")
	private String address;

	@Column(name = "password")
	private String password;

	public Subscriber() {
		super();
	}

	public Subscriber(Integer id_subscriber, Date dateStartSanction, Date dateEndSanction, Integer numberOffences,
			String firstname, String login, String lastname, String email, String address, String password) {
		super();
		this.id_subscriber = id_subscriber;
		this.dateStartSanction = dateStartSanction;
		this.dateEndSanction = dateEndSanction;
		this.numberOffences = numberOffences;
		this.firstname = firstname;
		this.login = login;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.password = password;
	}

	public Integer getId_subscriber() {
		return id_subscriber;
	}

	public void setId_subscriber(Integer id_subscriber) {
		this.id_subscriber = id_subscriber;
	}

	public Date getDateStartSanction() {
		return dateStartSanction;
	}

	public void setDateStartSanction(Date dateStartSanction) {
		this.dateStartSanction = dateStartSanction;
	}

	public Date getDateEndSanction() {
		return dateEndSanction;
	}

	public void setDateEndSanction(Date dateEndSanction) {
		this.dateEndSanction = dateEndSanction;
	}

	public Integer getNumberOffences() {
		return numberOffences;
	}

	public void setNumberOffences(Integer numberOffences) {
		this.numberOffences = numberOffences;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	@Override
		public int hashCode() {
		return Objects.hash(address, dateEndSanction, dateStartSanction, email, firstname, id_subscriber, lastname,
				login, numberOffences, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscriber other = (Subscriber) obj;
		return Objects.equals(address, other.address) && Objects.equals(dateEndSanction, other.dateEndSanction)
				&& Objects.equals(dateStartSanction, other.dateStartSanction) && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && id_subscriber == other.id_subscriber
				&& Objects.equals(lastname, other.lastname) && Objects.equals(login, other.login)
				&& numberOffences == other.numberOffences && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "Subscriber [id_subscriber=" + id_subscriber + ", dateStartSanction=" + dateStartSanction
				+ ", dateEndSanction=" + dateEndSanction + ", numberOffences=" + numberOffences + ", firstname="
				+ firstname + ", login=" + login + ", lastname=" + lastname + ", email=" + email + ", address="
				+ address + ", password=" + password + "]";
	}

}
