package java17.ex03;

import org.junit.Test;
import org.w3c.dom.html.HTMLHeadElement;

import javax.xml.transform.Result;
import java.lang.management.MemoryManagerMXBean;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Exercice 03 - LocalTime
 */
public class DateAndTime_03_Test {

    @Test
    public void test_localTime_of() {

        // TODO créer un objet LocalTime à l'heure 15h24m02s
    //  LocalTime result = null;
        LocalTime result = LocalTime.of(15, 24, 02);     // Crée une heure avec 15 heures, 24 minutes et 2 secondes grâce à la méthode of()

        // TODO valoriser les différentes variables afin de rendre le test passant
    //    int hour = 0;
        int hour = result.getHour(); // Récupère l'heure de l'objet LocalTime (ici 15)
    //    int minutes = 0;
        int minutes = result.getMinute(); // Récupère les minutes de l'objet LocalTime (ici 24)
    //    int second = 0;
        int second = result.getSecond(); // Récupère les secondes de l'objet LocalTime (ici 2)

        assertThat(hour, is(15));
        assertThat(minutes, is(24));
        assertThat(second, is(2));
    }

    @Test
    public void test_localTime_parse() {

        // TODO créer un objet LocalTime à l'heure 09h30m00s à l'aide de la méthode parse
    //    LocalTime result = null;
          LocalTime result = LocalTime.parse("09:30:00"); // Convertit la chaîne de caractères "09:30:00" en objet LocalTime (heure 09h30)


        // TODO valoriser les différentes variables afin de rendre le test passant
    //    int hour = 0;
          int hour = result.getHour(); // Récupère l'heure de l'objet LocalTime
    //    int minutes = 0;
          int minutes = result.getMinute(); // Récupère les minutes de l'objet LocalTime
    //    int second = 0;
          int second = result.getSecond(); // Récupère les secondes de l'objet LocalTime

        assertThat(hour, is(9));
        assertThat(minutes, is(30));
        assertThat(second, is(0));
    }

    @Test
    public void test_localTime_format() {

        // TODO créer un objet localTime à l'heure 12h00m00s
        // TODO utiliser la méthode of
    //  LocalTime localTime = null;
        LocalTime localTime = LocalTime.of(12, 00, 00); // Crée un objet LocalTime avec l'heure 12h00 et 0 seconde

        // TODO Formatter l'heure pour que le test soit passant
    //  String result = null;
        String result = localTime.format(DateTimeFormatter.ofPattern("HH:mm")); // Formate l'heure en texte avec le format "heure:minute" (exemple : 12:00)

        assertThat(result, is("12:00"));
    }
}
