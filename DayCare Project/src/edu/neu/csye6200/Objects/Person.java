package edu.neu.csye6200.Objects;

import java.util.Date;

public abstract class Person {
	protected int age;
	protected String name;
	protected Date registerTime;
	
	public Integer getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	public Date getRegisterTime() {
		return registerTime;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
}
