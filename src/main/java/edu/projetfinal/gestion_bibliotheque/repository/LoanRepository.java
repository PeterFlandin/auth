package edu.projetfinal.gestion_bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.projetfinal.gestion_bibliotheque.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
