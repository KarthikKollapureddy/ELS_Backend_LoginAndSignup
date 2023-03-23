package com.ELearning.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mode_info")
public class ModeBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int modeId;
	private int val;
	private int userId;
	public int getModeId() {
		return modeId;
	}
	public void setModeId(int modeId) {
		this.modeId = modeId;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public ModeBean(int modeId, int val, int userId) {
		super();
		this.modeId = modeId;
		this.val = val;
		this.userId = userId;
	}
	public ModeBean(int val, int userId) {
		super();
		this.val = val;
		this.userId = userId;
	}
	public ModeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
