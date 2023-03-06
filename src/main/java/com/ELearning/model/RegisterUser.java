package com.ELearning.model;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;


import lombok.Data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor

@Entity
@Data
@Table(name="user_info")
public class RegisterUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;

	private String userName;
	private String firstName;
	private String lastName;
	private String pass;
	private String number;
	private String dob;
	private String gender;
	private int role;

	

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	public RegisterUser() {
		
	}
public RegisterUser(int userId, String userName, String firstName, String lastName, String pass, String number, String dob,
		String gender, int role) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.firstName = firstName;
	this.lastName = lastName;
	this.pass = pass;
	this.number = number;
	this.dob = dob;
	this.gender = gender;
	this.role = role;
}
public RegisterUser(int userId, String userName, String firstName, String lastName, String pass, int role) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.firstName = firstName;
	this.lastName = lastName;
	this.pass = pass;
	this.role = role;
}
public RegisterUser(String userName, String firstName, String lastName, String pass, String number, String dob,
		String gender, int role) {
	super();
	this.userName = userName;
	this.firstName = firstName;
	this.lastName = lastName;
	this.pass = pass;
	this.number = number;
	this.dob = dob;
	this.gender = gender;
	this.role = role;
}
	
	
	
	
	

}
