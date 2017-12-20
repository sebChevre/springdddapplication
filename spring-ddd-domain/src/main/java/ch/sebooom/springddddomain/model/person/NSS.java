package ch.sebooom.springddddomain.model.person;

import ch.sebooom.springddddomain.shared.ValueObject;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.time.LocalDate;

@Embeddable
public class NSS implements ValueObject<NSS> {

    @Column
    @Getter
    private String nss;

    public NSS(@NonNull String nss){
        this.nss = nss;
    }

    @Override
    public boolean sameValueAs(NSS otherValueObject) {
        return this.nss.equals(otherValueObject.nss);
    }

    @Override
    public String toString() {
        return  this.nss;
    }

    public static NSS valueOf(String nss) {


        return new NSS(nss);
    }

    public NSS(){}

}
