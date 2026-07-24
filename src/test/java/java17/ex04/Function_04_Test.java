package java17.ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

import java17.data.Data;
import java17.data.Person;

/**
 * Exercice 4 - java.util.function.Predicate
 */
public class Function_04_Test {

    // tag::filterMethod[]
    <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T el : list) {
            if (predicate.test(el)) {
                result.add(el);
            }
        }
        return result;
    }
    // end::filterMethod[]

    // PART 1 - ADULT

    // tag::adult[]
    // TODO Compléter la fonction
    // TODO AGE >=18
//  Predicate<Person> adult = null;
    Predicate<Person> adult = person -> person.getAge() >= 18; // Je reçois une personne, je regarde son âge, et je renvoie true si elle a au moins 18 ans
    // end::adult[]

    @Test
    public void test_predicate() throws Exception {

        List<Person> personList = Data.buildPersonList();

        // TODO invoquer la méthode filter pour que le test soit passant
    //  List<Person> result = null;
        List<Person> result = filter(personList, adult); // J'applique le filtre "adult" sur ma liste de personnes pour ne garder que les adultes

        assert result.size() == 4;

    }

    // PART 2 - ADULT AND LASTNAME=France AND FIRSTNAME=Armor

    // tag::predicateand[]
    // TODO compléter la fonction
    // TODO le prédicat vérifie que le nom est "France"
//  Predicate<Person> lastnameIsFrance = null;
    Predicate<Person> lastnameIsFrance = person -> "France".equals(person.getLastname()); // Je vérifie si le nom de famille de la personne est "France"


    // TODO compléter la fonction
    // TODO le prédicat vérifie que le prénom est "Armor"
//  Predicate<Person> firstnameIsArmor = null;
    Predicate<Person> firstnameIsArmor = person -> "Armor".equals(person.getFirstname()); // Je vérifie si le prénom de la personne est "Armor"
    // end::predicateand[]

    @Test
    public void test_predicate_and() throws Exception {

        List<Person> personList = Data.buildPersonList();

        // TODO invoquer la méthode filter pour que le test soit passant
        // TODO chaîner les prédicats adult, lastnameIsFrance et firstnameIsArmor avec la méthode and
    //  List<Person> result = null;
        List<Person> result = filter(personList, adult.and(lastnameIsFrance).and(firstnameIsArmor)); // J'utilise la méthode .and() pour associer mes prédicats et ne garder que les adultes nommés Armor France

        assert result.size() == 1;
        assert result.get(0).getFirstname().equals("Armor");
        assert result.get(0).getLastname().equals("France");
        assert result.get(0).getAge().equals(25);

    }
}
