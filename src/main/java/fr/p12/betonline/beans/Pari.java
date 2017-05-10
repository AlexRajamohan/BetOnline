package fr.p12.betonline.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by zaraki on 24/03/17.
 */

@Entity
@Table(name="pari")
public class Pari{

    @Id
    @Column(name="objet")
    private String objet;

    @Column(name="mise")
    private int mise;

    @Column(name="nbre_max_participant")
    private int nbreParticipant;

    @Column(name="date_limite")
    private Date dateLimite;

    @Column(name="participants_pour")
    private ArrayList <Adherent> listParticipantPour = new ArrayList<Adherent>();



    @Column(name="participants_contre")
    private ArrayList <Adherent> listParticipantContre = new ArrayList<Adherent>();


    @Column(name = "resultat")
    private boolean resultat;


    public Pari(){}

    public Pari(String objet, int mise, int nbreParticipant, Date dateLimite){
        super();
        this.objet=objet;
        this.mise=mise;
        this.nbreParticipant=nbreParticipant;
        this.dateLimite=dateLimite;

    }



    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public int getMise() {
        return mise;
    }

    public void setMise(int mise) {
        this.mise = mise;
    }

    public int getNbreParticipant() {
        return nbreParticipant;
    }

    public void setNbreParticipant(int nbreParticipant) {
        this.nbreParticipant = nbreParticipant;
    }

    public Date getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }

    public ArrayList<Adherent> getListParticipantPour() {
        return listParticipantPour;
    }

    public void setListParticipantPour(ArrayList<Adherent> listParticipantPour) {
        this.listParticipantPour = listParticipantPour;
    }

    public ArrayList<Adherent> getListParticipantContre() {
        return listParticipantContre;
    }

    public void setListParticipantContre(ArrayList<Adherent> listParticipantContre) {
        this.listParticipantContre = listParticipantContre;
    }


    public boolean isResultat() {
        return resultat;
    }

    public void setResultat(boolean resultat) {
        this.resultat = resultat;
    }



}
