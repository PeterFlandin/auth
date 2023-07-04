package edu.projetfinal.gestion_bibliotheque.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Copy")
public class Copy {
    @Id
    @Column(name = "Id_copy")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_copy;

    @Column(name = "state")
    private String state;

    @ManyToOne
    @JoinColumn(name = "Id_book")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Book book;

    public Integer getId() {
        return id_copy;
    }

    public void setId(Integer id_copy) {
        this.id_copy = id_copy;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Copy{" +
                "id_copy=" + id_copy +
                ", state='" + state + '\'' +
                ", book=" + book +
                '}';
    }
}


