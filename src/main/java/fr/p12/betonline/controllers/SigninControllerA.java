/*
package fr.p12.betonline.controllers;

import fr.p12.betonline.beans.Compte;
import fr.p12.betonline.services.ServiceInterface.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

*/
/**
 * Created by audre on 31/03/2017.
 *//*


@Controller
public class  SigninControllerA {

    private CompteService compteService;

    @Autowired
    public void setCompteService(CompteService compteService) {
        this.compteService = compteService;
    }

    //CREATE
    @RequestMapping("compte/new")
    public String newCompte(Model model){
        model.addAttribute("compte", new Compte());
        return "signin";
    }

    //SAVE
    @RequestMapping(value = "compte", method = RequestMethod.POST)
    public String saveCompte(Compte compte){
        compteService.saveCompte(compte);
        return "redirect:/compte/" + compte.getEmail();
    }

    //READ
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
}

}
*/
