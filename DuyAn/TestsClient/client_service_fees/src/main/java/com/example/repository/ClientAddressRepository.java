package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.ClientAddresses;

public interface ClientAddressRepository extends JpaRepository<ClientAddresses,String > {

}
