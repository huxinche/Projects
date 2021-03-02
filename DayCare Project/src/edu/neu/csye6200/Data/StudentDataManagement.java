package edu.neu.csye6200.Data;

import edu.neu.csye6200.Data.DataManagement;
import edu.neu.csye6200.Objects.Person;
import edu.neu.csye6200.Objects.PersonList;
import edu.neu.csye6200.Objects.Student;
import edu.neu.csye6200.Data.FileIO;
import edu.neu.csye6200.Factories.StudentFactory;

import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;


public class StudentDataManagement implements DataManagement<Student> {

	@Override
	public List<Student> getData() {
		return FileIO.readFileOfMap(Student.class, "student");
		
	}

	@Override
	public void addData(Student student) {
		File csv = new File("static/student.csv");
		try{
            BufferedWriter writeText = new BufferedWriter(new FileWriter(csv,true));
 
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
            writeText.write(student.getAge()+","+student.getName()+","+student.getStudentId()
            				+","+ft.format(student.getRegisterTime())+","+student.getGrade()
            				+","+student.getMumName()+","+student.getDadName()+","+student.getAddress()
            				+","+student.getPhone());
 
            writeText.flush();

            writeText.close();
        }catch (FileNotFoundException e){
            System.out.println("没有找到指定文件");
        }catch (IOException e){
            System.out.println("文件读写出错");
        }
//		List<Student> stus = new ArrayList<>();
//		int maxId = 0;
//		List<Student> allStus = getData();
//		for(Student s : allStus) {if(s.getStudentId() > maxId) maxId = s.getStudentId();}
//		student.setStudentId(maxId+1);
//		stus.add(student);
//		FileIO.writeFileAppended(stus, "student");
	}

	@Override
	public void deleteData(Student student) {
		List<Student> stus = new ArrayList<>();
		getData().forEach(s -> {if(s.getStudentId() != student.getStudentId()) stus.add(s);});
		FileIO.writeFile(stus, Student.class, "student");
	}

	@Override
	public void updateData(Student student) {
		List<Student> stus = new ArrayList<>();
		getData().forEach(s -> {
			if(s.getStudentId() != student.getStudentId()) stus.add(s);
			else stus.add(student);
			});
		FileIO.writeFile(stus, Student.class, "student");
	}
	
//	public static void main(String[] args) {
//        DataManagement rule=new StudentDataManagement();
//        rule.setData();
//    }

	@Override
	public void setData() {
		// TODO Auto-generated method stub
		try {
			BufferedReader reader = new BufferedReader(new FileReader("static/student.csv"));//换成你的文件名
			reader.readLine();
			String line = null;
			while((line=reader.readLine())!=null){
				Student student = (Student)StudentFactory.getStudentFactory().getObject(line);
				PersonList.getInstance().addStudent(student);
				System.out.println(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



