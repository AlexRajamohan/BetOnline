package fr.p12.betonline.repositories;

import fr.p12.betonline.beans.Adherent;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by audre on 02/05/2017.
 */

public interface AdherentRepository extends CrudRepository <Adherent, String> {
}
