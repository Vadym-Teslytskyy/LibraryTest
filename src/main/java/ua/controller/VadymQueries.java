package ua.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;


import ua.entity.Book;
import ua.entity.Client;

/**
 * Вадим - 4, 6, 7 4. Скільки книжок в бібліотеці, які видані в період
 * незалежності 6. Отримати найпопулярніші та найнепопулярніші книжки за період
 * 7. Отримати список читачів-боржників з детальною інформацією
 **/
public class VadymQueries {
    static EntityManagerFactory factory = EntityManagerFactoryCreator.factory;
    private static final LocalDate INDEPENDENCE_DAY_DATE = LocalDate.of(1991, Month.AUGUST, 24);

    private static void task4() {
        EntityManager em = factory.createEntityManager();

        List<Book> books = em
                .createQuery(
                        "SELECT b FROM Book b JOIN FETCH b.copiesList c WHERE c.releaseDate BETWEEN :startDate AND :endDate",
                        Book.class)
                .setParameter("startDate", INDEPENDENCE_DAY_DATE).setParameter("endDate", LocalDate.now())
                .getResultList();
        System.out.println(books);
        em.close();
    }

    private static void task7() {
        EntityManager em = factory.createEntityManager();
        List<Client> clients = em.createQuery(
                "SELECT c FROM Client c JOIN FETCH c.rents r WHERE r.returnTime IS NULL AND r.borrowingTime IS NOT NULL",
                Client.class)
                .getResultList();
        System.out.println(clients);
        em.close();
    }
    //Add values in db and check methods
    private static void task6(int periodInDays) {
        EntityManager em = factory.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        LocalDate startDate = LocalDate.now().minusDays(periodInDays);
       
         List<Object[]> a = em.createQuery(
                 "SELECT b, COUNT(r.id) FROM Rent r JOIN r.copyOfBook c JOIN c.book b  GROUP BY b.id ORDER BY COUNT(r.id) DESC", 
                 Object[].class)
                 .setMaxResults(5)
                .getResultList();
         a.forEach(array -> {
             System.out.println(Arrays.toString(array));
         });
        System.out.println();
        em.close();
    }

    public static void main(String[] args) {
        //task4();
        //task7();
        task6(1);
    }
    
    

    @Override
    protected void finalize() throws Throwable {
        factory.close();
        super.finalize();
    }

}
