package java17.ex07;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;

/**
 * Exercice 07 - Instant
 */
public class DateAndTime_07_Test {

	@Test
	public void test_date_to_localdate() throws Exception {

		// TODO Créer une date Java 1 (12/02/2017)
		// Date date = null;
		Date date = new Date(117, 1, 12); // Création d'une date correspondant au 12 février 2017 format Java 1

		// TODO transformer la date en Instant
		Instant instant = date.toInstant(); // Conversion de la Date en Instant

		// TODO transformer la date en LocalDate
		LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate(); // Conversion de l'Instant en LocalDate

		// TODO valoriser les différentes variables afin de rendre le test passant
		// LocalDate result = null;
		LocalDate result = localDate; // Récupération de la date convertie pour le test
									// LocalDate result = null;

		// TODO valoriser les différentes variables afin de rendre le test passant

		assertThat(result.getYear(), is(2017)); // Vérifie l'année
		assertThat(result.getMonth(), is(Month.FEBRUARY)); // Vérifie le mois
		assertThat(result.getDayOfMonth(), is(12)); // Vérifie le jour

	}
}
