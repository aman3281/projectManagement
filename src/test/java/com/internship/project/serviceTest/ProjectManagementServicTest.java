package com.internship.project.serviceTest;



import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.internship.project.controller.ProjectManagementController;
import com.internship.project.model.Projects;
import com.internship.project.repository.ProjectManagementRepository;
import com.internship.project.service.ProjectManagementService;

import jakarta.validation.Valid;

@RunWith(MockitoJUnitRunner.class)
public class ProjectManagementServicTest {


	@Mock
	private ProjectManagementService proManagementService;


	@MockBean
	private ProjectManagementRepository proManagementRepository;



	Optional<Projects> project = Optional.of(new Projects((long) 1, "test", "test"));

	Projects projects = new Projects((long) 1, "test", "test");

	@Ignore
	public void givenProjectObject_whenSaveProject_thenReturnProjectObject() {
		given(proManagementRepository.findById(project.get().getId())).willReturn(project);

		given(proManagementRepository.save(projects)).willReturn(projects);

		System.out.println(proManagementRepository);
		System.out.println(proManagementService);

		// when - action or the behaviour that we are going test
		Projects updatedProjects = proManagementService.save(projects);

		System.out.println(projects);
		// then - verify the output
		assertThat(projects).isNotNull();
	}

}
