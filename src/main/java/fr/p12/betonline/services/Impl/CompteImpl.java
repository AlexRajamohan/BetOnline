package fr.p12.betonline.Service.Impl;

import fr.p12.betonline.beans.Compte;
import fr.p12.betonline.repositories.CompteRepository;
import fr.p12.betonline.services.ServiceInterface.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by audre on 30/04/2017.
 */

@Service
public class CompteImpl implements CompteService{

    private CompteRepository compteRepository;

    @Autowired
    public void setCompteRepository(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @Override
    public Iterable <Compte> listAllComptes() {
        return compteRepository.findAll();
    }


    @Override
    public Compte getCompteById(String email) {
        return compteRepository.findOne(email);
    }

    @Override
    public Compte saveCompte(Compte compte) {
        return compteRepository.save(compte);
    }


    @Override
    public void deleteCompte(String email) {
        compteRepository.delete(email);
    }

    public void crediter(float montant) {

//        compte.setSolde(compte.getSolde()+montant);
        this.solde=this.solde+montant;
    }


    public void debiter( float montant) {
//        compte.setSolde(compte.getSolde()-montant);
//        this.solde=this.solde-montant;
        compteRepository.

    }

}
