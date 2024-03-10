package com.internship.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship.project.model.Projects;
import com.internship.project.repository.ProjectManagementRepository;

import exception.ProjectManagementException;
import jakarta.validation.Valid;

@Service
public class ProjectManagementService {

	@Autowired
	ProjectManagementRepository projManagementRepository;

	public Projects findById(long id) throws ProjectManagementException {
		try {
			Projects projectDetails = projManagementRepository.findFirstById(id);
			return projectDetails;
		} catch (Exception ex) {
			throw new ProjectManagementException(ex.getMessage());
		}

	}

	public Projects createProject(@Valid Projects project) throws ProjectManagementException {
		// TODO Auto-generated method stub
		try {
			Projects projectDetails = projManagementRepository.save(project);
			return projectDetails;
		}

		catch (Exception ex) {
			throw new ProjectManagementException(ex.getMessage());
		}
	}

	public void deleteAll() throws ProjectManagementException {
		try {
			projManagementRepository.deleteAll();
			// TODO Auto-generated method stub
		} catch (Exception ex) {
			throw new ProjectManagementException(ex.getMessage());
		}
	}

	public void deleteById(Long id) throws ProjectManagementException {
		try {
			// TODO Auto-generated method stub
			projManagementRepository.deleteById(id);
		} catch (Exception ex) {
			throw new ProjectManagementException(ex.getMessage());
		}
	}

	public Projects save(Projects project) throws ProjectManagementException {
		try {
			// TODO Auto-generated method stub
			return projManagementRepository.save(project);
		} catch (Exception ex) {
			throw new ProjectManagementException(ex.getMessage());
		}
	}

	public List<Projects> findAll() throws ProjectManagementException {
		try {
			// TODO Auto-generated method stub
			return projManagementRepository.findAll();
		} catch (Exception ex) {
			throw new ProjectManagementException(ex.getMessage());
		}

	}
}
