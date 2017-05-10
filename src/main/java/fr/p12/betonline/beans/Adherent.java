package fr.p12.betonline.beans;


import fr.p12.betonline.services.ServiceInterface.AdherentService;
import fr.p12.betonline.services.ServiceInterface.CompteService;
import fr.p12.betonline.services.ServiceInterface.PariService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by zaraki on 24/02/17.
 */

@Entity
@Table(name="adherent")
public class Adherent implements Serializable {



    @Id
    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name="compte")
    private Compte compte=new Compte(email, password);



    public Adherent(String email, String password, String nom, String prenom, Compte compte){
        this.email=email;
        this.password=password;
        this.nom=nom;
        this.prenom=prenom;
        this.compte=compte;
    }

    public Adherent(){
         new Compte();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void crediterCompte(Float montant){
        compte.crediter(montant);

    }

    public void debiterCompte(Float montant){
        compte.debiter(montant);
    }


/*    public boolean participe(Pari pari){

        boolean exist=false;
        for (Adherent a : pari.getListParticipantPour()) {
            for (Adherent ad : pari.getListParticipantContre()){
                if (this.equals(a)) {
                    exist = true;
                }else if (this.equals(ad)){
                    exist=true;
                }
            }

        }
*//*        for (Adherent ad : pari.getListParticipantContre()) {
            if (this.equals(ad)) {
                exist = true;
            }
        }*//*
            return exist;
    }*/

    public boolean participe(Pari pari){

        if(this.containedPour(pari)==false && this.containedContre(pari)==false){
            return  false;

        }else return true;



    }

    public boolean containedPour(Pari pari){

        boolean contained=false;
        for (Adherent a : pari.getListParticipantPour()){
            if(this.equals(a)){
                contained=true;
            }
        }
        return contained;

    }

    public boolean containedContre(Pari pari){

        boolean contained=false;
        for (Adherent a : pari.getListParticipantPour()){
            if(this.equals(a)){
                contained=true;
            }
        }
        return contained;
    }
}

