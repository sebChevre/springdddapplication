package ch.sebooom.springdddapi.web;

import ch.sebooom.springdddapi.Application;
import ch.sebooom.springdddapi.H2Configuration;
import ch.sebooom.springdddapplication.service.DemandeService;
import ch.sebooom.springdddapplication.service.PersonneService;
import ch.sebooom.springddddomain.model.demande.Demande;
import ch.sebooom.springddddomain.model.person.NSS;
import ch.sebooom.springddddomain.model.person.Personnne;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = {"ch.sebooom.springdddapplication","ch.sebooom.springdddspi","ch.sebooom.springdddapi"})
@ContextConfiguration(classes = {Application.class})
@PropertySource(value = "classpath:application.properties")
public class ControllerIntegrationTest {

    @Autowired
    DemandeService demandeService;

    @Autowired
    PersonneService personneService;

    @Test
    @Transactional
    public void testListAndSaveDemande (){
        listDemandes();

        System.out.println("Création d'une demande");

        Personnne personne = new Personnne(new NSS("1212"),
                "Chèvre","Sébastien", LocalDate.now());


        Optional<Personnne> personnne = personneService.creerPersonne(personne);

        Optional<Demande> demande = demandeService.creerDemande(personnne.get());

        listDemandes();

        System.out.println("Création d'une demande");


        Optional<Demande> demande2 = demandeService.creerDemande(personne);

        listDemandes();

        System.out.println("Instruction d'une demande");
        demandeService.instruireDemande(demande2.get().getId());

        listDemandes();


        System.out.println("Liste events");
        demandeService.getAllDemandEvents().forEach((event) -> {
            System.out.println(event);
        });


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


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

    @Configuration
    public static class ContextConfiguration {
    }
}
