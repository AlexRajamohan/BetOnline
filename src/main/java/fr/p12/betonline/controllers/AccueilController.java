package fr.p12.betonline.controllers;

import fr.p12.betonline.beans.Pari;
import fr.p12.betonline.services.ServiceInterface.PariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zaraki on 03/05/17.
 */
@Controller
public class AccueilController {

    @Autowired
    private PariService pariService;

    @RequestMapping("/accueil")
    public String displayAccueilPage(Model model){

        Iterable<Pari> listPari= pariService.listAllParis();

        model.addAttribute("listPari", listPari);



        return "general/accueil";
    }
}


/*        Date date=new Date();
        String objet="Pari_avant test";
        int mise=30;
        int nbreParticipant=8;
        String objet2="Pari_avant test2";


        Pari_avant pari=new Pari_avant(objet,mise,nbreParticipant,date);
        Pari_avant pari2=new Pari_avant(objet2,mise,nbreParticipant,date);
        model.addAttribute("objet", objet);
        model.addAttribute("objet2", objet2);
        model.addAttribute("mise", mise);
        model.addAttribute("nbreParticipant", nbreParticipant);
        model.addAttribute("date", date);

        listPariAvant.add(pari);
        listPariAvant.add(pari2);
        System.out.println(inputName);

        model.addAttribute("listPariAvant", listPariAvant);

        */