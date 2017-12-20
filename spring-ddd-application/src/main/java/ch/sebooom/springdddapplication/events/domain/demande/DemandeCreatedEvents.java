package ch.sebooom.springdddapplication.events.domain.demande;

import ch.sebooom.springddddomain.events.EventType;
import ch.sebooom.springddddomain.model.demande.Demande;
import lombok.ToString;

@ToString(callSuper = true)
public class DemandeCreatedEvents extends DemandeEvent {

    private final Demande demande;
    private final String message;



    public DemandeCreatedEvents(Object source, String message, Demande demande) {
        super(source);

        this.message = message;
        this.demande = copy(demande);

    }

    private Demande copy (Demande demande){
        return new Demande(demande.getId(),demande.getDemandeEtat(),demande.getBeneficiaire());
    }

    public String getMessage () {
        return message;
    }

    @Override
    public EventType getType() {
        return EventType.EVENT;
    }
}
