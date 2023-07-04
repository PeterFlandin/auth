package edu.projetfinal.gestion_bibliotheque.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_author")
    private Integer id_author;
    @Column(name = "firstname", nullable = false)
    private String firstname;

    public Author() {
    }

    public Author(String firstname) {
        this.firstname = firstname;
    }

    public Author(Integer id_author, String firstname) {
		super();
		this.id_author = id_author;
		this.firstname = firstname;
	}

	public Integer getId_author() {
        return id_author;
    }

    public void setId_author(Integer id_author) {
        this.id_author = id_author;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id_author=" + id_author +
                ", firstname='" + firstname + '\'' +
                '}';
    }
}
