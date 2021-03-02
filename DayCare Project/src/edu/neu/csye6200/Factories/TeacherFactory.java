package edu.neu.csye6200.Factories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.neu.csye6200.Objects.*;

/*
 * The format of csv should be one of the below formats: 
 * 1. "age, name, teacherId, registerTime(milliseconds in long format), credit, creditDate(milliseconds in long format)".
 * 2. "age, name, teacherId, registerTime".
 * 3. "age, name, teacherId".
 */

public class TeacherFactory extends PersonFactory {
	private static PersonFactory personFactory = null;
	
	// Singleton.
	public static PersonFactory getTeacherFactory() {
		if (personFactory == null) {
			personFactory = new TeacherFactory();
		}
		return personFactory;
	}
	
	@Override
	public Person getObject(String csvData) {
		String[] datas = csvData.split(",");
		int age = Integer.parseInt(datas[0]);
		String name = datas[1];
		int teacherId = Integer.parseInt(datas[2]);
		
		
		if (datas.length > 3) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
			Date registerTime=new Date();
			try {
				registerTime = df.parse(datas[3]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (datas.length == 6) {
				int credit = Integer.parseInt(datas[4]);
				Date creditDate=new Date();
				try {
					creditDate = df.parse(datas[5]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return new Teacher(age, name, registerTime, teacherId, credit, creditDate);
			}
			
			return new Teacher(age, name, registerTime, teacherId);
		}
		
		return new Teacher(age, name, teacherId);
	}
}
