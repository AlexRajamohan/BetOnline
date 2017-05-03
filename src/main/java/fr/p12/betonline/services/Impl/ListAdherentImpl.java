/*
package fr.p12.betonline.Service.Impl;

import fr.p12.betonline.Model.Adherent;
import fr.p12.betonline.Model.Pari;

import java.util.ArrayList;
import java.util.HashMap;

*/
/**
 * Created by zaraki on 24/02/17.
 *//*

public class ListAdherentImpl {

//    protected HashMap<String, Object> list=new HashMap<>();
    protected ArrayList<Adherent_avant> listAdherent;


//    public HashMap<String, Object> getList() {
//        return list;
//    }
    public ArrayList<Adherent_avant> getListAdherent() {
        return listAdherent;
    }


    public boolean addAdherent(Adherent_avant adherent){


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

    public boolean contains(Adherent_avant adherent){

        boolean contains=false;
        for(Adherent_avant a : listAdherent){
            if(a.equals(adherent)){

                contains=true;
            }
        }
        return contains;
    }
}
*/
