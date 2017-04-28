package fr.p12.betonline.Model;

/**
 * Created by zaraki on 03/02/17.
 */
public class Compte {

    private String user, password;
    float solde=0;

    public String getUser() {
        return user;
    }

    //Le nom du'utilisateur (ou login) ne peut être changé
//    public void setUser(String user) {
//        this.user = user;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getSolde() {
        return solde;
    }

    //Le solde est modifiable uniquement en creditant ou debitant son compte
//    public void setSolde(float solde) {
//        this.solde = solde;
//    }

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

    public void crediter(float montant){
        this.solde=this.solde+montant;
    }

    public void debiter(float montant){
        this.solde=this.solde-montant;
    }
}
