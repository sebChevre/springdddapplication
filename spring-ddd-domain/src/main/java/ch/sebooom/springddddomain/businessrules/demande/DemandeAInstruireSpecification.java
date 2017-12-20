package ch.sebooom.springddddomain.businessrules.demande;

import ch.sebooom.springddddomain.model.demande.Demande;
import ch.sebooom.springddddomain.model.demande.DemandeEtat;
import ch.sebooom.springddddomain.shared.AbstractSpecification;

public class DemandeAInstruireSpecification extends AbstractSpecification<Demande> {
    @Override
    public boolean isSatisfiedBy(Demande demande) {
        return demande.getDemandeEtat().equals(DemandeEtat.DEPOSE);
    }
}
