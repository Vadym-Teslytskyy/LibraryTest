package ua.controller;

import javax.persistence.EntityManager;
import java.util.List;

public class AndriyClass {

    static {
        EntityManagerFactoryCreator entityManagerFactoryCreator = new EntityManagerFactoryCreator();
    }

    public static void clientStatistic() {
        EntityManager em = EntityManagerFactoryCreator.factory.createEntityManager();
        List books = em.createQuery("select b from Book b join b.mainAuthor c where c.lastName = 'King'").getResultList();
        System.out.println(books);
    }

    public static void main(String[] args) {
        clientStatistic();
    }
}
