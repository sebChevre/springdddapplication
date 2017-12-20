package ch.sebooom.springddddomain.port.repository;

import ch.sebooom.springddddomain.model.demande.Demande;
import ch.sebooom.springddddomain.model.demande.DemandeId;
import ch.sebooom.springddddomain.model.person.Personnne;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface DemandeRepository {

    Optional<Demande> getDemandeByIdentity(@NonNull final DemandeId demandeId);

    Demande update(Demande demande);

    List<Demande> getAllDemande();

    Demande creerNouvelleDemande(@NonNull DemandeId demandeId, Personnne personne);


}
