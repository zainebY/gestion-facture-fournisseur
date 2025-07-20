package com.esprit.fournisseur.mapper;


import com.esprit.fournisseur.DTO.FournisseurDTO;
import com.esprit.fournisseur.entities.Fournisseur;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FournisseurMapper {
    FournisseurDTO toDto(Fournisseur entity);
    Fournisseur toEntity(FournisseurDTO dto);
    List<FournisseurDTO> toDtoList(List<Fournisseur> entities);
}

