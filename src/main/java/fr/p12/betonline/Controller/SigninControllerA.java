package fr.p12.betonline.Controller;

import fr.p12.betonline.Model.SigninForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by audre on 31/03/2017.
 */

@Controller
public class  SigninControllerA {

    /*@RequestMapping(value = "/question", method = RequestMethod.GET)
    public String questionnaire(final Model model) {
        final SigninForm form = new SigninForm();
        model.addAttribute("premierFormulaire", form);
        return "signin";

    }

    @RequestMapping(value = "/validation", method = RequestMethod.POST)
    public String validation(@ModelAttribute("premierFormulaire")@Valid final SigninForm signinForm, final BindingResult bindingResult, final Model model) {
        if (bindingResult.hasErrors()) {
            //Traitement de l'erreur
        }
        model.addAttribute("retour", signinForm.getEmail() + " " + signinForm.getPassword());
        return "fomulaires/result";

    }*/


//Operation CREATE
    //display the create form
    @RequestMapping("compte/new")
    public String newSigninForm(Model model){
        model.addAttribute("compte", new SigninForm());
        return "signin";
    }

    //save the form
    @RequestMapping(value = "compte", method = RequestMethod.POST)
    public String saveSigninForm(SigninForm compte){
//        .saveSigninForm(compte);
        return "redirect:/compte/" + compte.getEmail();
    }

/*    //Operation READ
    @RequestMapping("compte/{email}")
    public String showProduct(@PathVariable String email, Model model){
        model.addAttribute("compte", productService.getProductById(email));
        return "productshow";
    }

    //Operation READ list
    @RequestMapping(value = "/comptes", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("comptes", productService.listAllProducts());
        return "products";
    }

    //Operation UPDATE
    @RequestMapping("compte/edit/{email}")
    public String edit(@PathVariable String email, Model model){
        model.addAttribute("compte", productService.getProductById(email));
        return "productform";
    }*/


}
