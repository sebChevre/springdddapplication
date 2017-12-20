package ch.sebooom.springddddomain;

import ch.sebooom.springddddomain.model.demande.Demande;
import ch.sebooom.springddddomain.model.demande.DemandeId;

public interface DemandePort {


    Demande accepterDemande(DemandeId demandeId);

    Demande creerDemande();
}
