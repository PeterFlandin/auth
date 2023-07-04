package edu.projetfinal.gestion_bibliotheque.repository;

import edu.projetfinal.gestion_bibliotheque.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
