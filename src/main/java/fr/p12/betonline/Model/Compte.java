package fr.p12.betonline.Model;

/**
 * Created by zaraki on 03/02/17.
 */
public class Compte {

    private String user, password;

    public Compte(String user, String password){

        this.user=user;
        this.password=password;
    }

    public boolean athentification (String identifiant, String mdp){
        if (identifiant==user && mdp==password){
            return (true);
        }
        else{
            return(false);
        }
    }
}
