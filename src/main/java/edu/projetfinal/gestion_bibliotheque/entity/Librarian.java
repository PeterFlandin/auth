package edu.projetfinal.gestion_bibliotheque.entity;

import java.util.Objects;
import java.util.Optional;

import jakarta.persistence.*;

@Entity
@Table(name = "Librarian")
public class Librarian {

    @Id
    @Column(name = "Librarian")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_Librarian;

    @Column(name = "login", nullable = false, length = 50, unique = true)
    private String login;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    public Librarian(Integer idLibrarian, String login, String password) {
		super();
		this.id_Librarian = idLibrarian;
		this.login = login;
		this.password = password;
	}

	public Librarian() {
    }

	public Integer getIdLibrarian() {
		return id_Librarian;
	}

	public void setIdLibrarian(Integer idLibrarian) {
		this.id_Librarian = idLibrarian;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_Librarian, login, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Librarian other = (Librarian) obj;
		return id_Librarian == other.id_Librarian && Objects.equals(login, other.login)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "Librarian [id_Librarian=" + id_Librarian + ", login=" + login + ", password=" + password + "]";
	}

	public boolean isPresent() {
		return false;
	}


	
}
