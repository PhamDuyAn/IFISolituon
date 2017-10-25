package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Entity.StaffOnProjects;

public interface StaffOnProjectsRepository extends JpaRepository<StaffOnProjects, Integer> {

	
	
}
