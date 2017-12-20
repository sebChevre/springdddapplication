package ch.sebooom.springdddspi.repository;

import ch.sebooom.springddddomain.model.demande.Demande;
import ch.sebooom.springddddomain.model.demande.DemandeId;
import ch.sebooom.springddddomain.model.person.Personnne;
import ch.sebooom.springddddomain.port.repository.DemandeRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Component
public class DemandeH2Repository implements DemandeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Demande> getDemandeByIdentity(DemandeId demandeId) {
        Demande demande =  entityManager.getReference(Demande.class,demandeId);
        return Optional.of(demande);
    }

    @Override
    public Demande update(Demande demande) {
        return null;
    }

    @Override
    public List<Demande> getAllDemande() {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Demande.class);
        return criteria.list();
    }

    @Override
    public Demande creerNouvelleDemande(DemandeId demandeId, Personnne personne) {
        Demande demande = new Demande(demandeId,personne);
        entityManager.persist(demande);
        return demande;
    }
}
