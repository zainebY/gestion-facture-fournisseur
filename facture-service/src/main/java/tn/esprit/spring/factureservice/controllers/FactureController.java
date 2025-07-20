package tn.esprit.spring.factureservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.factureservice.entities.Facture;
import tn.esprit.spring.factureservice.services.FactureService;

import java.util.List;

@RestController
@RequestMapping("/api/factures")
public class FactureController {

    private final FactureService factureService;

    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }

    @GetMapping
    public List<Facture> getAll() {
        return factureService.findAll();
    }

    @GetMapping("/{id}")
    public Facture getOne(@PathVariable Long id) {
        return factureService.findById(id);
    }

    @PostMapping
    public Facture create(@RequestBody Facture facture) {
        return factureService.save(facture);
    }

    @PutMapping("/{id}")
    public Facture update(@PathVariable Long id, @RequestBody Facture facture) {
        return factureService.update(id, facture);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        factureService.delete(id);
    }

    @GetMapping("/with-fournisseur/{fournisseurId}")
    public ResponseEntity<String> getFournisseurName(@PathVariable Long fournisseurId) {
        String name = factureService.getFournisseurName(fournisseurId);
        return ResponseEntity.ok(name);
    }
}
