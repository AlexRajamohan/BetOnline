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
import java.util.Random;

/**
 * Created by zaraki on 05/05/17.
 */

@Controller
public class TransactionController {

    @Autowired
    private AdherentService adherentService;

    @Autowired
    private CompteService compteService;

    @Autowired
    private PariService pariService;

    @RequestMapping(value = "/transaction")
    public String displayFormTransactionPage(){
        return "signin/formTransaction";
    }


    @RequestMapping(value = "/transactionEffectue", method = RequestMethod.POST)
    public String displayAccountPage(@RequestParam String choixTransaction,
                                     @RequestParam String inputMontant,
                                     HttpServletRequest request,
                                     @RequestParam String valeurSession){

        Adherent adherent=adherentService.getAdherentById(valeurSession);

        if(choixTransaction.equals("Créditer votre compte BetOnline")){
            adherent.crediterCompte(Float.valueOf(inputMontant));


        }
        else adherent.debiterCompte(Float.valueOf(inputMontant));
        adherentService.saveAdherent(adherent);
        compteService.saveCompte(adherent.getCompte());

//        return "signin/myAccount";

        request.getSession().setAttribute("adherent", adherent);
//        return "signin/myAccount";
//        return  "redirect:/logged";
        return "redirect:/logged?email="+adherent.getEmail()+"&password="+adherent.getPassword();
    }



    @RequestMapping(value = "/resultat", method = RequestMethod.POST )
    public String afficherResultat(@RequestParam(value = "valeurSession") String valeurSession,
                                   @RequestParam(value = "valeurPari") String valeurPari,
                                   HttpServletRequest request,
                                   Model model) {

        Adherent adherent = adherentService.getAdherentById(valeurSession);
        Compte compte = compteService.getCompteById(valeurSession);
        Pari pari = pariService.getPariById(valeurPari);

        Random random = new Random();
        pari.setResultat(random.nextBoolean());

        float gain = pari.getMise() + (pari.getListParticipantContre().size() * pari.getMise() / pari.getListParticipantPour().size());


        for (Adherent a : pari.getListParticipantPour()) {
            for (Adherent ad : pari.getListParticipantContre()) {
                if (pari.isResultat()) {
                    a.crediterCompte(gain);
                    ad.debiterCompte(Float.valueOf( pari.getMise()));
                }
                else {
                    ad.crediterCompte(gain);
                    a.debiterCompte(Float.valueOf(pari.getMise()));
                }


            }
        }
        /*if(pari.isResultat()){
            for (Adherent a : pari.getListParticipantPour()){
                for (Adherent ad : pari.getListParticipantContre()){
                    a.crediterCompte(gain);
                    ad.debiterCompte((float) pari.getMise());

                }
            }for (Adherent a : pari.getListParticipantPour()){
                for (Adherent ad : pari.getListParticipantContre()){
                    a.crediterCompte(gain);
                    ad.debiterCompte((float) pari.getMise());

                }
            }
        }
        else {
            for (Adherent a : pari.getListParticipantPour()){
                for (Adherent ad : pari.getListParticipantContre()){
                    ad.crediterCompte(gain);
                    a.debiterCompte((float) pari.getMise());

                }
            }
        }*/

            adherentService.saveAdherent(adherent);
            compteService.saveCompte(compte);
            pariService.savePari(pari);
            request.getSession().setAttribute("adherent", adherent);

            System.out.println(gain);
            System.out.println(adherent.getCompte().getSolde());

            return "redirect:/logged?email=" + adherent.getEmail() + "&password=" + adherent.getPassword();


        }

    }




