package edu.neu.csye6200.Objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends Person {
	private int studentId;	// Won't be changed once set.
	private double grade;
	private String mumName;
	private String dadName;
	private String address;
	private String phone;
	private List<Immunization> immunRecord;	
	
	public Student(int age, String name, int studentId) {
		this.age = age;
		this.name = name;
		this.studentId = studentId;
		
		immunRecord = new ArrayList<>();
	}
	
	public Student(int age, String name, Date registerTime, int studentId) {
		this.age = age;
		this.name = name;
		this.registerTime = registerTime;
		this.studentId = studentId;
		
		immunRecord = new ArrayList<>();
	} 
	
	public Student(int age, String name, Date registerTime, int studentId, double grade) {
		this.age = age;
		this.name = name;
		this.registerTime = registerTime;
		this.studentId = studentId;
		this.grade = grade;
		
		immunRecord = new ArrayList<>();
	}
	
	public Student(int age, String name, Date registerTime, int studentId, double grade, String mumName, String dadName, String address, String phone) {
		this.age = age;
		this.name = name;
		this.registerTime = registerTime;
		this.studentId = studentId;
		this.grade = grade;
		this.mumName = mumName;
		this.dadName = dadName;
		this.address = address;
		this.phone = phone;
		
		immunRecord = new ArrayList<>();
	}
	
	public Integer getStudentId() {
		return studentId;
	}
	
	public Double getGrade() {
		return grade;
	}
	
	public String getMumName() {
		return mumName;
	}
	
	public String getDadName() {
		return dadName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	public void setMumName(String mumName) {
		this.mumName = mumName;
	}
	
	public void setDadName(String dadName) {
		this.dadName = dadName;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	// In case the whole list is needed.
	public List<Immunization> getImmuRecord() {
		return immunRecord;
	}
	
	public void AddImmun(Immunization immunization) {
		immunRecord.add(immunization);
	}
	
	public Immunization getImmunization(int immuId) {
		for (Immunization immun : immunRecord) {
			if (immun.getImmuId() == immuId) {
				return immun;
			}
		}
		// Doesn't have the matched immunization.
		return null;
	}
	
	public void removeImmun(int immuId) {
		Immunization immunization = getImmunization(immuId);
		if (immunization != null) {
			immunRecord.remove(immunization);
		}
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", grade=" + grade + ", mumName=" + mumName + ", dadName=" + dadName
				+ ", address=" + address + ", phone=" + phone + ", immunRecord=" + immunRecord + "]";
	}
}
