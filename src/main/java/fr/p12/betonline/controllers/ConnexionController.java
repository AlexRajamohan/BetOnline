package fr.p12.betonline.controllers;

import fr.p12.betonline.beans.*;
import fr.p12.betonline.services.ServiceInterface.AdherentService;
import fr.p12.betonline.services.ServiceInterface.CompteService;
import fr.p12.betonline.services.ServiceInterface.PariService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ConnexionController {

//    private ArrayList<Pari_avant> listPariAvant =new ArrayList<>();
    /*@Autowired
    private ListPariImpl listPariAvant=new ListPariImpl();
*/

//    private ArrayList<Adherent_avant> listAdherentAvant = new ArrayList<>();

    @Autowired
    private CompteService compteService;

    @Autowired
    private AdherentService adherentService;

    @Autowired
    private PariService pariService;


    @RequestMapping(value = "/log")
    public String displayLoginPage(){



//        request.getSession().setAttribute("compte", inputEmail);


//        System.out.println(inputEmail);
//        return "redirect:/logged";
        return "signin/login";
    }

    @RequestMapping(value = "/logged", method = RequestMethod.POST)
    public String displayAccountPage(@RequestParam(value = "inputEmail") String inputEmail,
                                     @RequestParam(value = "inputPassword") String inputPassword,
                                     HttpServletRequest request){


        String pageDeRetour="log";
        Iterable<Adherent> listAdherents= adherentService.listAllAdherents();
        for (Adherent a : listAdherents){
            if(a.getEmail().equals(inputEmail) && a.getPassword().equals(inputPassword)){

                request.getSession().setAttribute("adherent", a);
                pageDeRetour="redirect:/logged";

            }
            else pageDeRetour= "log";

        }


        return pageDeRetour;





//        return "signin/login";
    }

    @RequestMapping(value = "/logged", method = RequestMethod.GET)
    public String displayAccountPage(Model model,
                                     HttpServletRequest request){

 /*       model.addAttribute("tags", Arrays.asList(Constants.tags));
        System.out.println(testMsg);

        System.out.println(inputDate);*/

/*        String compteCourant=request.getSession().getAttribute("compte").toString();

        System.out.println(compteCourant);
        System.out.println(listAdherentAvant.size());
        for (Adherent_avant a : listAdherentAvant){

            if(a.getCompteAvant().getUser().equals(compteCourant)){
                model.addAttribute("adherent1", a);

            }
        }

        model.addAttribute("session", request.getSession().getAttribute("compte"));
        model.addAttribute("listPariAvant", listPariAvant);*/

//        Adherent adherent=request.getSession().getAttribute("adherent");

        Iterable<Pari> listPari= pariService.listAllParis();

        model.addAttribute("listPari", listPari);





        return "signin/myAccount";

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









}
