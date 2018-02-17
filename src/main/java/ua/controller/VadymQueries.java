package ua.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import ua.entity.Book;

/**
 * Вадим - 4, 6, 7
 * 4. Скільки книжок в бібліотеці, які видані в період незалежності
 * 6. Отримати найпопулярніші та найнепопулярніші книжки за період
 * 7. Отримати список читачів-боржників з детальною інформацією
 **/
public class VadymQueries {
    EntityManagerFactory factory = EntityManagerFactoryCreator.factory;
    private static final LocalDate INDEPENDENCE_DAY_DATE = LocalDate.of(1991, Month.AUGUST, 24);

	private void task4(){
		EntityManager em = factory.createEntityManager();
		
		List<Book> books = em.createQuery("SELECT b FROM Book b JOIN FETCH b.copiesList c WHERE c.releaseDate BETWEEN :startDate AND :endDate",Book.class)
		        .setParameter("startDate",INDEPENDENCE_DAY_DATE)
		        .setParameter("endDate", LocalDate.now())
		        .getResultList();
		
		em.close();
	}

    @Override
    protected void finalize() throws Throwable {
        factory.close();
        super.finalize();
    } 
	
	
}
