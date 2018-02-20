package ua.repository.impl;


import ua.entity.Book;
import ua.repository.BookRepository;

import javax.persistence.NoResultException;
import java.util.List;


public class BookRepositoryImpl extends CrudRepositoryImpl<Book, Integer> implements BookRepository {

    public BookRepositoryImpl() {
        setClazz(Book.class);
    }

    public void getBooksByMainAuthor(String authorFirsName, String authorLastName) {
        List mainAuthorsBooks = getEntityManager()
                .createQuery("select distinct b.name from Book b join b.mainAuthor c where c.firstName = ?1 and c.lastName = ?2")
                .setParameter(1, authorFirsName)
                .setParameter(2, authorLastName)
                .getResultList();
        if (mainAuthorsBooks.isEmpty()) {
            System.out.printf("It's seams the author %s %s doesn't has the books at all\nCheck the name", authorFirsName, authorLastName);
        } else {
            System.out.printf("This is all books of main author %s %s", authorFirsName, authorLastName, mainAuthorsBooks);
            System.out.println(mainAuthorsBooks);
        }
        closeEntityManager();
    }

    public void getBooksByCoAuthor(String coAuthorFirsName, String coAuthorLastName) {
        List coAuthorsBooks = getEntityManager()
                .createQuery("select distinct b.name from Book b join b.collaborationAuthors c where c.firstName = ?1 and c.lastName = ?2")
                .setParameter(1, coAuthorFirsName)
                .setParameter(2, coAuthorLastName)
                .getResultList();
        if (coAuthorsBooks.isEmpty()) {
            System.out.printf("It's seams the author %s %s doesn't has any books in cooperation at all\nCheck the name", coAuthorFirsName, coAuthorLastName);
        } else {
            System.out.printf("This is all cooperation books of author %s %s", coAuthorFirsName, coAuthorLastName, coAuthorsBooks);
            System.out.println(coAuthorsBooks);
        }
        closeEntityManager();
    }

    public boolean isTheBookAvailable(String bookName) {
        try {
            getEntityManager()
                    .createQuery("select b.id from Book b where (b.name = ?1 and avalibleCounter > 0)").setParameter(1, bookName)
                    .getSingleResult();
            closeEntityManager();
        } catch (NoResultException e) {
            return false;
        }
        return true;
    }

    public void howManyTimesBookWasTakenAtAll(String bookName) {
        long tookTimesAtAll = (long) getEntityManager()
                .createQuery("select count(b.copyOfBook.id) from Rent b join b.copyOfBook c where c.book.name = ?1")
                .setParameter(1, bookName)
                .getSingleResult();
        if (tookTimesAtAll == 0) {
            System.out.printf("Any of this book: %s has never been taken or you entered incorrect books name", bookName);
        } else {
            System.out.printf("There was taken %s books %s", tookTimesAtAll, bookName);
        }
        closeEntityManager();
    }

    public void averageBooksTimeReading(String bookName) {
        try {
            double avgBookTimeReading = (double) getEntityManager()
                    .createQuery("select avg (datediff(p.returnTime,p.borrowingTime)) from Rent p join p.copyOfBook c where c.book.name = ?1 and p.returnTime is not null ")
                    .setParameter(1, bookName)
                    .getSingleResult();
            System.out.printf("The average time of reading the book %s - is %s hours", bookName, avgBookTimeReading);
        } catch (NullPointerException e) {
            System.out.printf("Any of this book: %s has not yet been returned or you entered incorrect books name", bookName);
        }
        closeEntityManager();
    }

    public void whichBookDidTakeTheUser(String login) {
        List takenBooks = getEntityManager()
                .createQuery("select b.readedBooks from Client b where b.login = ?1")
                .setParameter(1, login)
                .getResultList();
        if (takenBooks.isEmpty()) {
            System.out.printf("It's seams the user: % didn't take any book", login);
        } else {
            System.out.println(takenBooks);
        }
        closeEntityManager();
    }

    public void whichBooksUserDidntReturn(String login) {
        List notReturnedBooks = getEntityManager()
                .createQuery("select b.readedBooks from Client b join b.rents c where c.returnTime is null and b.login = ?1")
                .setParameter(1, login)
                .getResultList();
        System.out.println(notReturnedBooks);
        if (notReturnedBooks.isEmpty()) {
            System.out.printf("It's seams the user: %s have returned all books", login);
        } else {
            System.out.println(notReturnedBooks);
        }
        closeEntityManager();
    }

}

