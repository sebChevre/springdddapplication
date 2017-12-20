package ch.sebooom.springddddomain.events;

import java.util.Date;

public interface DomainEvent {

    Date getEventDate ();

    String getMessage ();

    EventType getType();

}
