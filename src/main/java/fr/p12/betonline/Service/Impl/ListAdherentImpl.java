package fr.p12.betonline.Service.Impl;

import fr.p12.betonline.Model.Adherent;
import fr.p12.betonline.Model.Pari;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by zaraki on 24/02/17.
 */
public class ListAdherentImpl {

//    protected HashMap<String, Object> list=new HashMap<>();
    protected ArrayList<Adherent> listAdherent;


//    public HashMap<String, Object> getList() {
//        return list;
//    }
    public ArrayList<Adherent> getListAdherent() {
        return listAdherent;
    }


    public boolean addAdherent(Adherent adherent){


//        list.put("adherent", listAdherent.add(adherent));

        if(!contains(adherent)){
            listAdherent.add(adherent);
            return true;
        }else {
            return false;
        }

    }

    public boolean isEmpty(){
        if (listAdherent.size()==0){
            return true;
        }
        else {return false;}
    }

    public boolean contains(Adherent adherent){

        boolean contains=false;
        for(Adherent a : listAdherent){
            if(a.equals(adherent)){

                contains=true;
            }
        }
        return contains;
    }
}
