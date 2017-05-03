package fr.p12.betonline.Controller;

import fr.p12.betonline.beans.Pari;
import fr.p12.betonline.services.ServiceInterface.PariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by audre on 02/05/2017.
 */
public class CreationPariController {

    private PariService pariService;

    @Autowired
    public void setPariService(PariService pariService) {
        this.pariService = pariService;
    }

    //CREATE
    @RequestMapping("pari/new")
    public String newPari(Model model){
        model.addAttribute("pari", new Pari());
        return "signin";
    }

    //SAVE
    @RequestMapping(value = "pari", method = RequestMethod.POST)
    public String savePari(Pari pari){
        pariService.savePari(pari);
        return "redirect:/pari/" + pari.getObjet();
    }

    //READ
    @RequestMapping("pari/{objet}")
    public String showPari(@PathVariable String objet, Model model){
        model.addAttribute("pari", pariService.getPariById(objet));
        return "parishow";
    }

    //READ list
    @RequestMapping(value = "/paris", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("pari", pariService.listAllParis());
        return "paris";
    }

    //UPDATE
    @RequestMapping("pari/edit/{objet}")
    public String edit(@PathVariable String objet, Model model) {
        model.addAttribute("pari", pariService.getPariById(objet));
        return "signin";
    }

    //DELETE
    @RequestMapping("pari/delete/{objet}")
    public String delete(@PathVariable String objet){
        pariService.deletePari(objet);
        return "redirect:/paris";
    }

}
