package fr.p12.betonline.Service.ServiceInterface;

import fr.p12.betonline.beans.Compte;

/**
 * Created by audre on 30/04/2017.
 */
public interface CompteService {

    Iterable<Compte> listAllComptes();

    Compte getCompteById(String email);

    Compte saveCompte(Compte compte);

    void deleteCompte(String email);
}
