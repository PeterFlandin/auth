package edu.projetfinal.gestion_bibliotheque.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "Loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_loan;
    
    @ManyToOne
    @MapsId("subscriberId")
    @JoinColumn(name = "Id_subscriber")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Subscriber subscriber;

    @ManyToOne
    @MapsId("copyId")
    @JoinColumn(name = "Id_copy")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Copy copy;

    @Column(name = "date_start", nullable = false)
    private Date startDate;

    @Column(name = "date_end", nullable = false)
    private Date endDate;

    public Loan() {
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id_loan=" + id_loan +
                ", subscriber=" + subscriber +
                ", copy=" + copy +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public Loan(Integer id_loan, Subscriber subscriber, Copy copy, Date startDate, Date endDate) {
        this.id_loan = id_loan;
        this.subscriber = subscriber;
        this.copy = copy;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id_loan;
    }

    public void setId(Integer id_loan) {
        this.id_loan = id_loan;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
