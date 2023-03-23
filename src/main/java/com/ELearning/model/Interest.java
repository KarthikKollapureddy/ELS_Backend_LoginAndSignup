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
	public void setIntrstId(int intrstId) {
		this.intrstId = intrstId;
	}
	public int getIntrst1() {
		return intrst1;
	}
	public void setIntrst1(int intrst1) {
		this.intrst1 = intrst1;
	}
	public int getIntrst2() {
		return intrst2;
	}
	public void setIntrst2(int intrst2) {
		this.intrst2 = intrst2;
	}
	public int getIntrst3() {
		return intrst3;
	}
	public void setIntrst3(int intrst3) {
		this.intrst3 = intrst3;
	}
	public Interest(int intrst1, int intrst2, int intrst3,int userId) {
		super();
		this.intrst1 = intrst1;
		this.intrst2 = intrst2;
		this.intrst3 = intrst3;
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
