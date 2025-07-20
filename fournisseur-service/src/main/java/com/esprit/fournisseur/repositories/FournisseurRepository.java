package com.esprit.fournisseur.repositories;

import com.esprit.fournisseur.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
}
