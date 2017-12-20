package ch.sebooom.springddddomain.model.demande;
import ch.sebooom.springddddomain.model.person.NSS;
import ch.sebooom.springddddomain.shared.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode
@Embeddable
public final class DemandeId implements ValueObject<DemandeId>,Serializable {

    @Column
    private String demandeId;

    public DemandeId(@NonNull final String id) {

        demandeId = id;
    }


    public DemandeId(){}

    @Override
    public String toString() {
        return this.demandeId;
    }

    public static DemandeId valueOf(String demandeId) {


        return new DemandeId(demandeId);
    }
    public boolean sameValueAs(DemandeId otherValueObject) {
        return this.equals(otherValueObject);
    }

    public static DemandeId getNewDemandeId () {
        return new DemandeId(UUID.randomUUID().toString());
    }
}
