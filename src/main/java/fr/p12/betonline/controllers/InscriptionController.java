package fr.p12.betonline.controllers;

import fr.p12.betonline.beans.Adherent;
import fr.p12.betonline.beans.Adherent_avant;
import fr.p12.betonline.beans.Compte;
import fr.p12.betonline.beans.Compte_avant;
import fr.p12.betonline.services.ServiceInterface.AdherentService;
import fr.p12.betonline.services.ServiceInterface.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by audre on 02/05/2017.
 */

@Controller
public class InscriptionController {

    @Autowired
    private AdherentService adherentService;

    @Autowired
    private CompteService compteService;


    @Autowired
    public void setAdherentService(AdherentService adherentService) {
        this.adherentService = adherentService;
    }



    //CREATE
    @RequestMapping("/inscription")
    public String displayInscriptionPage(){

/*        new Adherent();
        new Compte();*/
        return "inscription/inscription";
    }

  /*  //SAVE
    @RequestMapping(value = "compte", method = RequestMethod.POST)
    public String saveCompte(Compte compte){
        compteService.saveCompte(compte);
        return "redirect:/compte/" + compte.getEmail();
    }*/


    @RequestMapping(value = "/inscriptionValide")
    public String displayInscriptionValidePage(@RequestParam String inputName,
                                               @RequestParam String inputPrenom,
                                               @RequestParam String inputEmail,
                                               @RequestParam String inputPassword,
                                               Model model){

        Compte compte= new Compte(inputEmail, inputPassword);
        Adherent adherent=new Adherent(inputEmail, inputPassword, inputName, inputPrenom,compte);
        model.addAttribute("adherent", adherent);
        model.addAttribute("compte", compte);

        adherentService.saveAdherent(adherent);
        compteService.saveCompte(compte);

        return "inscription/inscriptionValide";
    }


    /*********************************************************/
    /*
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
        model.addAttribute("listAdherentAvant", listAdherentAvant);*/



    /*//READ
    @RequestMapping("compte/{email}")
    public String showCompte(@PathVariable String email, Model model){
        model.addAttribute("compte", compteService.getCompteById(email));
        return "compteshow";
    }

    //READ list
    @RequestMapping(value = "/comptes", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("comptes", compteService.listAllComptes());
        return "comptes";
    }

    //UPDATE
    @RequestMapping("compte/edit/{email}")
    public String edit(@PathVariable String email, Model model) {
        model.addAttribute("compte", compteService.getCompteById(email));
        return "signin";
    }

    //DELETE
    @RequestMapping("compte/delete/{id}")
    public String delete(@PathVariable String email){
        compteService.deleteCompte(email);
        return "redirect:/comptes";
    }*/

}
