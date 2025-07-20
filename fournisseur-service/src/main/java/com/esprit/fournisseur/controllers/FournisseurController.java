package com.esprit.fournisseur.controllers;

import com.esprit.fournisseur.DTO.FournisseurDTO;
import com.esprit.fournisseur.services.FournisseurService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fournisseurs")
public class FournisseurController {

    private final FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @GetMapping("/{id}/test-cb")
    public String testCircuitBreaker(@PathVariable Long id) {
        return fournisseurService.testExternalServiceCircuitBreaker(id);
    }


    @GetMapping
    public List<FournisseurDTO> getAll() {
        return fournisseurService.getAll();
    }

    @GetMapping("/{id}")
    public FournisseurDTO getOne(@PathVariable Long id) {
        return fournisseurService.getById(id);
    }

    @PostMapping
    public FournisseurDTO create(@RequestBody FournisseurDTO dto) {
        return fournisseurService.save(dto);
    }

    @PutMapping("/{id}")
    public FournisseurDTO update(@PathVariable Long id, @RequestBody FournisseurDTO dto) {
        return fournisseurService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        fournisseurService.delete(id);
    }

}