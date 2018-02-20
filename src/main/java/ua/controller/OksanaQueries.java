package ua.controller;

import ua.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Запити для пунктів 8, 9, 10.
 * 8. Статистика по читачам (середній вік, час користування
 * бібліотекою, середня кількість звернень за певний період).
 * 9. Отримати середній вік читачів по певній книжці,
 * по певному автору.
 * 10.Вивести по назві книжки, кількість екземплярів
 * з інформацією про них (наявна, на руках).
 */
public class OksanaQueries {

    private final EntityManagerFactory factory;

    public OksanaQueries(EntityManagerFactory factory) {
        this.factory = factory;
    }

    /**
     * Статистика по читачам (середній вік).
     * SELECT AVG(client.age)
     * FROM librarydb.client;
     */
    public void task8_1() {
        EntityManager em = factory.createEntityManager();
        System.out.println("Task 8.1 result: "
                + em.createQuery("SELECT AVG(client.age) " +
                "FROM Client client")
                .getSingleResult());
        em.close();
    }

    /**
     * Статистика по читачам (час користування бібліотекою (в днях).
     * SELECT DATEDIFF(NOW(), client.registration_date) AS time_of_use
     *     FROM librarydb.client
     *     WHERE client.id = 1;
     */
    public void task8_2(int clientId) {
        EntityManager em = factory.createEntityManager();
        List<Object[]> resultList = em.createQuery(
                "SELECT DATEDIFF(NOW(), client.registrationDate) "
                + "FROM Client client "
                + "WHERE client.id = ?1", Object[].class)
                .setParameter(1, clientId)
                .getResultList();
        System.out.println("Task 8.2 result: ");
        System.out.println(resultList);
        em.close();
    }

    /**
     * Статистика по читачам (середня кількість звернень за певний період).
     * SELECT AVG(one_client_count) AS avarage_count_before_one_week_ago_date
     *     FROM librarydb.client,
     *         (SELECT count(rent.id) AS one_client_count
     *             FROM librarydb.rent, librarydb.client
     *             WHERE rent.user_id = client.id
     *             AND rent.borrowing_time > one_week_ago_date "2001.01.01"
     *         GROUP BY client.id)	AS temp_table;
     */
    public void task8_3(int periodInDays) {
        EntityManager em = factory.createEntityManager();
        LocalDate startDate = LocalDate.now().minusDays(periodInDays);

        String sql = "SELECT AVG(one_client_count) " +
                "FROM client, " +
                "(SELECT count(rent.id) AS one_client_count " +
                "FROM rent, client  " +
                "WHERE rent.user_id = client.id " +
                "AND rent.borrowing_time > '" + startDate + "' " +
                "GROUP BY client.id) AS temp_table";
        Query nativeQuery = em.createNativeQuery(sql);
        BigDecimal result = (BigDecimal) nativeQuery.getSingleResult();

        System.out.println("Task 8.3 result: ");
        System.out.println(result);
        em.close();
    }

    /**
     * Отримати середній вік читачів по певній книжці.
     * SELECT book.name, AVG(client.age) AS avarage_client_age
     *     FROM client_book JOIN book ON readedBooks_id = book.id
     *                      JOIN client ON Client_id = client.id
     *     GROUP BY book.id;
     */
    public void task9_1() {
        EntityManager em = factory.createEntityManager();
        List<Object[]> resultList = em.createQuery(
                "SELECT book.name, AVG(client.age) "
                        + "FROM Client client "
                        + "JOIN client.readedBooks book "
                        + "GROUP BY book.id", Object[].class)
                .getResultList();
        System.out.println("Task 9.1 result: ");
        for (Object[] array : resultList) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
        em.close();
    }

    /**
     * Отримати середній вік читачів по певному автору (по кожному).
     * SELECT CONCAT(author.first_name, " ", author.last_name) AS author,
     *        AVG(client.age) AS avarage_client_age
     *     FROM client_book JOIN client ON Client_id = client.id
     *                      JOIN book ON readedBooks_id = book.id
     *                      JOIN author ON book.mainAuthor_id = author.id
     *     GROUP BY author.id;
     */
    public void task9_2() {
        EntityManager em = factory.createEntityManager();
        List<Object[]> resultList = em.createQuery(
                "SELECT CONCAT(author.firstName, author.lastName), AVG(client.age)"
                        + "FROM Client client JOIN client.readedBooks book "
                        + "JOIN book.mainAuthor author "
                        + "GROUP BY author.id", Object[].class)
                .getResultList();
        System.out.println("Task 9.2 result: ");
        for (Object[] array : resultList) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
        em.close();
    }

    /**
     * Вивести по назві книжки, кількість екземплярів
     * з інформацією про них (наявна, на руках).
     * SELECT name, general_counter, available_counter
     *      FROM book
     *      WHERE name = "Interesting.";
     */
    public void task10_1(String bookName) {
        EntityManager em = factory.createEntityManager();
        Book book = (Book) em.createQuery(
                "SELECT book FROM Book book "
                + "WHERE book.name = ?1")
                .setParameter(1, bookName)
                .getSingleResult();
        System.out.println("Task 10.1 result: ");
        System.out.println(book.getName() + ", "
                + book.getGeneralCounter() + ", "
                + book.getAvalibleCounter());
        em.close();
    }
}
