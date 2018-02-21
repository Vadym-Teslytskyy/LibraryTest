package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.CopyOfBook;
import ua.repository.CopyOfBookRepository;
import ua.service.CopyOfBookService;

@Service
public class CopyOfBookServiceImpl extends CrudServiceImpl<CopyOfBook, Integer> implements CopyOfBookService{
    
    @Autowired
    public CopyOfBookServiceImpl(CopyOfBookRepository repository) {
        super(repository);
    }

}
