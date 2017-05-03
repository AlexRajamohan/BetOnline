package fr.p12.betonline.beans;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by zaraki on 24/03/17.
 */
public class Pari_avant extends System{
    private String objet;

    public String getObjet() {
        return objet;
    }

    public int getMise() {
        return mise;
    }

    public int getNbreParticipant() {
        return nbreParticipant;
    }

    public Date getDateLimite() {
        return dateLimite;
    }

    public ArrayList<Adherent_avant> getListParticipant() {
        return listParticipant;
    }

    private int mise, nbreParticipant;
    private Date dateLimite;
    private ArrayList <Adherent_avant> listParticipant = new ArrayList<>();


    public Pari_avant(String objet, int mise, int nbreParticipant, Date dateLimite){
        super();
        this.objet=objet;
        this.mise=mise;
        this.nbreParticipant=nbreParticipant;
        this.dateLimite=dateLimite;

    }

    public boolean addAdherent(Adherent_avant adherentAvant){

        if (listParticipant.size() < nbreParticipant){
            listParticipant.add(adherentAvant);
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
