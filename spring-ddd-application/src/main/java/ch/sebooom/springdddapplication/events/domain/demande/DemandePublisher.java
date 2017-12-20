package ch.sebooom.springdddapplication.events.domain.demande;

import ch.sebooom.springdddapplication.events.domain.demande.DemandeEvent;
import ch.sebooom.springddddomain.events.DomainEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class DemandePublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish (DomainEvent event) {

        applicationEventPublisher.publishEvent(event);
    }

}
