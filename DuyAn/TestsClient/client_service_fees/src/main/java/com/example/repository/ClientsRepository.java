package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Clients;

public interface ClientsRepository extends JpaRepository<Clients, Long> {

}
