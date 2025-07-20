package com.esprit.fournisseur.services.servicesImpl;

import com.esprit.fournisseur.DTO.FournisseurDTO;
import com.esprit.fournisseur.client.ExternalClient;
import com.esprit.fournisseur.entities.Fournisseur;
import com.esprit.fournisseur.mapper.FournisseurMapper;
import com.esprit.fournisseur.repositories.FournisseurRepository;
import com.esprit.fournisseur.services.FournisseurService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    private final FournisseurRepository repository;
    private final  FournisseurMapper mapper;
    private final ExternalClient externalClient;  // Add this


    public FournisseurServiceImpl(FournisseurRepository repository, FournisseurMapper mapper, ExternalClient externalClient) {
        this.repository = repository;
        this.mapper = mapper;
        this.externalClient = externalClient;
    }

    @Override
    public String testExternalServiceCircuitBreaker(Long id) {
        return externalClient.callExternalService(id);
    }

    @Override
    public List<FournisseurDTO> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public FournisseurDTO getById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElse(null);
    }

    @Override
    public FournisseurDTO save(FournisseurDTO dto) {
        Fournisseur entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public FournisseurDTO update(Long id, FournisseurDTO dto) {
        dto.setId(id);
        Fournisseur entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}