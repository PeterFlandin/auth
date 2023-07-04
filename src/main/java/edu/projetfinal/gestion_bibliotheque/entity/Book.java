package edu.projetfinal.gestion_bibliotheque.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "Id_book")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_book;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "summary", nullable = false)
    private String summary;

    @ManyToOne
    @JoinColumn(name = "Id_author")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Author authorObj;

    @ManyToOne
    @JoinColumn(name = "Id_type_book")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TypeBook typeBook;

    @Override
    public String toString() {
        return "Book{" +
                "id_book=" + id_book +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", authorObj=" + authorObj +
                ", typeBook=" + typeBook +
                '}';
    }

    public Book() {
    }

    public Book(Integer id_book, String title, String summary,
    		Author authorObj, TypeBook typeBook) {
        this.id_book = id_book;
        this.title = title;
        this.summary = summary;
        this.authorObj = authorObj;
        this.typeBook = typeBook;
    }

    // Getters and Setters
    public Integer getId() {
        return id_book;
    }

    public Integer getId_book() {
        return id_book;
    }

    public void setId_book(Integer id_book) {
        this.id_book = id_book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Author getAuthorObj() {
        return authorObj;
    }

    public void setAuthorObj(Author authorObj) {
        this.authorObj = authorObj;
    }

    public TypeBook getTypeBook() {
        return typeBook;
    }

    public void setTypeBook(TypeBook typeBook) {
        this.typeBook = typeBook;
    }
}

