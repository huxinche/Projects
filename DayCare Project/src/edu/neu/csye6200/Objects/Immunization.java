package edu.neu.csye6200.Objects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Immunization {
	private int immuId;	// Won't be changed once set.
	private int studentId;
	private String name; 
	private Date immuDate;
	
	public Immunization(String csvData) {
		Scanner in = new Scanner(csvData);
		in.useDelimiter(",");
		this.immuId=in.nextInt();
		setStudentId(in.nextInt());
		setName(in.next());
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
		
		Date registerTime=new Date();
		try {
			registerTime = df.parse(in.next());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setImmuDate(registerTime);
		in.close();
	}
	
	public Immunization(int immuId, String name) {
		this.immuId = immuId;
		this.name = name;
	}
	
	public Immunization(int immuId, String name, Date immuDate) {
		this.immuId = immuId;
		this.name = name;
		this.immuDate = immuDate;
	}
	
	public Immunization(int immuId, String name, Date immuDate, int studentId) {
		this.immuId = immuId;
		this.name = name;
		this.immuDate = immuDate;
		this.studentId = studentId;
	}
	
	public int getImmuId() {
		return immuId;
	}
	
	public String getName() {
		return name;
	}
	
	public Date getImmuDate() {
		return immuDate;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setImmuDate(Date immuDate) {
		this.immuDate = immuDate;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
}
