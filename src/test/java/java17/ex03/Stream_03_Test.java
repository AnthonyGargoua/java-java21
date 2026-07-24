package java17.ex03;

import org.junit.Test;

import java17.data.Data;
import java17.data.domain.Customer;
import java17.data.domain.Gender;
import java17.data.domain.Order;
import java17.data.domain.Pizza;

import javax.swing.plaf.basic.BasicBorders;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 03 - Collectors
 */
public class Stream_03_Test {

	@Test
	public void test_max() throws Exception {

		List<Order> orders = new Data().getOrders();

		// TODO Retrouver la commande avec le prix le plus élevé
	//	Optional<Order> result = null;
		Optional<Order> result = orders.stream() // Je parcours la liste des commandes
				.max(Comparator.comparing(order -> order.getPrice())); // Je cherche la commande qui possède le prix le plus élevé, j'utilise le .max
																			// Comparator.comparing compare les prix de chaque commande entre eux

		assertThat(result.isPresent(), is(true));
		assertThat(result.get().getPrice(), is(2200.0));
	}

	@Test
	public void test_min() throws Exception {

		List<Order> orders = new Data().getOrders();

		// TODO Retrouver la commande avec le prix le moins élevé
	//	Optional<Order> result = null;
		Optional<Order> result = orders.stream() // Je parcours la liste des commandes
				.min(Comparator.comparing(order -> order.getPrice())); // Je cherche la commande qui possède le prix le moins élevé j'utilise le .min
																			// Comparator.comparing compare les prix de chaque commande entre eux

		assertThat(result.isPresent(), is(true));
		assertThat(result.get().getPrice(), is(1000.0));
	}

	@Test
	public void test_map_collect_joining() throws Exception {

		List<Customer> customers = new Data().getCustomers();

		// TODO construire une chaîne contenant les prénoms des clients triés et séparés par le caractère "|"
	//	String result = null;
		String result = customers.stream() // Je parcours la liste des clients
				.map(customer -> customer.getFirstname()) // Je récupère uniquement les prénoms des clients
				.sorted() // Je trie les prénoms dans l'ordre alphabétique
				.collect(Collectors.joining("|")); // Je fusionne les prénoms dans une String séparée par "|"

		assertThat(result, is("Alexandra|Cyril|Johnny|Marion|Sophie"));
	}

	@Test
	public void test_flatMap() throws Exception {

		List<Order> orders = new Data().getOrders();

		// TODO Extraire la liste des pizzas de toutes les commandes
	//	List<Pizza> result = null;
		List<Pizza> result = orders.stream() // Je parcours la liste des clients
				.flatMap(order -> order.getPizzas().stream()) // flatMap permet d'aplatir les listes de pizzas de chaque commande (Order)
																	// getPizzas() récupère la liste des pizzas d'une commande
																	// .stream() transforme cette liste en Stream<Pizza>
																	// flatMap fusionne toutes ces listes pour obtenir un seul flux contenant toutes les pizzas
				.toList(); // Transforme le Stream<Pizza> final en une List<Pizza>

		assertThat(result.size(), is(9));
	}

	@Test
	public void test_flatMap_distinct() throws Exception {

		List<Order> orders = new Data().getOrders();

		// TODO Extraire la liste des différentes pizzas de toutes les commandes
	//	List<Pizza> result = null;
		List<Pizza> result = orders.stream() // Je parcours la liste des clients
				.flatMap(order -> order.getPizzas().stream()) // Je récupère et fusionne toutes les pizzas de toutes les commandes dans un seul flux
				.distinct() // Je supprime les pizzas en double pour garder uniquement les pizzas uniques
				.toList(); // Je convertis le Stream final en List<Pizza>

		assertThat(result.size(), is(4));
	}

	@Test
	public void test_grouping() throws Exception {

		List<Order> orders = new Data().getOrders();

		// TODO construire une Map <Client, Commandes effectuées par le client
	//	Map<Customer, List<Order>> result = null;
		Map<Customer, List<Order>> result = orders.stream() // Je parcours toutes les commandes
				.collect(Collectors.groupingBy(order -> order.getCustomer())); // Je regroupe les commandes selon leur client
																					// La clé de la Map est le client (Customer)
																					// La valeur associée est la liste des commandes de ce client

		assertThat(result.size(), is(2));
		assertThat(result.get(new Customer(1)), hasSize(4));
		assertThat(result.get(new Customer(2)), hasSize(4));
	}

	@Test
	public void test_partitionning() throws Exception {
		List<Pizza> pizzas = new Data().getPizzas();

		// TODO Séparer la liste des pizzas en 2 ensembles :
		// TODO true -> les pizzas dont le nom commence par "L"
		// TODO false -> les autres
	//	Map<Boolean, List<Pizza>> result = null;
		Map<Boolean, List<Pizza>> result = pizzas.stream() // Je parcours la liste des pizzas
		.collect(Collectors.partitioningBy(pizza -> pizza.getName().startsWith("L"))); // Je sépare les pizzas en deux groupes selon une condition
																							// true  : les pizzas dont le nom commence par "L"
																							// false : les autres pizzas

		assertThat(result.get(true), hasSize(6));
		assertThat(result.get(false), hasSize(2));
	}
}
