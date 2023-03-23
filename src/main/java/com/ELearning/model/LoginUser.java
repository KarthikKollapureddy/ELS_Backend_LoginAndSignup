package com.ELearning.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="login_info")
public class LoginUser {
	@Column(name="login_id")
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int loginId;
	
	private String userName;
	private String pass;

	

	public LoginUser(String userName, String pass) {
		super();
		this.userName = userName;
		this.pass = pass;
	}

	

}
