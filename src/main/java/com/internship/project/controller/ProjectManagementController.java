package com.internship.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.internship.project.model.Projects;
import com.internship.project.service.ProjectManagementService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/api/project")
public class ProjectManagementController {

	@Autowired
	ProjectManagementService projectManagementService;

	@GetMapping(value = "/getProjectDeatilsById/{id}")
	public ResponseEntity<Projects> getProjectDeatilsById(@PathVariable Long id)  {
		try {
			Projects project = projectManagementService.findById(id);

			if (null != project) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(project, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/getAllProjectDeatils")
	public ResponseEntity<List<Projects>> getAllProjectDeatils()  {
		try {
			List<Projects> project = projectManagementService.findAll();

			if (null != project) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(project, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/saveProjectDeatils")
	public ResponseEntity<Projects> saveProjectDeatils(@Valid @RequestBody Projects project) {
		try {
			Projects projectObj = projectManagementService.save(project);
			return new ResponseEntity<>(projectObj, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/updateProject")
	public ResponseEntity<Projects> updateProject(@RequestBody Projects projects) {
		try {
			Projects project = projectManagementService.findById(projects.getId());
			if (null != project) {
				Projects projectObj = projectManagementService.save(project);
				return new ResponseEntity<>(projectObj, HttpStatus.CREATED);
			}

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteProjectById/{id}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable Long id) {
		try {
			projectManagementService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteAllProjects")
	public ResponseEntity<HttpStatus> deleteAllProjects() {
		try {
			projectManagementService.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
