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
    @NotNull
    @Column(name="objet")
    private String objet;

    @NotNull
    @Column(name="mise")
    private int mise;

    @NotNull
    @Column(name="nbreMaxParticipant")
    private int nbreParticipant;

    @NotNull
    @Column(name="dateLimite")
    private Date dateLimite;

    @Column(name="participants")
    private ArrayList <Adherent> listParticipant = new ArrayList<>();


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

    public ArrayList<Adherent> getListParticipant() {
        return listParticipant;
    }




}
