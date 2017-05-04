package fr.p12.betonline.controllers;

import fr.p12.betonline.beans.Pari;
import fr.p12.betonline.beans.Pari_avant;
import fr.p12.betonline.services.ServiceInterface.PariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by audre on 02/05/2017.
 */

@Controller
public class CreationPariController {

    @Autowired
    private PariService pariService;
/*
    @Autowired
    public void setPariService(PariService pariService) {
        this.pariService = pariService;
    }*/

/*    //CREATE
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
    }*/

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


        Pari pari= new Pari(inputObjetPari, misePari, nbreParticipant, date);
        pariService.savePari(pari);

        Iterable<Pari> listPari= pariService.listAllParis();
        model.addAttribute("listPari", listPari);

//        Pari_avant pariAvant =new Pari_avant(inputObjetPari,misePari,nbreParticipant , date);

        model.addAttribute("objet",inputObjetPari);
        model.addAttribute("mise",misePari);
        model.addAttribute("nbreParticipant",nbreParticipant);
        model.addAttribute("date",inputDate);


/*
        System.out.println(pariAvant.getObjet());
        System.out.println(pariAvant.getMise());
        System.out.println(pariAvant.getNbreParticipant());
        System.out.println(pariAvant.getDateLimite());

        listPariAvant.add(pariAvant);
        model.addAttribute("listPariAvant", listPariAvant);

        model.addAttribute("adherent1", listAdherentAvant.get(0));*/





//        return "creationPari/pariCree";
        return  "signin/myAccount";
    }

}
