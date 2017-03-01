package fr.p12.betonline;

import fr.p12.betonline.Model.Compte;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BetOnlineApplication {

	public static void main(String[] args) {

		SpringApplication.run(BetOnlineApplication.class, args);
		Compte c1=new Compte("alex","zaraki");
		System.out.print(c1.getSolde());
	}
}
