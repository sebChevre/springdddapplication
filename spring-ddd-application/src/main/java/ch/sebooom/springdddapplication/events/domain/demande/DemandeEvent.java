package ch.sebooom.springdddapplication.events.domain.demande;

import ch.sebooom.springddddomain.events.DomainEvent;
import ch.sebooom.springddddomain.events.EventType;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

@ToString(exclude = "date", includeFieldNames = false)
public abstract class DemandeEvent extends ApplicationEvent implements DomainEvent{

    public DemandeEvent (Object source){
        super(source);
        this.eventDate = new Date();
        this.dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(this.eventDate);
    }

    private String dateStr;
    private Date eventDate;

    public Date getEventDate () {
        return this.eventDate;
    }

    abstract public String getMessage ();

    abstract public EventType getType();
}
