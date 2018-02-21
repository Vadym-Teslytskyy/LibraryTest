package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Book;
import ua.repository.BookRepository;
import ua.service.BookService;

@Service
public class BookServiceImpl extends CrudServiceImpl<Book, Integer> implements BookService{

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        super(repository);
    }

}
