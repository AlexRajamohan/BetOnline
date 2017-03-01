package fr.p12.betonline.Model;

/**
 * Created by zaraki on 03/02/17.
 */
public class Compte {

    private String user, password;
    int solde=0;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public Compte(String user, String password){

        this.user=user;
        this.password=password;
    }

    public boolean authentification (String identifiant, String mdp){
        if (identifiant==user && mdp==password){
            return (true);
        }
        else{
            return(false);
        }
    }
}
