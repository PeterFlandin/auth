package edu.projetfinal.gestion_bibliotheque.entity;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Configuration")
public class Configuration {
    @Id
    @Column(name = "Id_configuration")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_configuration;

    @Column(name = "number_max_days", nullable = false)
    private Date numberMaxDays;

    @Column(name = "max_loan_book", nullable = false)
    private Integer maxLoanBook;

    @Override
    public String toString() {
        return "Configuration{" +
                "id=" + id_configuration +
                ", numberMaxDays=" + numberMaxDays +
                ", maxLoanBook=" + maxLoanBook +
                '}';
    }

    public Integer getId() {
        return id_configuration;
    }

    public void setId(Integer id_configuration) {
        this.id_configuration = id_configuration;
    }


    public Date getNumberMaxDays() {
        return numberMaxDays;
    }

    public void setNumberMaxDays(Date numberMaxDays) {
        this.numberMaxDays = numberMaxDays;
    }

    public Integer getMaxLoanBook() {
        return maxLoanBook;
    }

    public void setMaxLoanBook(Integer maxLoanBook) {
        this.maxLoanBook = maxLoanBook;
    }
}