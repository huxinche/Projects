package edu.neu.csye6200.Factories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.neu.csye6200.Objects.*;

/*
 * The format of csv should be one of the below formats: 
 * 1. "age, name, studentId, registerTime(milliseconds in long format), grade, mumName, dadName, address, phone".
 * 2. "age, name, studentId, registerTime, grade".
 * 3. "age, name, studentId, registerTime".
 * 4. "age, name, studentId".
 */

public class StudentFactory extends PersonFactory {
	private static PersonFactory personFactory = null;
	
	// Singleton.
	public static PersonFactory getStudentFactory() {
		if (personFactory == null) {
			personFactory = new StudentFactory();
		}
		return personFactory;
	}
	
	@Override
	public Person getObject(String csvData) {
		String[] datas = csvData.split(",");
		int age = Integer.parseInt(datas[0]);
		String name = datas[1];
		int studentId = Integer.parseInt(datas[2]);
		if (datas.length > 3) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
			
			Date registerTime=new Date();
			try {
				registerTime = df.parse(datas[3]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (datas.length > 4) {
				double grade = Double.parseDouble(datas[4]);
				
				if (datas.length == 9) {
					String mumName = datas[5];
					String dadName = datas[6];
					String address = datas[7];
					String phone = datas[8];
					return new Student(age, name, registerTime,studentId, grade, mumName, dadName, address, phone);
				}
				
				return new Student(age, name, registerTime, studentId, grade);
			}
			
			return new Student(age, name, registerTime, studentId);
		}
		
		return new Student(age, name, studentId);
	}
}
