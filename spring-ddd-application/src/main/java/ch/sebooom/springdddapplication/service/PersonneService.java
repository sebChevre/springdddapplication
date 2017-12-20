package ch.sebooom.springdddapplication.service;

import ch.sebooom.springddddomain.model.person.Personnne;

import java.util.Optional;

public interface PersonneService {
    Optional<Personnne> creerPersonne(Personnne personne);


}
