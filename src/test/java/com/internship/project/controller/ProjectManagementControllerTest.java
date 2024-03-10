package com.internship.project.controller;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.internship.project.model.Projects;
import com.internship.project.repository.ProjectManagementRepository;
import com.internship.project.service.ProjectManagementService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjectManagementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectManagementRepository proManagementRepository;
    
    @MockBean
    private ProjectManagementService proManagementService;
    
    @InjectMocks
  private ProjectManagementController projrManagementController;
    
    @Autowired
    WebApplicationContext webApplicationContext;


    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private TestRestTemplate restTemplate;
    
    @LocalServerPort
    private int port;
    
    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @BeforeEach
    void setup(){
    	mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    	  Projects project = new Projects((long) 1,"test","test");
    }

    @Test
    public void givenProjectObject_whenCreateProject_thenReturnSavedProject() throws Exception{

        // given - precondition or setup
        Projects project = new Projects((long) 1,"test","test");
		/*
		 * project.setId((long) 1); project.setProjectname("test");
		 * project.setProjectdesc("test");
		 */
        ObjectMapper obj=new ObjectMapper();
        String requestObject= obj.writeValueAsString(project);
        
      HttpHeaders httpheader=new HttpHeaders();
      httpheader.add("Content-Type","application/json");
        // when - action or behaviour that we are going test
        lenient().when(proManagementService.createProject(project)).thenReturn(project);
        MvcResult mvcResult=mockMvc.perform(post("/api/project/saveProjectDeatils").headers(httpheader).content(requestObject)).andExpect(status().isCreated()).andReturn();
        assertEquals(201,mvcResult.getResponse().getStatus());

    }

    // JUnit test for Get All Project REST API
	
    @Ignore
	  public void given_whenGetAllProjects_thenReturnProjectsList() throws Exception{
		  // given - precondition or setup 
	   List<Projects> listOfProjects = new ArrayList<>();
	   HttpHeaders headers = new HttpHeaders();
       HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/project/getAllProjectDeatils",
       HttpMethod.GET, entity, String.class);

       assertNotNull(response.getBody());
	 
	  }
	  
	  @Test
	    public void givenUpdatedProject_whenUpdateProject_thenReturnUpdatedProjectObject() {
	         int id = 1;
	         Projects projet = restTemplate.getForObject(getRootUrl() + "/api/project/updateProject/" + id, Projects.class);
	         projet.setProjectdesc("admin1");
	         projet.setProjectname("admin2");
	
	         restTemplate.put(getRootUrl() + "/api/project/updateProject/" + id, projet);
	
	         Projects updatedProject = restTemplate.getForObject(getRootUrl() + "/api/project/updateProject/" + id, Projects.class);
	         assertNotNull(updatedProject);
	    }

		 
	 
}