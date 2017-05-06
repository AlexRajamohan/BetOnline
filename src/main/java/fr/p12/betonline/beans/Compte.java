package fr.p12.betonline.beans;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by audrey on 31/03/2017.
 */
@Entity
@Table(name="compte")
public class Compte implements Serializable {

    @Id
    @Column(name="email")
    /*@Pattern(regexp = "^a-zA-Z+a-zA-Z0-9\\._-*a-zA-Z0-9@a-zA-Z0-9a-zA-Z0-9\\._-*a-zA-Z0-9+\\.a-zA-Z{2,4}$")*/
    private String email;

    @Column(name="password")
    private String password;



    @Column(name="solde")
    private float solde=0;

    public Compte(String email, String password){


        this.email = email;
        this.password = password;
    }

    public Compte(){
    }
        public float getSolde() {
            return solde;
        }

        public void setSolde(float solde) {
            this.solde = solde;
        }
        public String getEmail() {
            return email;
        }
        /**
         * Setter for parameter email.
         * @param email the email to set
         */
        public void setEmail(String email) {
            this.email = email;
        }
        /**
         * Getter for parameter password.
         * @return the password
         */
        public String getPassword() {
            return password;
        }
        /**
         * Setter for parameter password.
         * @param password the password to set
         */
        public void setPassword(String password) {
            this.password = password;
        }


    public void crediter(float montant) {

//        compte.setSolde(compte.getSolde()+montant);
        this.solde=this.solde+montant;
    }


    public void debiter( float montant) {
//        compte.setSolde(compte.getSolde()-montant);
        this.solde=this.solde-montant;
//        compte.setSolde(compte.getSolde()-montant);


    }

}
