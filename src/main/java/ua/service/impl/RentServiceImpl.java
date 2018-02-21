package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Rent;
import ua.repository.RentRepository;
import ua.service.RentService;

@Service
public class RentServiceImpl extends CrudServiceImpl<Rent, Integer> implements RentService{

    @Autowired
    public RentServiceImpl(RentRepository repository) {
        super(repository);
    }

}
