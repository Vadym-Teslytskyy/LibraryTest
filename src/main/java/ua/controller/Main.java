package ua.controller;

import ua.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Book book = new Book();
		book.setName("ldskjdkjf");
		em.persist(book);
		em.getTransaction().commit();
		factory.close();
	}

}
