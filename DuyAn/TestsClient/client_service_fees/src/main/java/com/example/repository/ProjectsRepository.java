package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Entity.Projects;

public interface ProjectsRepository extends JpaRepository<Projects, Integer>{
	
}
