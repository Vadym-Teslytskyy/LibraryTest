package ua.DAO.book;

import ua.entity.Book;


public class BookService extends AbstractJpaDao {

    public BookService() {
        setClazz(Book.class);
    }

}

