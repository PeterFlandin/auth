package edu.projetfinal.gestion_bibliotheque.repository;

import edu.projetfinal.gestion_bibliotheque.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
