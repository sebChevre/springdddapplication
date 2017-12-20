package ch.sebooom.springddddomain.model.person;

import ch.sebooom.springddddomain.model.demande.Demande;
import ch.sebooom.springddddomain.model.demande.DemandeEtat;
import ch.sebooom.springddddomain.model.demande.DemandeId;
import ch.sebooom.springddddomain.shared.DomainEntity;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table
public class Personnne implements DomainEntity<Personnne,NSS> {

    final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @Getter
    private String nom;

    @Column
    @Getter
    private String prenom;

    @Column
    @Getter
    private LocalDate dateNaissance;


    @Getter
    private NSS nss;

    public Personnne(@NonNull NSS nss,
                     @NonNull String nom,
                     @NonNull String prenom,
                     @NonNull LocalDate dateNaissance){
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.nss = nss;
    }


    public Personnne(){}

    @Override
    public NSS getId() {
        return this.nss;
    }


    @Override
    public String toString() {
        return  this.nss + ":" +
                this.nom + ":" +
                this.prenom + ":" +
                this.dateNaissance.format(DATE_FORMATTER);
    }

    public static Personnne valueOf(String personne) {

        System.out.println(personne);
        String[] valeursPersonne = personne.split(":");


        LocalDate date = LocalDate.parse(valeursPersonne[3],DATE_FORMATTER);
        NSS nss = new NSS(valeursPersonne[0]);

        return new Personnne(nss,valeursPersonne[1],
                valeursPersonne[2],date);
    }

    @Override
    public boolean sameIdentityAs(Personnne otherEntity) {
        return this.nss.equals(otherEntity.nss);
    }
}
