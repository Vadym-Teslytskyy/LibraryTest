package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Genre;
import ua.repository.GenreRepository;
import ua.service.GenreService;

@Service
public class GenreServiceImpl extends CrudServiceImpl<Genre, Integer> implements GenreService{

    @Autowired
    public GenreServiceImpl(GenreRepository repository) {
        super(repository);
    }

}
