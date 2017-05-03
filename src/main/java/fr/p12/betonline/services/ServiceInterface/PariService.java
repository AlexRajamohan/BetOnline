package fr.p12.betonline.services.ServiceInterface;

import fr.p12.betonline.beans.Adherent;
import fr.p12.betonline.beans.Pari;
import fr.p12.betonline.repositories.PariRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by audre on 01/05/2017.
 */
public interface PariService {

    Iterable<Pari> listAllParis();

    Pari getPariById(String email);

    Pari savePari(Pari pari);

    void deletePari(String email);

    public boolean addAdherent(Adherent adherent);

    public void cloturer();

    @Autowired
    public void setPariRepository(PariRepository pariRepository);


}
