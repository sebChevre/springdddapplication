package ch.sebooom.springdddapplication.dto;

import ch.sebooom.springddddomain.model.demande.Demande;

public class DemandeDTO{

    private String demandeId;

    private String demandeEtat;

    public DemandeDTO (Demande demande) {
        this.demandeId = demande.getDemandeId().toString();
        this.demandeEtat = demande.getDemandeEtat().toString();
    }


}
