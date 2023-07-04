package edu.projetfinal.gestion_bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.projetfinal.gestion_bibliotheque.entity.TypeBook;

@Repository
public interface TypeofBookRepository extends JpaRepository<TypeBook, Integer> {
}
