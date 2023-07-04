package edu.projetfinal.gestion_bibliotheque.repository;

import edu.projetfinal.gestion_bibliotheque.entity.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
}
