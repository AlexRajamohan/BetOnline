/*
package fr.p12.betonline.beans;


import fr.p12.betonline.services.ServiceInterface.InterfaceCompteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

*/
/**
 * Created by zaraki on 24/02/17.
 *//*


public class Adherent_avant extends System {

    private String login, password, nom, prenom;

    @Autowired
    private InterfaceCompteService interfaceCompteService;

    private Compte_avant compteAvant =new Compte_avant(login, password);

    protected System system;

    public System getSystem() {
        return system;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Compte_avant getCompteAvant() {
        return compteAvant;
    }

    public void setCompteAvant(Compte_avant compteAvant) {
        this.compteAvant = compteAvant;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Adherent_avant(String nom, String prenom, Compte_avant compteAvant){
        super();
        this.nom=nom;
        this.prenom=prenom;
        this.compteAvant = compteAvant;
    }
    public void crediterCompte(Float montant){

//        interfaceCompteService.crediter(this.compteAvant, montant);
        compteAvant.crediter(montant);

    }

    public void debiterCompte(Float montant){
//        interfaceCompteService.debiter(this.compteAvant, montant);

        compteAvant.debiter(montant);
    }

    public void creerPari(String objet, int mise, int nbreParticipant, Date dateLimite){
        new Pari_avant(objet,mise,nbreParticipant,dateLimite);
    }


}
*/
