package ca.mcgill.ecse321.tutoringsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Application {
	private Boolean isExistingUser;

	public void setIsExistingUser(Boolean value) {
		this.isExistingUser = value;
	}

	public Boolean getIsExistingUser() {
		return this.isExistingUser;
	}

	private String name;

	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}

	private String email;

	public void setEmail(String value) {
		this.email = value;
	}

	public String getEmail() {
		return this.email;
	}

	private String courses;

	public void setCourses(String value) {
		this.courses = value;
	}

	public String getCourses() {
		return this.courses;
	}

	private Integer applicationId;

	public void setApplicationId(Integer value) {
		this.applicationId = value;
	}

	@Id
	@GeneratedValue()
	public Integer getApplicationId() {
		return this.applicationId;
	}
}
