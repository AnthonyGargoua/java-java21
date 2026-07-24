package java17.ex02;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.UnsupportedTemporalTypeException;

import org.junit.Test;

import javax.xml.transform.Result;

/**
 * Exercice 02 - LocalDate
 */
public class DateAndTime_02_Test {

	@Test
	public void test_localDate_of() {

		// TODO créer un objet LocalDate à la date 24/12/2050
	//	LocalDate result = null;
		LocalDate result = LocalDate.of(2050, 12, 24); // Création d'un objet LocalDate représentant le 24 décembre 2050

		// TODO En exploitant les méthodes de l'objet result, valoriser les différentes variables afin de rendre le test passant.
	//	int year = 0;
		int year = result.getYear(); // Récupère l'année de la date (2050)
	//	Month month = null;
		Month month = result.getMonth(); // Récupère le mois sous forme d'une constante de l'énumération Month (DECEMBER)
	//	int dayOfMonth = 0;
		int dayOfMonth = result.getDayOfMonth(); // Récupère le jour du mois (24)
	//	DayOfWeek dayOfWeek = null;
		DayOfWeek dayOfWeek = result.getDayOfWeek(); // Récupère le jour de la semaine sous forme d'une constante de l'énumération DayOfWeek (SATURDAY)
	//	int dayOfYear = 0;
		int dayOfYear = result.getDayOfYear(); // Récupère le numéro du jour dans l'année (24 décembre = 358e jour de l'année 2050)

		assertThat(year, is(2050));
		assertThat(month, is(Month.DECEMBER));
		assertThat(dayOfMonth, is(24));
		assertThat(dayOfWeek, is(DayOfWeek.SATURDAY));
		assertThat(dayOfYear, is(358));
	}

	@Test
	public void test_localDate_parse() {

		// TODO créer un objet LocalDate à la date 10/01/1990
		// TODO utiliser la méthode parse
	//	LocalDate result = null;
		LocalDate result = LocalDate.of(1990, 1, 10); // Récupère l'année de la date (1990)

		// TODO En exploitant les méthodes de l'objet result, valoriser les
		// différentes variables afin de rendre le test passant.
	//	int year = 0;
		int year = result.getYear(); // Récupère l'année de la date stockée dans l'objet result
	//	Month month = null;
		Month month = result.getMonth(); // Récupère le mois de la date (renvoie une valeur de l'énumération Month, par exemple DECEMBER)
	//	int dayOfMonth = 0;
		int dayOfMonth = result.getDayOfMonth(); // Récupère le jour du mois (un nombre compris entre 1 et 31)

		assertThat(year, is(1990));
		assertThat(month, is(Month.JANUARY));
		assertThat(dayOfMonth, is(10));
	}

	@Test
	public void test_localDate_format() {

		// TODO créer un objet LocalDate à la date 11/03/2015
		// en utilisant la méthode of
	//	LocalDate localDate = null;
		LocalDate localDate = LocalDate.of(2015,03, 11); // Récupère l'année de la date (2015)

		// TODO Formatter la date pour que le test soit passant
	//	String result = null;
		String result = localDate.format(DateTimeFormatter.ofPattern("dd - MM - yyyy")); // Formate la date contenue dans localDate en chaîne de caractères (String) en utilisant le format jour - mois - année (exemple : 24 - 12 - 2050)

		assertThat(result, is("11 - 03 - 2015"));
	}

	@Test(expected = UnsupportedTemporalTypeException.class)
	public void test_localDate_format_with_hour() {

		// TODO créer un objet LocalDate à la date 11/03/2015
		// TODO utiliser la méthode of
	//	LocalDate localDate = null;
		LocalDate localDate = LocalDate.of(2015, 03, 11); // Récupère l'année de la date (2015)

		// TODO Formatter la date pour avoir l'affichage suivant : "11/03/2015 00:00:00"
	//	localDate.format(null);
		localDate.format(DateTimeFormatter.ofPattern("dd - MM - yyyy HH, mm, ss")); // Formate la date pour obtenir une chaîne de caractères avec le format indiqué
																					// "dd" = jour du mois sur 2 chiffres
																					// "MM" = mois sur 2 chiffres
																					// "yyyy" = année sur 4 chiffres
																					// "HH" = heure, "mm" = minutes, "ss" = secondes
	}

	@Test
	public void test_with() {

		// TODO créer un objet LocalDate à la date 10/01/2000
		// TODO utiliser la méthode of
	//	LocalDate localDate = null;
		LocalDate localDate = LocalDate.of(2000, 01, 10); // Récupère l'année de la date (2000)

		// TODO transformer la date précédente en 05/02/2015
	//	LocalDate result = null;
		LocalDate result = localDate
				.withYear(2015)        // Crée une nouvelle date en changeant uniquement l'année en 2015
				.withMonth(2)          // Modifie le mois pour mettre février (mois 2)
				.withDayOfMonth(5);    // Modifie le jour du mois pour mettre le 5

		assertThat(result.getYear(), is(2015));
		assertThat(result.getMonth(), is(Month.FEBRUARY));
		assertThat(result.getDayOfMonth(), is(5));
	}

}
