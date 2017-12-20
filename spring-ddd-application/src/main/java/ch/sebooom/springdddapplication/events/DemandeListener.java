package ch.sebooom.springdddapplication.events;



import ch.sebooom.springdddapplication.events.domain.demande.DemandeEvent;


import ch.sebooom.springddddomain.port.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemandeListener implements ApplicationListener<DemandeEvent> {

    @Autowired
    EventRepository eventsRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(DemandeListener.class);

    @Override
    public void onApplicationEvent(DemandeEvent demandeEvent) {

        eventsRepository.addEvent(demandeEvent);
        LOGGER.info(demandeEvent.toString());
    }
}
