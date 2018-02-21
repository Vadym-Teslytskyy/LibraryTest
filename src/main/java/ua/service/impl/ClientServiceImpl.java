package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Client;
import ua.repository.ClientRepository;
import ua.service.ClientService;

@Service
public class ClientServiceImpl extends CrudServiceImpl<Client, Integer> implements ClientService{
    
    @Autowired
    public ClientServiceImpl(ClientRepository repository) {
        super(repository);
    }

}
