package ch.sebooom.springddddomain.model.person;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PersonnneTest {

    @Test
    public void testStringValueOfSymetry (){

        String stringRepresentation = "321323.32131:Chèvre:Seb:12/12/2012";

        Personnne personne = Personnne.valueOf(stringRepresentation);

        assertThat(personne).isNotNull();
        assertThat(personne).hasNoNullFieldsOrProperties();

        String reprsentation = personne.toString();

        assertThat(reprsentation).isEqualTo(stringRepresentation);

    }
}