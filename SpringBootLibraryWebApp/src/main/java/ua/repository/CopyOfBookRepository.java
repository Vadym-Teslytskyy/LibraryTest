package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.CopyOfBook;

public interface CopyOfBookRepository extends JpaRepository<CopyOfBook, Integer>{

}
