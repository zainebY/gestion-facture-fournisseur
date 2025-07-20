package tn.esprit.spring.factureservice.services;

import tn.esprit.spring.factureservice.entities.Facture;

import java.util.List;

public interface FactureService {
    List<Facture> findAll();
    Facture findById(Long id);
    Facture save(Facture facture);
    Facture update(Long id, Facture facture);
    void delete(Long id);

    String getFournisseurName(Long fournisseurId);
}
