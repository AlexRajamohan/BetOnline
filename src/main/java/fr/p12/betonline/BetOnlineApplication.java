package fr.p12.betonline;

import fr.p12.betonline.Model.Adherent;
import fr.p12.betonline.Model.Compte;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class BetOnlineApplication {

	public static void main(String[] args) throws ParseException {

		SpringApplication.run(BetOnlineApplication.class, args);
		;
//		System.out.println(adherent.getSystem().getList());

		/*Compte c1=new Compte("alex@gmail.com","zaraki");
		c1.crediter(30);
		c1.debiter((float) 8.36);
		System.out.println(c1.getSolde());

		Date aujd =new Date();


		Date date =new SimpleDateFormat("yyyy/MM/dd").parse("2007/01/01");



		System.out.println(date);

		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
				DateFormat.SHORT,
				DateFormat.SHORT);
		System.out.println(shortDateFormat.format(aujd));

*/
	}

}
