package fr.p12.betonline.Service.Impl;

import fr.p12.betonline.beans.Adherent;
import fr.p12.betonline.services.ServiceInterface.PariService;

/**
 * Created by audre on 02/05/2017.
 */
public class PariImpl implements PariService {

    public boolean addAdherent(Adherent adherent){

        if (listParticipant.size() < nbreParticipant){
            listParticipant.add(adherent);
            return true;
        }
        else {
            return false;
        }

    }

    public void cloturer(){
        //A CODER
    }

}
