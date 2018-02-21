package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Rent;

public interface RentRepository extends JpaRepository<Rent, Integer>{

}
