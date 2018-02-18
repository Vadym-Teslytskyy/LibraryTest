package ua.controller;

import ua.DAO.book.BookService;
import ua.entity.Book;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        BookService bookService = new BookService();
//        Book book = new Book();
//        book.setName("aaaaaaaaaa");
//        book.setAvalibleCounter(544444455);
//        bookBookService.update(book);
        List list = bookService.findAll();
        System.out.println(list);


    }

}
