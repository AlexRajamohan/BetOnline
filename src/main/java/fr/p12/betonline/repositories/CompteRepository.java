package fr.p12.betonline.repositories;

import fr.p12.betonline.beans.Compte;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by audre on 27/04/2017.
 */
public interface CompteRepository extends CrudRepository<Compte, String> {
}
