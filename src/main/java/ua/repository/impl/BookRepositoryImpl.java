package ua.repository.impl;


import ua.entity.Book;
import ua.repository.BookRepository;


public class BookRepositoryImpl extends CrudRepositoryImpl<Book, Integer> implements BookRepository{

    public BookRepositoryImpl() {
        setClazz(Book.class);
    }

}

