package io.egen.app.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
		@NamedQuery(name = "User.findAll", query = "SELECT u from User u ORDER BY u.email"),
		@NamedQuery(name = "User.findByEmail", query = "SELECT u from User u where u.email=:pEmail")
})
public class User {

	@Id
	private String uid;

	private String firstName;
	private String lastName;

	@Column(unique = true)
	private String email;
	private String password;

	
	

	public User() {
		uid = UUID.randomUUID().toString();
	}

	
	public String getId() {
		return uid;
	}

	public void setId(String uid) {
		this.uid = uid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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


	@Override
	public String toString() {
		return "User [uid=" + uid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}


	
}