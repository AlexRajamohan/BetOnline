package fr.p12.betonline.services.ServiceInterface;

import fr.p12.betonline.beans.Adherent;

/**
 * Created by zaraki on 24/02/17.
 */
public interface AdherentService {

    Iterable<Adherent> listAllAdherents();

    Adherent getAdherentById(String email);

    Adherent saveAdherent(Adherent adherent);

    void deleteAdherent(String email);

}
