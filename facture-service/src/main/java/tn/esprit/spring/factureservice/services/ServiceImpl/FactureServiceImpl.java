package tn.esprit.spring.factureservice.services.ServiceImpl;

import org.springframework.stereotype.Service;
import tn.esprit.spring.factureservice.client.FournisseurClient;
import tn.esprit.spring.factureservice.entities.Facture;
import tn.esprit.spring.factureservice.repositories.FactureRepository;
import tn.esprit.spring.factureservice.services.FactureService;

import java.util.List;

@Service
public class FactureServiceImpl implements FactureService {

    private final FactureRepository factureRepository;
    private final FournisseurClient fournisseurClient;


    public FactureServiceImpl(FactureRepository factureRepository, FournisseurClient fournisseurClient) {
        this.factureRepository = factureRepository;
        this.fournisseurClient = fournisseurClient;
    }

    @Override
    public List<Facture> findAll() {
        return factureRepository.findAll();
    }

    @Override
    public Facture findById(Long id) {
        return factureRepository.findById(id).orElse(null);
    }

    @Override
    public Facture save(Facture facture) {
        return factureRepository.save(facture);
    }

    @Override
    public Facture update(Long id, Facture updated) {
        updated.setId(id);
        return factureRepository.save(updated);
    }

    @Override
    public void delete(Long id) {
        factureRepository.deleteById(id);
    }

    @Override
    public String getFournisseurName(Long fournisseurId) {
        return fournisseurClient.getFournisseurName(fournisseurId);
    }
}