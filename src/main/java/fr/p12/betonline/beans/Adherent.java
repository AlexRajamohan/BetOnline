package fr.p12.betonline.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by zaraki on 24/02/17.
 */

@Entity
@Table(name="adherent")
public class Adherent{

    @Id
    @NotNull
    @Column(name="email")
    private String login;

    @NotNull
    @Column(name="password")
    private String password;

    @NotNull
    @Column(name="nom")
    private String nom;

    @NotNull
    @Column(name="prenom")
    private String prenom;

    @NotNull
    @Column(name="compte")
    private Compte compte=new Compte(login, password);


    public Adherent(String nom, String prenom, Compte compte){
        super();
        this.nom=nom;
        this.prenom=prenom;
        this.compte=compte;
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


}
