package ch.sebooom.springddddomain.model.demande;

import ch.sebooom.springddddomain.businessrules.demande.DemandeAInstruireSpecification;
import ch.sebooom.springddddomain.model.person.Personnne;
import ch.sebooom.springddddomain.shared.DomainEntity;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Optional;

/**
 * <img alt="test" src="./doc-files/demande.png">
 */

@Entity
@Table(name = "DEMANDE")
public class Demande implements DomainEntity<Demande, DemandeId> {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private DemandeId demandeId;

    @Column
    @Getter private DemandeEtat demandeEtat;

    @Getter
    @OneToOne
    private Personnne beneficiaire;


    public Demande (@NonNull final DemandeId demandeId, DemandeEtat etatsDemande, Personnne beneficiaire) {
        this.demandeId = demandeId;
        this.demandeEtat = etatsDemande;
        this.beneficiaire = beneficiaire;
    }

    public Demande (@NonNull final DemandeId demandeId,Personnne personne) {
       // this.demandeId = demandeId;
        this(demandeId,DemandeEtat.DEPOSE,personne);
    }

   /* public Demande (@NonNull final DemandeId demandeId,DemandeEtat demandeEtat) {
        // this.demandeId = demandeId;
        this(demandeId,DemandeEtat.DEPOSE,null);
    }

    public Demande (@NonNull final DemandeId demandeId) {
        // this.demandeId = demandeId;
        this(demandeId,DemandeEtat.DEPOSE);
    }
*/
    public DemandeId getId() {
        return this.demandeId;
    }

    public boolean sameIdentityAs(Demande otherEntity) {
        return otherEntity.getId().equals(this.getId());
    }

    public Demande accepterDemande () {
        this.demandeEtat = DemandeEtat.ACCEPTE;
        return this;
    }

    public Demande instruireDemande (DemandeAInstruireSpecification specification) {
        if(specification.isSatisfiedBy(this)){
            this.demandeEtat = DemandeEtat.EN_INSTRUCTION;
        }

        return this;
    }

    @Override
    public String toString() {
        return  this.demandeId +
                ":" + this.demandeEtat +
                ":" + this.getBeneficiaire().toString();
    }

    public static Demande valueOf(String demande) {

        String [] stringElements = demande.split(":");

        DemandeId demandeId = new DemandeId(stringElements[0]);
        DemandeEtat demandeEtat = DemandeEtat.valueOf(stringElements[1]);

        String personne = String.join(":",
                stringElements[2],
                stringElements[3],
                stringElements[4],
                stringElements[5]);

        Personnne beneficiaire = Personnne.valueOf(personne);


        return new Demande(demandeId,demandeEtat,beneficiaire);
    }

    public Demande(){}


}
