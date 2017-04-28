package fr.p12.betonline.Model;


import java.util.Date;

/**
 * Created by zaraki on 24/02/17.
 */

public class Adherent extends System {

    private String login, password, nom, prenom;
    private Compte compte=new Compte(login, password);
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

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Adherent(String nom, String prenom, Compte compte){
        super();
        this.nom=nom;
        this.prenom=prenom;
        this.compte=compte;
    }
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
