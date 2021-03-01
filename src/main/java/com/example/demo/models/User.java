package com.example.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import javax.persistence.JoinColumn;


/**
 * 
 * @author denniske
 *
 */

@Entity
@Table(name="users")
public class User {
	
	@Id  @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(nullable=false)
	@NotNull
	
	private String name;
	@Column(nullable=false, unique=true)
	@NotNull
	
	@Email(message = "{error.invalid_email}")
	private String email;
	@Column(nullable=false)
	@NotNull
	@Size(min=4)
	
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(
			name="user_role",
			joinColumns= {@JoinColumn(name="USER_ID", referencedColumnName="ID")},
			inverseJoinColumns= {@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
	
	private List<Role> roles;
	
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
 
	
	
	
	
	
	
	

}
