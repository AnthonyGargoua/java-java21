package java17.ex06;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 06 - Period
 */
public class DateAndTime_06_Test {

    @Test
    public void test_period() throws Exception {

        // TODO Créer une LocalDate au 31/12/2017
    //  LocalDate localDate1 = null;
        LocalDate localDate1 = LocalDate.of(2017, 12, 31); // Crée un objet LocalDate avec la date 31/12/2017

        // TODO Créer une LocalDate au 01/01/2050
    //  LocalDate localDate2 = null;
        LocalDate localDate2 = LocalDate.of(2050, 1, 1); // Crée un objet LocalDate avec la date 01/01/2050

        // TODO créer une période (classe java.time.Period) à entre les 2 précédentes dates
    //  Period result = null;
        Period result = Period.between(LocalDate.of(2017, 12, 31), LocalDate.of(2050, 1, 1)); // Calcule la différence entre deux dates en années, mois et jours

        assertThat(result.toTotalMonths(), is(384L));
    }
}
