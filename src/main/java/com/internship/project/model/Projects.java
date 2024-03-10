package com.internship.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Builder
public class Projects {

	@Id
	@GeneratedValue
	private Long id;
	
	 @NotNull(message="praoject name can't be empty")
	@Column(name="project_name")
	private String projectname;
	  @Column(name="project_desc")
	private String projectdesc;

	 
	public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getProjectname() {
			return projectname;
		}
		public void setProjectname(String projectname) {
			this.projectname = projectname;
		}
		public String getProjectdesc() {
			return projectdesc;
		}
		public void setProjectdesc(String projectdesc) {
			this.projectdesc = projectdesc;
		}
		public Projects(Long id, @NotNull(message = "praoject name can't be empty") String projectname,
				String projectdesc) {
			super();
			this.id = id;
			this.projectname = projectname;
			this.projectdesc = projectdesc;
		}
		
		
		

}
