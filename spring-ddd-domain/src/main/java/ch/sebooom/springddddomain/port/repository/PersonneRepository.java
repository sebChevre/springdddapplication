package ch.sebooom.springddddomain.port.repository;

import ch.sebooom.springddddomain.model.demande.Demande;
import ch.sebooom.springddddomain.model.person.Personnne;

public interface PersonneRepository {

    Personnne creer(Personnne personne);
}
