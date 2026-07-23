package java17.ex03;

import java.util.function.BinaryOperator;
import java.util.regex.Matcher;

import org.junit.Test;

import java17.data.Person;

/**
 * Exercice 03 - java.util.function.BinaryOperator
 */
public class Function_03_Test {

    //  tag::makeAChild[]
    // TODO Compléter la fonction makeAChild
    // TODO l'enfant possède le nom du père
    // TODO l'enfant possède le prenom "<PRENOM_PERE> <PRENOM_MERE>"
    // TODO l'age de l'enfant est 0
    // TODO le mot de passe de l'enfant est null
 // BinaryOperator<Person> makeAChild = null;
    // Crée un enfant à partir des objets Person de deux parents (père et mère)
    BinaryOperator<Person> makeAChild = (father, mother) -> {
        Person children = new Person();
        // L'enfant prend le nom de famille du père
        children.setLastname(father.getLastname());
        // Concatène les prénoms des deux parents séparés par un espace
        children.setFirstname(father.getFirstname() + " " + mother.getFirstname());
        // Définit l'âge du nouveau-né à 0
        children.setAge(0);
        // Aucun mot de passe défini pour l'enfant
        children.setPassword(null);
        return children;
    };
    //  end::makeAChild[]

    @Test
    public void test_makeAChild() throws Exception {

        Person father = new Person("John", "France", 25, "johndoe");
        Person mother = new Person("Aline", "Lebreton", 22, "alino");

        // TODO compléter le test pour qu'il soit passant
    //   Person child = null;
        // Applique le BinaryOperator en lui passant les deux parents pour créer l'objet 'child'
         Person child = makeAChild.apply(father, mother);

        assert child.getFirstname().equals("John Aline");
        assert child.getLastname().equals("France");
        assert child.getAge().equals(0);
        assert child.getPassword() == null;
    }
}
