package edu.neu.csye6200.Objects;

import java.util.Date;

public class Teacher extends Person {
	private int teacherId;	//Won't be changed once set.
	private int credit;
	private Date creditDate;
	
	public Teacher(int age, String name, int teacherId) {
		this.age = age;
		this.name = name;
		this.teacherId = teacherId;
	}
	
	public Teacher(int age, String name, Date registerTime, int teacherId) {
		this.age = age;
		this.name = name;
		this.registerTime = registerTime;
		this.teacherId = teacherId;
	}
	
	public Teacher(int age, String name, Date registerTime, int teacherId, int credit, Date creditDate) {
		this.age = age;
		this.name = name;
		this.registerTime = registerTime;
		this.teacherId = teacherId;
		this.credit = credit;
		this.creditDate = creditDate;
	}
	
	public Integer getTeacherId() {
		return teacherId;
	}
	
	public Integer getCredit() {
		return credit;
	}
	
	public Date getCreditDate() {
		return creditDate;
	}
	
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public void setCreditDate(Date creditDate) {
		this.creditDate = creditDate;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", credit=" + credit + ", creditDate=" + creditDate + "]";
	}
}
