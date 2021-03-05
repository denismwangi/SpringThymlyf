package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name= "employees")
public class Employees {
	
	@Id  @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	@NotNull
	
	private String firstname;
	@Column(nullable=false, unique=true)
	@NotNull
	
	@Email(message = "{error.invalid_email}")
	private String email;
	@Column(nullable=false)
	@NotNull
	
	@Size(min=4)
	private String lastname;
	@Column(nullable=false, unique=true)
	@NotNull
	

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	

}
