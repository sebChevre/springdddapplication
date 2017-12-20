package ch.sebooom.springdddapplication.events.domain.demande;

import ch.sebooom.springddddomain.events.EventType;
import lombok.ToString;


@ToString(callSuper = true)
public class DemandeToCreateCommand extends DemandeEvent {


    private final String message;

    public DemandeToCreateCommand(Object source, String message) {
        super(source);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public EventType getType() {
        return EventType.COMMAND;
    }
}
