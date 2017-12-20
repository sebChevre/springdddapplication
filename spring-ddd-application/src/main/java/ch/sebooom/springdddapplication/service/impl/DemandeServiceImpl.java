package ch.sebooom.springdddapplication.service.impl;

import ch.sebooom.springdddapplication.events.domain.demande.*;
import ch.sebooom.springddddomain.businessrules.demande.DemandeAInstruireSpecification;
import ch.sebooom.springddddomain.events.DomainEvent;
import ch.sebooom.springddddomain.model.person.Personnne;
import ch.sebooom.springddddomain.port.repository.EventRepository;
import ch.sebooom.springdddapplication.service.DemandeService;
import ch.sebooom.springddddomain.model.demande.Demande;
import ch.sebooom.springddddomain.model.demande.DemandeEtat;
import ch.sebooom.springddddomain.model.demande.DemandeId;
import ch.sebooom.springddddomain.port.repository.DemandeRepository;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class DemandeServiceImpl implements DemandeService{

    @Autowired
    DemandeRepository demandeRepository;

    @Autowired
    EventRepository eventsRepository;

    @Autowired
    DemandePublisher demandePublisher;

    public void accepterDemande(@NonNull final DemandeId demandeId) {

        Optional<Demande> demandeToFind = demandeRepository.getDemandeByIdentity(demandeId);

        if(demandeToFind.isPresent()){
            Demande demande = demandeToFind.get();
            demande.accepterDemande();
        }
    }


    public void instruireDemande(DemandeId demandeId) {

        demandePublisher.publish(
                new DemandeToChangeCommand(this,"Create demande command...", demandeId,DemandeEtat.EN_INSTRUCTION));


        Optional<Demande> demandeToFind = demandeRepository.getDemandeByIdentity(demandeId);
        Optional<Demande> demandeUpdated = Optional.empty();

        if(demandeToFind.isPresent()){
            Demande demande = demandeToFind.get();
            demande.instruireDemande(new DemandeAInstruireSpecification());
            try{
                demandeUpdated = Optional.of(demandeRepository.update(demande));

            }catch(Exception ex){


            }finally{
                if(demandeUpdated.isPresent()){
                    demandePublisher.publish(new DemandeStateChangeEvent(this,
                            "Demande successfully created",demandeUpdated.get(),
                            demandeUpdated.get().getDemandeEtat()));
                }

            }

        }
    }

    @Override
    public List<Demande> listerDemande() {
        List<Demande> demandes = new ArrayList<>();
        return demandeRepository.getAllDemande();

    }

    @Override
    public Optional<Demande> creerDemande(Personnne personne) {

        demandePublisher.publish(new DemandeToCreateCommand(this,"Create demande command..."));


        Optional<Demande> demande = Optional.empty();

        try{

            DemandeId id = DemandeId.getNewDemandeId();
            demande = Optional.of(demandeRepository.creerNouvelleDemande(id,personne));

        }catch (Exception ex){


        }finally {

            if(demande.isPresent()){
                demandePublisher.publish(new DemandeCreatedEvents(this,
                        "Demande successfully created",demande.get()));

            }

            return demande;
        }


    }

    @Override
    public List<DomainEvent> getAllDemandEvents() {

        return eventsRepository.listEventsOrderByDate();
    }


}
