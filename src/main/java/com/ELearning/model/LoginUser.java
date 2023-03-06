package com.ELearning.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Builder
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

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
//	public LoginUser(int loginId, String userName, String pass) {
//		super();
//		this.loginId = loginId;
//		this.userName = userName;
//		this.pass = pass;
//	}
	public LoginUser() {
		
	}
	

	@Override
	public String toString() {
		return "LoginBean [loginId=" + loginId + ", userName=" + userName + ", pass=" + pass + "]";
	}

	
	

}
