package ch.sebooom.springdddspi.repository;



import ch.sebooom.springddddomain.events.DomainEvent;
import ch.sebooom.springddddomain.port.repository.EventRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EventsInMemoryRepository implements EventRepository {

    private List<DomainEvent> datas = new ArrayList<>();


    @Override
    public void addEvent(DomainEvent event) {

        datas.add(event);
    }

    @Override
    public List<DomainEvent> listEventsOrderByDate() {

        Collections.sort(datas, new Comparator<DomainEvent>(){
            public int compare(DomainEvent e1, DomainEvent e2){
                return e1.getEventDate().compareTo(e2.getEventDate());
            }
        });

        return datas;

    }


}
