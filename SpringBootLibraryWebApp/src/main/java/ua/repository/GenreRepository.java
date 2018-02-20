package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer>{

}
