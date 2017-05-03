package fr.p12.betonline.services.Impl;

import fr.p12.betonline.beans.Pari_avant;
import fr.p12.betonline.services.ServiceInterface.InterfaceListPariService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by zaraki on 28/04/17.
 */

@Service
public class ListPariImpl implements InterfaceListPariService{
    private ArrayList<Pari_avant> listPariAvant;
    public ArrayList<Pari_avant> getListPariAvant() {
        return listPariAvant;
    }

    public boolean addPari(Pari_avant pariAvant){


//        list.put("adherent", listAdherent.add(adherent));

        if(!contains(pariAvant)){
            listPariAvant.add(pariAvant);
            return true;
        }else {
            return false;
        }

    }

    public boolean isEmpty(){
        if (listPariAvant.size()==0){
            return true;
        }
        else {return false;}
    }

    public boolean contains(Pari_avant pariAvant){

        boolean contains=false;
        for(Pari_avant p : listPariAvant){
            if(p.equals(pariAvant)){

                contains=true;
            }
        }
        return contains;
    }

}
