package com.internship.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internship.project.model.Projects;

@Repository
public interface ProjectManagementRepository extends JpaRepository<Projects, Long> {

	Projects findFirstById(long id);
}
