package ch.sebooom.springdddapplication.service.impl;

import ch.sebooom.springdddapplication.service.PersonneService;
import ch.sebooom.springddddomain.model.person.Personnne;
import ch.sebooom.springddddomain.port.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonneServiceImpl implements PersonneService {

    @Autowired
    PersonneRepository personneRepository;

    @Override
    public Optional<Personnne> creerPersonne(Personnne personne) {
        return Optional.of(personneRepository.creer(personne));
    }
}
