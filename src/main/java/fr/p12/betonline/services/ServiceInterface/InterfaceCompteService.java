package fr.p12.betonline.services.ServiceInterface;

import fr.p12.betonline.beans.Compte_avant;

/**
 * Created by zaraki on 01/05/17.
 */
public interface InterfaceCompteService {

    public boolean authentification (String identifiant, String mdp);

    public void crediter(Compte_avant compteAvant, float montant);

    public void debiter(Compte_avant compteAvant, float montant);
}
