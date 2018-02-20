package ua.repository.impl;


import ua.entity.Book;
import ua.repository.BookRepository;

import javax.persistence.NoResultException;
import java.util.List;


public class BookRepositoryImpl extends CrudRepositoryImpl<Book, Integer> implements BookRepository {

    public BookRepositoryImpl() {
        setClazz(Book.class);
    }

    public void getBooksByMainAuthor(String authorLastName) {
        List mainAuthorsBooks = getEntityManager().createQuery("select distinct b.name from Book b join b.mainAuthor c where c.lastName = ?1").setParameter(1, authorLastName).getResultList();
        System.out.println(mainAuthorsBooks);
        if (mainAuthorsBooks.isEmpty()) {
            System.out.printf("It's seams the author %s haven't the books", authorLastName);
        } else {
            System.out.println(mainAuthorsBooks);
        }
        closeEntityManager();
    }

    public void getBooksByCoAuthor(String coAuthorLastName) {
        List coAuthorsBooks = getEntityManager().createQuery("select distinct b from Book b join fetch b.collaborationAuthors c where c.lastName = ?1").setParameter(1, coAuthorLastName).getResultList();
        if (coAuthorsBooks.isEmpty()) {
            System.out.printf("It's seams the author %s haven't the books", coAuthorLastName);
        } else {
            System.out.println(coAuthorsBooks);
        }
        closeEntityManager();
    }

    public boolean isTheBookAvailable(String bookName) {
        try {
            getEntityManager().createQuery("select b.id from Book b where (b.name = ?1 and avalibleCounter > 0)").setParameter(1, bookName).getSingleResult();
            closeEntityManager();
        } catch (NoResultException e) {
            return false;
        }
        return true;
    }

    public void howManyTimesBookWasTakenAtAll(String bookName) {
        long tookTimesAtAll = (long) getEntityManager().createQuery("select count(b.copyOfBook.id) from Rent b join b.copyOfBook c where c.book.name = ?1").setParameter(1, bookName).getSingleResult();
        System.out.println(tookTimesAtAll);
        closeEntityManager();
    }

    public void averageBooksTimeReading(String bookName) {
        double avgBookTimeReading = (double) getEntityManager().createQuery("SELECT avg (datediff(p.returnTime,p.borrowingTime)) FROM Rent p join p.copyOfBook c where c.book.name = ?1 and p.returnTime is not null ").setParameter(1, bookName).getSingleResult();
        System.out.printf("The average time of reading the book %s - is %s hours", bookName, avgBookTimeReading);
        closeEntityManager();
    }

    public void whichBookDidTakeTheUser(String login) {
        List takenBooks = getEntityManager().createQuery("select b.readedBooks from Client b where b.login = ?1").setParameter(1, login).getResultList();
        if (takenBooks.isEmpty()) {
            System.out.printf("It's seams the user: % didn't take any book", login);
        } else {
            System.out.println(takenBooks);
        }
        closeEntityManager();
    }

    public void whichBooksUserDidntReturn(String login) {
        List notReturnedBooks = getEntityManager().createQuery("select b.readedBooks from Client b join b.rents c where c.returnTime is null and b.login = ?1").setParameter(1, login).getResultList();
        System.out.println(notReturnedBooks);
        if (notReturnedBooks.isEmpty()) {
            System.out.printf("It's seams the user: %s have returned all books", login);
        } else {
            System.out.println(notReturnedBooks);
        }
        closeEntityManager();
    }

}

