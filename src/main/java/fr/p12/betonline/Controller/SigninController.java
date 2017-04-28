package fr.p12.betonline.Controller;

import fr.p12.betonline.Model.Adherent;
import fr.p12.betonline.Model.Compte;
import fr.p12.betonline.Model.Constants;
import fr.p12.betonline.Model.Pari;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by zaraki on 14/10/16.
 */

@Controller
public class SigninController {

    private ArrayList<Pari> listPari=new ArrayList<>();
    private ArrayList<Adherent> listAdherent= new ArrayList<>();


    @RequestMapping("/log")
    public String displayLoginPage(@RequestParam(defaultValue = "", required = false) String inputName){

        System.out.println(inputName);
        return "signin/login";
    }

    @RequestMapping("/logged")
    public String displayAccountPage(Model model, @RequestParam(defaultValue = "", required = false) String inputDate){

        /*model.addAttribute("tags", Arrays.asList(Constants.tags));
        System.out.println(testMsg);*/


        System.out.println(inputDate);

        return "signin/myAccount";

    }
    @RequestMapping("/accueil")
    public String displayAccueilPage(@RequestParam(defaultValue = "", required = false) String inputName,
                                     Model model){

/*        Date date=new Date();
        String objet="Pari test";
        int mise=30;
        int nbreParticipant=8;
        String objet2="Pari test2";


        Pari pari=new Pari(objet,mise,nbreParticipant,date);
        Pari pari2=new Pari(objet2,mise,nbreParticipant,date);
        model.addAttribute("objet", objet);
        model.addAttribute("objet2", objet2);
        model.addAttribute("mise", mise);
        model.addAttribute("nbreParticipant", nbreParticipant);
        model.addAttribute("date", date);

        listPari.add(pari);
        listPari.add(pari2);
        System.out.println(inputName);*/
        model.addAttribute("listPari",listPari);

        return "general/accueil";
    }

    @RequestMapping("/creationPari")
    public String displayCreationPariPage(Model model){

        SimpleDateFormat formater = null;

        Date aujourdhui=new Date();
        formater = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(formater.format(aujourdhui));


        model.addAttribute("dateDaujourdhui", formater.format(aujourdhui));

        return "creationPari/index";
    }

    @RequestMapping("/pariCree")
    public String displayPariCreePage(@RequestParam(defaultValue = "", required = true) String inputObjetPari,
                                      @RequestParam(defaultValue = "", required = true) String inputMisePari,
                                      @RequestParam(defaultValue = "", required = true) String inputNbreParticipant,
                                      @RequestParam(defaultValue = "", required = true) String inputDate,
                                      Model model) throws ParseException {
        int misePari=Integer.parseInt(inputMisePari);
        int nbreParticipant=Integer.parseInt(inputNbreParticipant);
        SimpleDateFormat formatter = null;
        formatter=  new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(inputDate);

        Pari pari=new Pari(inputObjetPari,misePari,nbreParticipant , date);

        model.addAttribute("objet",inputObjetPari);
        model.addAttribute("mise",misePari);
        model.addAttribute("nbreParticipant",nbreParticipant);
        model.addAttribute("date",inputDate);


        System.out.println(pari.getObjet());
        System.out.println(pari.getMise());
        System.out.println(pari.getNbreParticipant());
        System.out.println(pari.getDateLimite());

        listPari.add(pari);
        model.addAttribute("listPari",listPari);


//        return "creationPari/pariCree";
        return  "general/accueil";
    }

    @RequestMapping(value="/inscription")
    public String displayInscriptionPage(){

        return "inscription/inscription";
    }

    @RequestMapping("/inscriptionValide")
    public String displayInscriptionValidePage(@RequestParam(defaultValue = "", required = false) String inputName,
                                               @RequestParam(defaultValue = "", required = false) String inputPrenom,
                                               @RequestParam(defaultValue = "", required = true) String inputEmail,
                                               @RequestParam(defaultValue = "", required = true) String inputPassword,
                                               Model model){

//        Adherent adherent = new Adherent("Raja", "Alex", new Compte("alex@gmail.com", "zaraki"));
        Adherent adherent = new Adherent(inputName, inputPrenom, new Compte(inputEmail, inputPassword));
//		adherent.getSystem().addAdherent(adherent);
        adherent.crediterCompte(Float.valueOf(30));
        System.out.println(adherent.getCompte().getUser());
        System.out.println(adherent.getCompte().getSolde());
        System.out.println(inputName);

        model.addAttribute("nom",inputName);
        model.addAttribute("prenom",inputPrenom);
        model.addAttribute("email",inputEmail);
        model.addAttribute("password",inputPassword);

        listAdherent.add(adherent);
        model.addAttribute("listAdherent", listAdherent);

        return "inscription/inscriptionValide";
    }


    @RequestMapping("/testCSS")
    public String displayTestCSS() {

        return "testCSS";
    }




}
