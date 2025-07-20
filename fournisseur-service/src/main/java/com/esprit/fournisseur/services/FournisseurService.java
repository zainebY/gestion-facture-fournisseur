package com.esprit.fournisseur.services;


import com.esprit.fournisseur.DTO.FournisseurDTO;

import java.util.List;

public interface FournisseurService {
    String testExternalServiceCircuitBreaker(Long id);

    List<FournisseurDTO> getAll();
    FournisseurDTO getById(Long id);
    FournisseurDTO save(FournisseurDTO dto);
    FournisseurDTO update(Long id, FournisseurDTO dto);
    void delete(Long id);
}
