package ua.controller;

import javax.lang.model.element.NestingKind;
import javax.persistence.EntityManager;
import java.util.List;

public class AndriyClass {

    private static EntityManager em;

    public AndriyClass() {
        em = EntityManagerFactoryCreator.factory.createEntityManager();
    }

    public static void getBooksByMainAuthor() {
        List books = em.createQuery("select b from Book b join b.mainAuthor c where c.lastName = 'King'").getResultList();
        System.out.println(books);
    }

    public static void getBooksByCoAuthor() {
        List books = em.createQuery("select b from Book b join b.collaborationAuthors c where c.lastName = 'London'").getResultList();
        System.out.println(books);
    }

    public static boolean isTheBookAvailable(String bookName) {
        List books = em.createQuery("select b from Book b where (b.name = ?1 and avalibleCounter > 0)").setParameter(1, bookName).getResultList();
        return !books.isEmpty();
    }

    public static void howManyTimesSomeOneTookThisBookByRelaseDates(String bookName) {  // select how many time did someone take this book in general
        List books = em.createQuery("select count(b.copyOfBook.id) from Rent b join b.copyOfBook c where c.book.name = ?1").setParameter(1, bookName).getResultList();
        System.out.println(books);
    }

    public static void howManyTimesSomeOneTookThisBook(String bookName) {  // select how many time did someone take this book in general
        List books = em.createQuery("select count(distinct b.copyOfBook.id) from Rent b join b.copyOfBook c where c.book.name = ?1").setParameter(1, bookName).getResultList();
        System.out.println(books);
    }

    public static void averageBooksTimeReading(String bookName) {
        List books = em.createQuery("select avg (b.borrowingTime) from Rent b join b.copyOfBook c where c.book.name = ?1").setParameter(1, bookName).getResultList();
        System.out.println(books);
    }

    public static void whichBookDidTakeTheUser(String login) {  // it check from client book table
        List books = em.createQuery("select b.readedBooks from Client b where b.login = ?1").setParameter(1, login).getResultList();
        System.out.println(books);
    }

    public static void whichBookDidTakeTheUserAndDidntReturn(String login) {  //  it check with client book table
        List books = em.createQuery("select b.readedBooks from Client b join b.rents c where c.returnTime is null and b.login = ?1").setParameter(1, login).getResultList();
        System.out.println(books);
    }

    public void howMuchTimeTheClientUseTheLibrary(){

    }

    public static void main(String[] args) {
        AndriyClass andriyClass = new AndriyClass();
//        getBooksMainAuthor();
//        getBooksByCoAuthor();
//        System.out.println(isTheBookAvailable("White Eagle"));
//        howManyTimesSomeOneTookThisBookByRelaseDates("White Eagle");
//        howManyTimesSomeOneTookThisBook("White Eagle");
//        averageBooksTimeReading("White Eagle");
        whichBookDidTakeTheUser("shoomi");
//        whichBookDidTakeTheUserAndDidntReturn("shoomi");
    }


}
