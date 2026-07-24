package java17.ex04;

import org.junit.Test;

import java.lang.management.MemoryManagerMXBean;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 04 - LocalDateTime
 */
public class DateAndTime_04_Test {

    @Test
    public void test_localDateTime_of() {

        // TODO créer un objet LocalDateTime à la date heure 12h00m00s 01/01/2018
    //  LocalDateTime result = null;
        LocalDateTime result = LocalDateTime.of(2018, 01, 01, 12, 00,00); // Crée une date et une heure : 01/01/2018 à 12h00 avec 0 seconde

        // TODO valoriser les différentes variables afin de rendre le test passant
    //  int hour = 0;
        int hour = result.getHour(); // Récupère l'heure de l'objet LocalDateTime
    //  int minutes = 0;
        int minutes = result.getMinute(); // Récupère les minutes de l'objet LocalDateTime
    //  int second = 0;
        int second = result.getSecond(); // Récupère les secondes de l'objet LocalDateTime
    //  int year = 0;
        int year = result.getYear(); // Récupère l'année de l'objet LocalDateTime
    //  Month month = null;
        Month month =  result.getMonth(); // Récupère le mois de l'objet LocalDateTime
    //  int dayOfMonth = 0;
        int dayOfMonth = result.getDayOfMonth(); // Récupère le jour du mois de l'objet LocalDateTime

        assertThat(hour, is(12));
        assertThat(minutes, is(0));
        assertThat(second, is(0));
        assertThat(year, is(2018));
        assertThat(month, is(Month.JANUARY));
        assertThat(dayOfMonth, is(1));
    }

    @Test
    public void test_localDateTime_parse() {

        // TODO créer un objet LocalDateTime à l'heure 2 mars 2009 à 09h30m00s à l'aide de la méthode parse
    //  LocalDateTime result = null;
        LocalDateTime result = LocalDateTime.parse("2009-03-02T09:30:00"); // Convertit la chaîne de caractères en objet LocalDateTime (date 02/03/2009 à 09h30)

        // TODO valoriser les différentes variables afin de rendre le test passant
    //  int hour = 0;
        int hour = result.getHour(); // Récupère l'heure de l'objet LocalDateTime
    //  int minutes = 0;
        int minutes = result.getMinute(); // Récupère les minutes de l'objet LocalDateTime
    //  int second = 0;
        int second = result.getSecond(); // Récupère les secondes de l'objet LocalDateTime

    //  int year = 0;
        int year = result.getYear(); // Récupère l'année de l'objet LocalDateTime
    //  Month month = null;
        Month month = result.getMonth(); // Récupère le mois de l'objet LocalDateTime
    //  int dayOfMonth = 0;
        int dayOfMonth = result.getDayOfMonth(); // Récupère le jour du mois de l'objet LocalDateTime

        assertThat(year, is(2009));
        assertThat(month, is(Month.MARCH));
        assertThat(dayOfMonth, is(2));

        assertThat(hour, is(9));
        assertThat(minutes, is(30));
        assertThat(second, is(0));
    }

    @Test
    public void test_localDateTime_format() {

        // TODO créer un objet LocalDateTime le 27/11/2017 à 12h00m00s
        // TODO utiliser la méthode of
    //  LocalDateTime localDateTime = null;
        LocalDateTime localDateTime = LocalDateTime.of(2017,11,27, 12, 00, 00); // Crée un objet LocalDateTime avec la date 27/11/2017 et l'heure 12h00 avec 0 seconde

        // TODO Formatter l'heure pour que le test soit passant
    //  String result = null;
        String result = localDateTime.format(DateTimeFormatter.ofPattern("yyyy - MM/dd HH:mm")); // Formate la date et l'heure en texte avec le format "année - mois/jour heure:minute"

        assertThat(result, is("2017 - 11/27 12:00"));
    }
}
