package fr.p12.betonline.services.Impl;

import fr.p12.betonline.repositories.AdherentRepository;
import fr.p12.betonline.beans.Adherent;
import fr.p12.betonline.beans.Compte;
import fr.p12.betonline.beans.Pari;
import fr.p12.betonline.services.ServiceInterface.AdherentService;
import fr.p12.betonline.services.ServiceInterface.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by audre on 01/05/2017.
 */

@Service
public class AdherentImpl implements AdherentService{

    private AdherentRepository adherentRepository;
    private CompteService compteService;
//    private Compte compte;

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
        return adherentRepository.findOne(email);
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





    public void creerPari(String objet, int mise, int nbreParticipant, Date dateLimite){
        new Pari(objet,mise,nbreParticipant,dateLimite);
    }
}
