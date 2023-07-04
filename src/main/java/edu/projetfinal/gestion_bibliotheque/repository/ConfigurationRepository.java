package edu.projetfinal.gestion_bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.projetfinal.gestion_bibliotheque.entity.Configuration;

public interface ConfigurationRepository extends JpaRepository<Configuration, Integer> {

}
