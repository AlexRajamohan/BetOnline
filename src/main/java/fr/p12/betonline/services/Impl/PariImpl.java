package fr.p12.betonline.services.Impl;

import fr.p12.betonline.beans.Adherent;
import fr.p12.betonline.beans.Pari;
import fr.p12.betonline.repositories.AdherentRepository;
import fr.p12.betonline.repositories.PariRepository;
import fr.p12.betonline.services.ServiceInterface.CompteService;
import fr.p12.betonline.services.ServiceInterface.PariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by audre on 02/05/2017.
 */

@Service
public class PariImpl implements PariService {


    private PariRepository pariRepository;

//    private Compte compte;

    @Autowired
    public void setPariRepository(PariRepository pariRepository ) {
        this.pariRepository = pariRepository;
    }

    @Override
    public Iterable <Pari> listAllParis() {
        return pariRepository.findAll();
    }


    @Override
    public Pari getPariById(String objet) {
        return pariRepository.findOne(objet);
    }

    @Override
    public Pari savePari(Pari pari) {
        return pariRepository.save(pari);
    }


    @Override
    public void deletePari(String objet) {
        pariRepository.delete(objet);
    }

    @Override
    public boolean addAdherent(Adherent adherent/*, boolean pour*/) {
        return false;
    }


/*
    public boolean addAdherent(Adherent adherent){

        if (listParticipant.size() < nbreParticipant){
            listParticipant.add(adherent);
            return true;
        }
        else {
            return false;
        }

    }*/

    public void cloturer(){
        //A CODER
    }

}
