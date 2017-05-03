package fr.p12.betonline.controllers;

import fr.p12.betonline.beans.Adherent_avant;
import fr.p12.betonline.beans.Compte_avant;
import fr.p12.betonline.beans.Pari_avant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by zaraki on 14/10/16.
 */

@Controller
public class SigninController {

    private ArrayList<Pari_avant> listPariAvant =new ArrayList<>();
    /*@Autowired
    private ListPariImpl listPariAvant=new ListPariImpl();
*/

    private ArrayList<Adherent_avant> listAdherentAvant = new ArrayList<>();


    @RequestMapping(value = "/log")
    public String displayLoginPage(){

//        request.getSession().setAttribute("compte", inputEmail);


//        System.out.println(inputEmail);
//        return "redirect:/logged";
        return "signin/login";
    }

    @RequestMapping(value = "/logged", method = RequestMethod.POST)
    public String displayAccountPage(@RequestParam(value = "inputEmail") String inputEmail, HttpServletRequest request){

        request.getSession().setAttribute("compte", inputEmail);

/*        String compteCourant=request.getSession().getAttribute("compte").toString();
        System.out.println(compteCourant);

        System.out.println(inputEmail);*/
        return "redirect:/logged";
//        return "signin/login";
    }

    @RequestMapping(value = "/logged", method = RequestMethod.GET)
    public String displayAccountPage(Model model,
                                     HttpServletRequest request){

 /*       model.addAttribute("tags", Arrays.asList(Constants.tags));
        System.out.println(testMsg);

        System.out.println(inputDate);*/

        String compteCourant=request.getSession().getAttribute("compte").toString();

        System.out.println(compteCourant);
        System.out.println(listAdherentAvant.size());
        for (Adherent_avant a : listAdherentAvant){

            if(a.getCompteAvant().getUser().equals(compteCourant)){
                model.addAttribute("adherent1", a);

            }
        }

        model.addAttribute("session", request.getSession().getAttribute("compte"));
        model.addAttribute("listPariAvant", listPariAvant);




        return "signin/myAccount";

    }


    @RequestMapping("/creationPari")
    public String displayCreationPariPage(Model model){

        SimpleDateFormat formater = null;

        Date aujourdhui=new Date();
        formater = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(formater.format(aujourdhui));


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

        Pari_avant pariAvant =new Pari_avant(inputObjetPari,misePari,nbreParticipant , date);

        model.addAttribute("objet",inputObjetPari);
        model.addAttribute("mise",misePari);
        model.addAttribute("nbreParticipant",nbreParticipant);
        model.addAttribute("date",inputDate);


/*
        System.out.println(pariAvant.getObjet());
        System.out.println(pariAvant.getMise());
        System.out.println(pariAvant.getNbreParticipant());
        System.out.println(pariAvant.getDateLimite());
*/

        listPariAvant.add(pariAvant);
        model.addAttribute("listPariAvant", listPariAvant);

        model.addAttribute("adherent1", listAdherentAvant.get(0));



//        return "creationPari/pariCree";
        return  "signin/myAccount";
    }
/*
    @RequestMapping(value = "/miser")
    public String displayAccountPage(@RequestParam() String buttonMiser){


        for (Pari_avant p : listPariAvant){
            if(p.equals(buttonMiser)){
                p.addAdherent()
            }

        }
        return "signin/myAccount";
    }*/

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

//        Adherent_avant adherentAvant = new Adherent_avant("Raja", "Alex", new Compte_avant("alex@gmail.com", "zaraki"));
        Adherent_avant adherentAvant = new Adherent_avant(inputName, inputPrenom, new Compte_avant(inputEmail, inputPassword));
//		adherentAvant.getSystem().addAdherent(adherentAvant);
        adherentAvant.crediterCompte(Float.valueOf(30));
        System.out.println(adherentAvant.getCompteAvant().getUser());
        System.out.println(adherentAvant.getCompteAvant().getSolde());
        System.out.println(inputName);

        model.addAttribute("nom",inputName);
        model.addAttribute("prenom",inputPrenom);
        model.addAttribute("email",inputEmail);
        model.addAttribute("password",inputPassword);

        listAdherentAvant.add(adherentAvant);
        model.addAttribute("listAdherentAvant", listAdherentAvant);

        return "inscription/inscriptionValide";
    }


    @RequestMapping("/testCSS")
    public String displayTestCSS() {

        return "testCSS";
    }




}
