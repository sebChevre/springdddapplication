package ch.sebooom.springddddomain.model.demande;

import ch.sebooom.springddddomain.model.person.Personnne;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class DemandeTest {

    @Test
    public void testStringValueOfSymetry (){


        String stringRepresentation = "32132:DEPOSE:321323.32131:Chèvre:Seb:12/12/2012";

        Demande d = Demande.valueOf(stringRepresentation);


        assertThat(d).isNotNull();
        assertThat(d).hasNoNullFieldsOrProperties();

        String reprsentation = d.toString();

        assertThat(reprsentation).isEqualTo(stringRepresentation);


    }
}