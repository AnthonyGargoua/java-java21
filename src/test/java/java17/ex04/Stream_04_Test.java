package java17.ex04;


import org.junit.Test;

import java.util.Comparator;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 04 - Stream
 */
public class Stream_04_Test {

    @Test
    public void test_of() throws Exception {
        // Construire un stream permettant de rendre le test passant
    //    Stream<String> result = null;
          Stream<String> result = Stream.of("Alexandra", "Cyril", "Johnny", "Marion", "Sophie"); // Stream.of() permet de créer un Stream à partir des éléments passés en paramètres

        assertThat(result.toArray(), arrayContaining("Alexandra", "Cyril", "Johnny", "Marion", "Sophie"));
    }

    @Test
    public void test_builder() throws Exception {

        // TODO compléter pour rendre le test passant
        // TODO utiliser la méthode "add"

    //  Stream<Object> result = Stream.builder().build();
        Stream<Object> result = Stream.builder() // Je crée un Stream avec le builder pour pouvoir ajouter mes éléments un par un.
                .add("Alexandra") // J'ajoute le premier prénom dans mon Stream.
                .add("Cyril") // J'ajoute le second prénom dans mon Stream.
                .add("Johnny") // J'ajoute le troisieme prénom dans mon Stream.
                .add("Marion") // J'ajoute le quatrieme prénom dans mon Stream.
                .add("Sophie") // J'ajoute le cinquieme prénom dans mon Stream.
                .build();

        assertThat(result.toArray(), arrayContaining("Alexandra", "Cyril", "Johnny", "Marion", "Sophie"));
    }

    @Test
    public void test_concat() throws Exception {
        Stream<String> s1 = Stream.of("Alexandra", "Cyril");
        Stream<String> s2 = Stream.of("Johnny", "Marion", "Sophie");

        // TODO concatener les deux streams s1 et s2
    //  Stream<String> result = null;
        Stream<String> result = Stream.concat(s1, s2); // Les éléments de s1 seront parcourus en premier, puis ceux de s2.

        assertThat(result.toArray(), arrayContaining("Alexandra", "Cyril", "Johnny", "Marion", "Sophie"));
    }

    @Test
    public void test_iterate() throws Exception {
        // TODO utiliser la méthode "iterate" de Stream afin de rendre le test passant
    //  Stream<Integer> result1 = null;
    //  Stream<Integer> result2 = null;
        Stream<Integer> result1 = Stream.iterate(1, i -> 1).limit(5); // Je crée un Stream qui commence à 1.
                                                                                            // À chaque nouvelle valeur, je retourne toujours 1.
                                                                                            // Je limite mon Stream à 5 éléments car iterate() crée un Stream infini.
        Stream<Integer> result2 = Stream.iterate(1, i -> i + 1).limit(5); // Je crée un Stream qui commence à 1.
                                                                                                // À chaque étape, j'ajoute 1 à la valeur précédente pour obtenir une suite croissante.
                                                                                                // Je limite mon Stream aux 5 premiers nombres.
        assertThat(result1.toArray(), arrayContaining(1,1,1,1,1));
        assertThat(result2.toArray(), arrayContaining(1,2,3,4,5));
    }
}
