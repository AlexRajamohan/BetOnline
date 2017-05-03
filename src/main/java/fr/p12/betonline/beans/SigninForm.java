package fr.p12.betonline.beans;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by audrey on 31/03/2017.
 */
@Entity
@Table(name="compte")
public class SigninForm implements Serializable {

    @Id
    @NotNull
    @Column(name="email")
    /*@Pattern(regexp = "^a-zA-Z+a-zA-Z0-9\\._-*a-zA-Z0-9@a-zA-Z0-9a-zA-Z0-9\\._-*a-zA-Z0-9+\\.a-zA-Z{2,4}$")*/
    private String email;

    @NotNull
    @Column(name="password")
    private String password;

    public SigninForm(String email, String password){

        this.email = email;
        this.password = password;
    }

    public SigninForm(){
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

}
