package edu.projetfinal.gestion_bibliotheque.repository;

import edu.projetfinal.gestion_bibliotheque.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Integer> {
}
