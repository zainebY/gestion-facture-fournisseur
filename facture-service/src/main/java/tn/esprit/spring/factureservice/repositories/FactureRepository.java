package tn.esprit.spring.factureservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.factureservice.entities.Facture;

public interface FactureRepository extends JpaRepository<Facture,Long> {
}
