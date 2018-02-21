package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Author;
import ua.repository.AuthorRepository;
import ua.service.AuthorService;

@Service
public class AuthorServiceImpl extends CrudServiceImpl<Author, Integer> implements AuthorService{

    @Autowired
    public AuthorServiceImpl(AuthorRepository repository) {
        super(repository);
    }

}
