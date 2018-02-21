package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
