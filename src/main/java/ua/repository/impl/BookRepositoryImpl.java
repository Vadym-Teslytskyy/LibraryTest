package ua.repository.impl;

import javax.persistence.Id;

import ua.entity.Book;


public class BookRepositoryImpl extends CrudRepositoryImpl<Book, Integer> {

    public BookRepositoryImpl() {
        setClazz(Book.class);
    }

}

