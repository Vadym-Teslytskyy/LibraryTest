package ua.controller;

import javax.persistence.EntityManagerFactory;

import ua.repository.impl.BookRepositoryImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
//        bookRepository.averageBooksTimeReading("The Blackdf Tower");
//        bookRepository.howManyTimesBookWasTakenAtAll("The Blackdf Tower");
        bookRepository.getBooksByCoAuthor("Stiven","King");


/*git
        // Test code for OksanaQueries.

        EntityManagerFactory factory = EntityManagerFactoryCreator.factory;
        OksanaQueries oksanaQueries = new OksanaQueries(factory);
        oksanaQueries.task8_1();
        oksanaQueries.task8_2(1);
        oksanaQueries.task10_1("Interesting.");

        factory.close();
*/
    }
}
