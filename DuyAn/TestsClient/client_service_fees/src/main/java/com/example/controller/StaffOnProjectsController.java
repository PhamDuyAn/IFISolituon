package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.Entity.Staff;
import com.example.Entity.StaffOnProjects;
import com.example.error.CustomErrorType;
import com.example.services.StaffOnProjectsService;

@RestController
@RequestMapping("/api")
public class StaffOnProjectsController {
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
	
	@Autowired 
	StaffOnProjectsService staffonprojectsservice;
	
	// -------------------Retrieve All staff on projects---------------------------------------------

//		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value = "/staffonprojects/", method = RequestMethod.GET)
		public ResponseEntity<List<StaffOnProjects>> ListAllStaffOnProjects() {
			List<StaffOnProjects> staffonprojects = staffonprojectsservice.findAllStaffOnProjects();
			if (staffonprojects==null) {
				System.out.println("go herhe");
				return new ResponseEntity(HttpStatus.NO_CONTENT);
				// You many decide to return HttpStatus.NOT_FOUND
			}
			return new ResponseEntity<List<StaffOnProjects>>(staffonprojects, HttpStatus.OK);
		}

		// -------------------Retrieve Single-----------------------------------------

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value = "/staffonprojects/{id}", method = RequestMethod.GET)
		public ResponseEntity<?> getStaffOnProjects(@PathVariable("id") int id) {
			logger.info("Fetching Staff with id {}", id);
			StaffOnProjects staffonprojects = staffonprojectsservice.findByIdStaffOnProjects(id);
			if (staffonprojects == null) {
				logger.error("Staff with id {} not found.", id);
				return new ResponseEntity(new CustomErrorType("Staff with id " + id 
						+ " not found"), HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<StaffOnProjects>(staffonprojects, HttpStatus.OK);
		}

		// -------------------Create staff--------------------

		@RequestMapping(value = "/staffonprojects/", method = RequestMethod.POST)
		public ResponseEntity<?> createStaffOnProjects(@RequestBody StaffOnProjects staffonprojects, UriComponentsBuilder ucBuilder) {
			logger.info("Creating Staff : {}", staffonprojects);

			if (staffonprojectsservice.isStaffExist(staffonprojects)) {
				logger.error("Unable to create. A Staff with name {} already exist", staffonprojects.getStaffOnProjectPeriocId());
				return new ResponseEntity(new CustomErrorType("Unable to create. A Staff with name " + 
						staffonprojects.getStaffOnProjectPeriocId() + " already exist."),HttpStatus.CONFLICT);
			}
			staffonprojectsservice.saveStaffOnProjects(staffonprojects);

			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/api/staff/{id}").buildAndExpand(staffonprojects.getStaffOnProjectPeriocId()).toUri());
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}

		// ------------------- Update-----------------------------------------------

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@RequestMapping(value = "/staffonprojects/{id}", method = RequestMethod.PUT)
		public ResponseEntity<?> updateStaffOnProjects(@PathVariable("id") int id, @RequestBody StaffOnProjects staffonprojects) {
			logger.info("Updating Staff with id {}", id);

			StaffOnProjects currentStaffOnProjects = staffonprojectsservice.findByIdStaffOnProjects(id);

			if (currentStaffOnProjects == null) {
				logger.error("Unable to update. Staff with id {} not found.", id);
				return new ResponseEntity(new CustomErrorType("Unable to upate. Staff with id " + id + " not found."),
						HttpStatus.NOT_FOUND);
			}

			currentStaffOnProjects.setProjects(staffonprojects.getProjects());
			currentStaffOnProjects.setStaff(staffonprojects.getStaff());
			currentStaffOnProjects.setRefRoles(staffonprojects.getRefRoles());
			currentStaffOnProjects.setFromDatetime(staffonprojects.getFromDatetime());
			currentStaffOnProjects.setToDatetime(staffonprojects.getToDatetime());
			currentStaffOnProjects.setHourtyRate(staffonprojects.getHourtyRate());
			staffonprojectsservice.updateStaffOnProjects(currentStaffOnProjects);
			return new ResponseEntity<StaffOnProjects>(currentStaffOnProjects, HttpStatus.OK);
		}

		// ------------------- Delete----------------------------------------

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value = "/staffonprojects/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<?> deleteStaffOnProjects(@PathVariable("id") int id) {
			logger.info("Fetching & Deleting User with id {}", id);

			StaffOnProjects staffonprojects = staffonprojectsservice.findByIdStaffOnProjects(id);
			if (staffonprojects == null) {
				logger.error("Unable to delete. Staff with id {} not found.", id);
				return new ResponseEntity(new CustomErrorType("Unable to delete. Staff with id " + id + " not found."),
						HttpStatus.NOT_FOUND);
			}
			staffonprojectsservice.deleteStaffOnProjectsById(id);
			return new ResponseEntity<Staff>(HttpStatus.NO_CONTENT);
		}

		// ------------------- Delete All-----------------------------

		@RequestMapping(value = "/staffonprojects/", method = RequestMethod.DELETE)
		public ResponseEntity<StaffOnProjects> deleteAllStaffOnprojects() {
			logger.info("Deleting All Users");

			staffonprojectsservice.deleteAllStaffOnProjects();
			return new ResponseEntity<StaffOnProjects>(HttpStatus.NO_CONTENT);
		}
	
}
