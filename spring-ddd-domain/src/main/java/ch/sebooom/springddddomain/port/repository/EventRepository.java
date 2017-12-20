package ch.sebooom.springddddomain.port.repository;

import ch.sebooom.springddddomain.events.DomainEvent;

import java.util.List;

public interface EventRepository {

    void addEvent(DomainEvent event);

    List<DomainEvent> listEventsOrderByDate();
}
