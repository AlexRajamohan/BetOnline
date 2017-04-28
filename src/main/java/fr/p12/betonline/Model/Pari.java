package fr.p12.betonline.Model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by zaraki on 24/03/17.
 */
public class Pari extends System{
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

    public ArrayList<Adherent> getListParticipant() {
        return listParticipant;
    }

    private int mise, nbreParticipant;
    private Date dateLimite;
    private ArrayList <Adherent> listParticipant = new ArrayList<>();


    public Pari(String objet, int mise, int nbreParticipant, Date dateLimite){
        super();
        this.objet=objet;
        this.mise=mise;
        this.nbreParticipant=nbreParticipant;
        this.dateLimite=dateLimite;

    }

    public boolean addAdherent(Adherent adherent){

        if (listParticipant.size() < nbreParticipant){
            listParticipant.add(adherent);
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
