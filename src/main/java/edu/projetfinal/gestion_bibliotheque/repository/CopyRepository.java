package edu.projetfinal.gestion_bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.projetfinal.gestion_bibliotheque.entity.Copy;

public interface CopyRepository extends JpaRepository<Copy, Integer> {

}
