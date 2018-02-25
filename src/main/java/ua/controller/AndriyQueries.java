package ua.controller;

import ua.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class AndriyQueries {

    private static EntityManager em = EntityManagerFactoryCreator.factory.createEntityManager();

    public static void getBooksByMainAuthor(String authorLastName) {
        List mainAuthorsBooks = em.createQuery("select distinct b.name from Book b join b.mainAuthor c where c.lastName = ?1").setParameter(1, authorLastName).getResultList();
        System.out.println(mainAuthorsBooks);
    }

    public static void getBooksByCoAuthor(String coAuthorLastName) {
        List coAuthorsBooks = em.createQuery("select distinct b from Book b join fetch b.collaborationAuthors c where c.lastName = ?1").setParameter(1, coAuthorLastName).getResultList();
        System.out.println(coAuthorsBooks);
    }

    public static boolean isTheBookAvailable(String bookName) {
        try {
            em.createQuery("select b.id from Book b where (b.name = ?1 and avalibleCounter > 0)").setParameter(1, bookName).getSingleResult();
        } catch (NoResultException e) {
            return false;
        }
        return true;
    }

    public static void howManyTimesBookWasTakenAtAll(String bookName) {  // select how many time did someone take this book in general
        long tookTimesAtAll = (long) em.createQuery("select count(b.copyOfBook.id) from Rent b join b.copyOfBook c where c.book.name = ?1").setParameter(1, bookName).getSingleResult();
        System.out.println(tookTimesAtAll);
    }

    // public static void howManyTimesBooksCopyWasTaken(String bookName) {  // select how many time did someone take this book in general
    //     long bookTookTimesByCopies = (long) em.createQuery("select count(distinct b.copyOfBook.id) from Rent b join b.copyOfBook c where c.book.name = ?1").setParameter(1, bookName).getSingleResult();
    //     System.out.println(bookTookTimesByCopies);
    // }

    public static void howManyTimesBooksCopyWasTaken(String bookName) {  // select how many time did someone take this book in general
        List bookTookTimesByCopies = em.createQuery("select c.book.name, c.releaseDate, count(b.copyOfBook.id) from Rent b join b.copyOfBook c where c.book.name = ?1 group by c.book.name").setParameter(1, bookName).getResultList();
        System.out.println(bookTookTimesByCopies);
    }

    public static void averageBooksTimeReading(String bookName) {
        List avgBookTimeReading = em.createQuery("SELECT avg (datediff(p.returnTime,p.borrowingTime)) FROM Rent p join p.copyOfBook c where c.book.name = ?1 and p.returnTime is not null ").setParameter(1, bookName).getResultList();
        System.out.println(avgBookTimeReading);
    }

    public static void whichBookDidTakeTheUser(String login) {  // it check from client book table
        List takenBooks = em.createQuery("select b.readedBooks from Client b where b.login = ?1").setParameter(1, login).getResultList();
        System.out.println(takenBooks);
    }

    public static void whichBooksUserDidntReturn(String login) {  //  it check with client book table
        List notReturnedBooks = em.createQuery("select b.readedBooks from Client b join b.rents c where c.returnTime is null and b.login = ?1").setParameter(1, login).getResultList();
        System.out.println(notReturnedBooks);
    }

    public static void howMuchTimeTheClientUseTheLibrary(String login) {
        LocalDate userRegistrationDate = (LocalDate) em.createQuery("select c.registrationDate from Client c where c.login = ?1").setParameter(1, login).getSingleResult();
        Period userRegistrationTime = Period.between(LocalDate.now(), userRegistrationDate);
        System.out.printf("user '%s' is registered for %s days", login, userRegistrationTime.getDays());
    }

}
