package fr.p12.betonline.beans;

/**
 * Created by zaraki on 03/02/17.
 */
public class Compte_avant {

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
    public void setSolde(float solde) {
        this.solde = solde;
    }

    public Compte_avant(String user, String password){

        this.user=user;
        this.password=password;
    }


    public void crediter(float montant) {

//        compte.setSolde(compte.getSolde()+montant);
        this.solde=this.solde+montant;
    }


    public void debiter( float montant) {
//        compte.setSolde(compte.getSolde()-montant);
        this.solde=this.solde-montant;

    }

}
