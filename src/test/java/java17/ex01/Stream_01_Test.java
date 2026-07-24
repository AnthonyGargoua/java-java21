package java17.ex01;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;

import java17.data.Data;
import java17.data.domain.Order;
import java17.data.domain.Pizza;

import javax.swing.plaf.BorderUIResource;

/**
 * Exercice 01 - Recherche
 */
public class Stream_01_Test {

	@Test
	public void test_stream_filter() throws Exception {
		List<Pizza> pizzas = new Data().getPizzas();

		// TODO récupérer la liste des pizzas dont le prix est >= 1300
		// List<Pizza> result = null;
		   List<Pizza> result = pizzas.stream()
				   .filter(pizza -> pizza.getPrice() >=1300)
				   .toList(); // Je récupere ma liste de pizza en utilisant .filtre et en mettant la condition >=1300 et je termine par le .toList pour afficher la liste

		assertThat(result, hasSize(3));
		assertThat(result, everyItem(hasProperty("price", anyOf(equalTo(1300), greaterThan(1300)))));
	}

	@Test
	public void test_stream_filter_collect_counting() throws Exception {
		List<Pizza> pizzas = new Data().getPizzas();

		// TODO compter le nombre de pizzas dont le prix est >= 1300
	//	long result = 0L;
		long result = pizzas.stream()
				.filter(pizza -> pizza.getPrice() >=1300)
				.count(); // Je récupere ma liste de pizza en utilisant .filtre et en mettant la condition >=1300 et je termine par le .count pour compter le nombre de pizza dont le prix est >=1300

		assertThat(result, is(3L));
	}

	@Test
	public void test_stream_anyMatch() throws Exception {

		List<Pizza> pizzas = new Data().getPizzas();

		// TODO valider si au moins une pizza à un prix >= 1300
	//	Boolean result1 = null;
		Boolean result1 = pizzas.stream()
				.anyMatch(pizza -> pizza.getPrice() >= 1300); // Je récupere ma liste de pizza avec au moins une pizza ayant un prix >=1300 en utilisant .anyMatch

		// TODO valider si au moins une pizza à un prix >= 2000
	//	Boolean result2 = null;
		Boolean result2 = pizzas.stream()
						.anyMatch(pizza -> pizza.getPrice() >= 2000); // Je récupere ma liste de pizza avec au moins une pizza ayant un prix >=2000 en utilisant .anyMatch

		assertThat(result1, is(true));
		assertThat(result2, is(false));
	}

	@Test
	public void test_stream_allMatch() throws Exception {

		List<Pizza> pizzas = new Data().getPizzas();

		// TODO valider que toutes les pizzas ont un prix >= 1300
	//	Boolean result1 = null;
		Boolean result1 = pizzas.stream()
				.allMatch(pizza -> pizza.getPrice() >= 1300); // Je récupere ma liste de pizza avec toutes les pizzas ayant un prix >=1300 en utilisant .allMatch

		// TODO valider que toutes les pizzas ont un prix >= 900
	//	Boolean result2 = null;
		Boolean result2 = pizzas.stream()
				.allMatch(pizza -> pizza.getPrice() >= 900);

		assertThat(result1, is(false));
		assertThat(result2, is(true));
	}

	@Test
	public void test_stream_noneMatch() throws Exception {

		List<Pizza> pizzas = new Data().getPizzas();

		// TODO valider qu'aucune pizza n'a un prix >= 2000
	//	Boolean result1 = null;
		Boolean result1 = pizzas.stream()
				.noneMatch(pizza -> pizza.getPrice() >= 2000); // Je récupere ma liste de pizza en vayant qu'aucune pizza n'a un prix >=2000 en utilisant le .noneMatch

		assertThat(result1, is(true));
	}

	@Test
	public void test_stream_findFirst() throws Exception {
		List<Order> orders = new Data().getOrders();

		// TODO récupérer une commande faite par un client dont le prénom est "Sophie"
	//	Optional<Order> result = null;
		Optional<Order> result = orders.stream()
						.filter(order -> order.getCustomer().getFirstname().equals("Sophie"))
								.findFirst(); // Je récupere ma liste d'order et je vérifie que le client s'appelle bien "Sophie" et je termine avec le .findFirst

		assertThat(result.isPresent(), is(false));
	}

	/**
	 * FACULTATIVE : PLUS DURE !!
	 */
	@Test
	public void test_stream_filter_adv() throws Exception {
		List<Order> orders = new Data().getOrders();

		// TODO récupérer la liste de toutes les commandes qui contiennent au moins une pizza Pépéroni
	//	List<Order> result = null;
		List<Order> result = orders.stream()
				.filter(order -> order.getPizzas().stream().anyMatch(pizza -> pizza.getName().equals("Pépéroni")))
				.toList(); // Je récupere ma liste d'order et je vérifie que toutes les commandes contiennent au moins une pizza pépéroni et je termine avec le .toList pour lister

		assertThat(result, hasSize(3));
	}
}
