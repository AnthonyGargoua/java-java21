package java17.ex01;

import java.util.function.Function;

import org.junit.Test;

import java17.data.Account;
import java17.data.Person;


/**
 * Exercice 01 - java.util.function.Function
 */
public class Function_01_Test {

    /******** PART 1 - Integer -> Person *******/

    // tag::intToPerson[]
    // TODO Compléter la définition de cette fonction
    // TODO Cette fonction permet de transformer un entier en objet Person
    // TODO le prenom sera de la forme "first_<ENTIER>"
    // TODO le nom sera de la forme "last_<ENTIER>"
    // TODO l'age sera de la forme "<ENTIER>"
    // TODO le mot de passe sera de la forme "pass_<ENTIER>"
 // private Function<Integer, Person> intToPerson = null;
    private Function<Integer, Person> intToPerson = numero -> new Person("first_" + numero, "last_" + numero, numero,"pass_" + numero); // Je définis une Function qui prend 'numero' (Integer) en entrée et renvoie un 'new Person' avec les textes "first_", "last_", "pass_" concaténés à ce numéro.
    // end::intToPerson[]

    @Test
    public void test_intToPerson() throws Exception {

        // TODO invoquer la fonction intToPerson avec en paramètre l'entier 10.
     // Person result = null;
        Person result = intToPerson.apply(10); // J'exécute la fonction 'intToPerson' en lui passant le nombre 10 grâce à la méthode .apply(10)

        assert result.getFirstname().equals("first_10");
        assert result.getLastname().equals("last_10");
        assert result.getAge().equals(10);
        assert result.getPassword().equals("pass_10");
    }

    /******** PART 2 - Person -> Account *******/

    // tag::personToAccount[]
    // TODO Compléter la définition de cette fonction
    // TODO la propriété owner est valorisé avec la personne en paramètre
    // TODO la propriété balance est valorisé à 1000
 // private Function<Person, Account> personToAccount = null;
    private Function<Person, Account> personToAccount = p -> {
        Account n = new Account();
        n.setOwner(p);
        n.setBalance(1000);
        return n;
    }; // Je définis une Function qui prend 'p' (Person) en entrée, crée un compte 'n', lui attribue le propriétaire 'p' et le solde de 1000, puis le renvoie.
    // end::personToAccount[]

    @Test
    public void test_personToAccount() throws Exception {

        Person person = new Person("Jules", "France", 10, "pass");

        // TODO invoquer la fonction personToAccount
     // Account result = null;
        Account result = personToAccount.apply(person); // J'exécute la fonction 'personToAccount' en lui passant l'objet 'person' via la méthode .apply(person)

        assert result.getOwner().equals(person);
        assert result.getBalance().equals(1000);
    }
}
