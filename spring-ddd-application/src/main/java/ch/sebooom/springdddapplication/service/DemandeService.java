package ch.sebooom.springdddapplication.service;

import ch.sebooom.springddddomain.events.DomainEvent;
import ch.sebooom.springddddomain.model.demande.Demande;
import ch.sebooom.springddddomain.model.demande.DemandeId;
import ch.sebooom.springddddomain.model.person.Personnne;

import java.util.List;
import java.util.Optional;

public interface DemandeService {

    void accepterDemande(DemandeId demandeId);

    Optional<Demande> creerDemande(Personnne personne);

    void instruireDemande(DemandeId demandeId);

    List<Demande> listerDemande();

    List<DomainEvent> getAllDemandEvents();
}
