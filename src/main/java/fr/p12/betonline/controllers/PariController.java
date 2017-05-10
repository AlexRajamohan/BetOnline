package fr.p12.betonline.controllers;

import fr.p12.betonline.beans.Adherent;
import fr.p12.betonline.beans.Compte;
import fr.p12.betonline.beans.Pari;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by zaraki on 07/05/17.
 */

@Controller
@RequestMapping(value = "/miser")
public class PariController {

    @Autowired
    private PariService pariService;

    @Autowired
    private AdherentService adherentService;

    @Autowired
    private CompteService compteService;

    private Adherent adherent;
    private Compte compte;
    private Pari pari;
// Alter table PARI alter column PARTICIPANTS_POUR type varchar(5000)
    @RequestMapping(value = "/miserPour")
    public String miserPour(@RequestParam(value = "valeurSession") String valeurSession,
                            @RequestParam(value = "valeurPari") String valeurPari,
                            Model model){
        System.out.println(valeurSession);
        System.out.println(valeurPari);

        adherent=adherentService.getAdherentById(valeurSession);
         compte=compteService.getCompteById(valeurSession);
         pari=pariService.getPariById(valeurPari);


        SimpleDateFormat formatter = null;
        formatter=  new SimpleDateFormat("yyyy-MM-dd");
        Date dateLimite = pari.getDateLimite();

        Date aujd= new Date();


        System.out.println("pour"+pari.getListParticipantPour().size());


        if(!adherent.participe(pari) && pari.getListParticipantPour().size()<pari.getNbreParticipant() && dateLimite.compareTo(aujd)>0){
            pari.getListParticipantPour().add(adherent);
        }else {

        }

        System.out.println("pour"+pari.getListParticipantPour().size());
        /*Boolean exist=false;

        for (Adherent a : pari.getListParticipantPour()){
            if(a.equals(adherent)){
                exist=true;
            }
        }
        for (Adherent a : pari.getListParticipantContre()){
            if(a.equals(adherent)){
                exist=true;
            }
        }



        if(pari.getListParticipantPour().size()<pari.getNbreParticipant() && !exist){

            pari.getListParticipantPour().add(adherent);

        }
        model.addAttribute("exist", exist);

*/
        adherentService.saveAdherent(adherent);
        compteService.saveCompte(compte);
        pariService.savePari(pari);

        return "redirect:/logged?email="+adherent.getEmail()+"&password="+adherent.getPassword();

    }

    @RequestMapping(value = "/miserContre")
    public String miserContre(@RequestParam(value = "valeurSession") String valeurSession,
                            @RequestParam(value = "valeurPari") String valeurPari,
                            Model model){
        System.out.println(valeurSession);
        System.out.println(valeurPari);

         adherent=adherentService.getAdherentById(valeurSession);
         compte=compteService.getCompteById(valeurSession);
         pari=pariService.getPariById(valeurPari);

        SimpleDateFormat formatter = null;
        formatter=  new SimpleDateFormat("yyyy-MM-dd");
        Date dateLimite = pari.getDateLimite();

        Date aujd= new Date();

        System.out.println("contre "+pari.getListParticipantContre().size());


        if(!adherent.participe(pari) && pari.getListParticipantContre().size()<pari.getNbreParticipant() && dateLimite.compareTo(aujd)>0){
            pari.getListParticipantContre().add(adherent);
        }else {

        }

        System.out.println("contre "+pari.getListParticipantContre().size());

        /*Boolean exist=false;

        for (Adherent a : pari.getListParticipantPour()){
            if(a.equals(adherent)){
                exist=true;
            }
        }
        for (Adherent a : pari.getListParticipantContre()){
            if(a.equals(adherent)){
                exist=true;
            }
        }



        if(pari.getListParticipantPour().size()<pari.getNbreParticipant() && !exist){

            pari.getListParticipantContre().add(adherent);

        }
        model.addAttribute("exist", exist);*/

        adherentService.saveAdherent(adherent);
        compteService.saveCompte(compte);
        pariService.savePari(pari);

        return "redirect:/logged?email="+adherent.getEmail()+"&password="+adherent.getPassword();

    }



}
