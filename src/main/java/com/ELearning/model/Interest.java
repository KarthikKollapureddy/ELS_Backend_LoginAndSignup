package com.ELearning.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="interest_info")
public class Interest {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int intrstId;
	private int intrst1;
	private int intrst2;
	private int intrst3;
	private int userId;
	
	public int getIntId() {
		return intrstId;
	}
	public void setIntId(int intId) {
		this.intrstId = intId;
	}
	public int getInt1() {
		return intrst1;
	}
	public void setInt1(int int1) {
		this.intrst1 = int1;
	}
	public int getInt2() {
		return intrst2;
	}
	public void setInt2(int int2) {
		this.intrst2 = int2;
	}
	public int getInt3() {
		return intrst3;
	}
	public void setInt3(int int3) {
		this.intrst3 = int3;
	}
	public Interest(int int1, int int2, int int3,int userId) {
		super();
		this.intrst1 = int1;
		this.intrst2 = int2;
		this.intrst3 = int3;
		this.userId = userId;
	}
	public Interest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
	

}
