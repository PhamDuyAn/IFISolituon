package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.ServicesOnProjects;
import com.example.Entity.ServicesOnProjectsId;

public interface ServicesOnProjectsRepository extends JpaRepository<ServicesOnProjects, Long> {

}
