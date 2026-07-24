package java17.ex02;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.OptionalDouble;

import org.junit.Test;

import java17.data.Data;
import java17.data.domain.Customer;
import java17.data.domain.Order;

import javax.swing.plaf.BorderUIResource;

/**
 * Exercice 02 - Transformation
 */
public class Stream_02_Test {

	@Test
	public void test_map() throws Exception {

		List<Order> orders = new Data().getOrders();

		// TODO Trouver la liste des clients associés aux commandes
	//	List<Customer> result = null;
		List<Customer> result = orders.stream() // Je parcours toutes les commandes
				.map(order -> order.getCustomer()) // Je transforme chaque commande en son client
				.toList(); // Je convertis le Stream en une liste de clients

		assertThat(result, hasSize(8));
	}

	@Test
	public void test_map_count() throws Exception {

		List<Order> orders = new Data().getOrders();

		// TODO Compter le nombre de clients associés aux commandes
	//	long result = 0;
		long result = orders.stream() // Je parcours toutes les commandes
				.map(order -> order.getCustomer()) // Je récupère le client de chaque commande
				.count(); // Je compte le nombre total de clients (avec les doublons)

		assertThat(result, is(8L));
	}

	@Test
	public void test_map_distinct() throws Exception {

		List<Order> orders = new Data().getOrders();

		// TODO Trouver la liste des différents clients associés aux commandes (sans doublons)
	//	List<Customer> result = null;
		List<Customer> result = orders.stream() // Je parcours toutes les commandes
						.map(order -> order.getCustomer()) // Je récupère le client de chaque commande
						.distinct() // Je supprime les clients en double
						.toList(); // Je retourne la liste des clients uniques

		assertThat(result, hasSize(2));
	}

	@Test
	public void test_map_distinct_count() throws Exception {

		List<Order> orders = new Data().getOrders();

		// TODO Compter le nombre des différents clients associés aux commandes
	//	long result = 0L;
		long result = orders.stream() // Je parcours toutes les commandes
				.map(order -> order.getCustomer()) // Je récupère le client de chaque commande
				.distinct() // Je garde uniquement les clients différents
				.count(); // Je compte les clients uniques

		assertThat(result, is(2L));
	}

	@Test
	public void test_mapToDouble_sum() throws Exception {

		List<Order> orders = new Data().getOrders();

		/*
		 * TODO Calculer le chiffre d'affaires total de la pizzeria (somme des prix des commandes)
		 */
	//	double result = 0.0;
		double result = orders.stream() // Je parcours toutes les commandes
				.mapToDouble(order -> order.getPrice()) // Je récupère le prix de chaque commande
				.sum(); // J'additionne tous les prix

		assertThat(result, is(10900.0));
	}

	@Test
	public void test_mapToDouble_avg() throws Exception {

		List<Order> orders = new Data().getOrders();

		/*
		 * TODO Calculer le prix moyen d'une commande
		 */
	//	OptionalDouble result = null;
		OptionalDouble result = orders.stream() // Je parcours toutes les commandes
				.mapToDouble(order -> order.getPrice()) // Je récupère le prix de chaque commande
				.average(); // Je calcule le prix moyen des commandes

		assertThat(result.isPresent(), is(true));
		assertThat(result.getAsDouble(), is(1362.5));
	}
}
