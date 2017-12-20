package ch.sebooom.springdddspi.repository;

import ch.sebooom.springddddomain.model.demande.Demande;
import ch.sebooom.springddddomain.model.demande.DemandeId;
import ch.sebooom.springddddomain.model.person.Personnne;
import ch.sebooom.springddddomain.port.repository.DemandeRepository;
import ch.sebooom.springddddomain.port.repository.PersonneRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Component
public class PersonneH2Repository implements PersonneRepository {

    @PersistenceContext
    private EntityManager entityManager;




    public Demande creer(DemandeId demandeId, Personnne personne) {
        Demande demande = new Demande(demandeId,personne);
        entityManager.persist(demande);
        return demande;
    }

    @Override
    public Personnne creer(Personnne personne) {
        entityManager.persist(personne);
        return personne;
    }
}
