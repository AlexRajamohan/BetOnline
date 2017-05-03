package fr.p12.betonline.Service.Impl;

import fr.p12.betonline.Repositories.AdherentRepository;
import fr.p12.betonline.beans.Adherent;
import fr.p12.betonline.beans.Compte;
import fr.p12.betonline.beans.Pari;
import fr.p12.betonline.repositories.AdherentRepository;
import fr.p12.betonline.services.ServiceInterface.AdherentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by audre on 01/05/2017.
 */

@Service
public class AdherentImpl implements AdherentService{

    private AdherentRepository adherentRepository;
    private Compte compte= new Compte()

    @Autowired
    public void setAdherentRepository(AdherentRepository adherentRepository) {
        this.adherentRepository = adherentRepository;
    }

    @Override
    public Iterable <Adherent> listAllAdherents() {
        return adherentRepository.findAll();
    }


    @Override
    public Adherent getAdherentById(String email) {
        return AdherentRepository.findOne(email);
    }

    @Override
    public Adherent saveAdherent(Adherent adherent) {
        return adherentRepository.save(adherent);
    }


    @Override
    public void deleteAdherent(String email) {
        adherentRepository.delete(email);
    }

    /*-------*/

    public void crediterCompte(Float montant){
        compte.crediter(montant);

    }

    public void debiterCompte(Float montant){
        compte.debiter(montant);
    }

    public void creerPari(String objet, int mise, int nbreParticipant, Date dateLimite){
        new Pari(objet,mise,nbreParticipant,dateLimite);
    }
}
