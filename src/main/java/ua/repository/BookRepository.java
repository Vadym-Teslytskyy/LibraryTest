package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
