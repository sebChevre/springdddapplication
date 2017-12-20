package ch.sebooom.springdddapi.console;


import ch.sebooom.springdddapplication.events.domain.demande.DemandeCreatedEvents;
import ch.sebooom.springdddapplication.events.domain.demande.DemandePublisher;
import ch.sebooom.springdddapplication.events.domain.demande.DemandeToCreateCommand;
import ch.sebooom.springdddapplication.service.DemandeService;
import ch.sebooom.springddddomain.model.demande.Demande;
import ch.sebooom.springddddomain.model.demande.DemandeId;
import ch.sebooom.springddddomain.model.person.Personnne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Profile("console")
public class ConsoleApplication implements CommandLineRunner {

    @Autowired
    DemandeService demandeService;

    @Transactional
    @Override
    public void run(String... strings) throws Exception {


        Thread.sleep(6000);

        listDemandes();

        System.out.println("Création d'une demande");
        Optional<Demande> demande = demandeService.creerDemande(new Personnne());

        listDemandes();

        System.out.println("Création d'une demande");
        Optional<Demande> demande2 = demandeService.creerDemande(new Personnne());

        listDemandes();

        System.out.println("Instruction d'une demande");
        demandeService.instruireDemande(demande2.get().getId());

        listDemandes();

        java.lang.Thread.sleep(2000);
        System.out.println("Liste events");
        demandeService.getAllDemandEvents().forEach((event) -> {
            System.out.println(event);
        });




        java.lang.Thread.sleep(5000);

    }

    private void listDemandes() {
        List<Demande> demandes = demandeService.listerDemande();

        System.out.println("Liste des demandes");
        System.out.println("--------------------");
        demandes.forEach(demande -> {
            System.out.println(demande);
        });
        System.out.println("--------------------");
        System.out.println();
    }
}
