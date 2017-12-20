package ch.sebooom.springdddapplication.events.domain.demande;

import ch.sebooom.springddddomain.events.EventType;
import ch.sebooom.springddddomain.model.demande.DemandeEtat;
import ch.sebooom.springddddomain.model.demande.DemandeId;
import lombok.ToString;

import java.util.Date;

@ToString(callSuper = true)
public class DemandeToChangeCommand extends DemandeEvent {

    private final DemandeId demandeId;
    private final String message;
    private final DemandeEtat etatCible;



    public DemandeToChangeCommand(Object source, String message, DemandeId demandeId, DemandeEtat etatCible) {
        super(source);

        this.etatCible = etatCible;
        this.message = message;
        this.demandeId = demandeId;

    }


    public String getMessage () {
        return message;
    }

    @Override
    public EventType getType() {
        return EventType.EVENT;
    }
}
