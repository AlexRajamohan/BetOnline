package fr.p12.betonline.Service.ServiceInterface;

import fr.p12.betonline.beans.Pari_avant;

/**
 * Created by zaraki on 01/05/17.*/


public interface InterfaceListPariService {

    public boolean addPari(Pari_avant pariAvant);

    public boolean isEmpty();

    public boolean contains(Pari_avant pariAvant);
}
