package edu.neu.csye6200.Data;

import edu.neu.csye6200.Data.DataManagement;
import edu.neu.csye6200.Objects.Person;
import edu.neu.csye6200.Objects.PersonList;
import edu.neu.csye6200.Objects.Student;
import edu.neu.csye6200.Objects.Teacher;
import edu.neu.csye6200.Data.FileIO;
import edu.neu.csye6200.Factories.StudentFactory;
import edu.neu.csye6200.Factories.TeacherFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class TeacherDataManagement implements DataManagement<Teacher> {

	@Override
	public List<Teacher> getData() {
		return FileIO.readFileOfMap(Teacher.class, "teacher");
	}

	@Override
	public void addData(Teacher teacher) {
		File csv = new File("static/teacher.csv");
		try{
            BufferedWriter writeText = new BufferedWriter(new FileWriter(csv,true));
 
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
            writeText.write(teacher.getAge()+","+teacher.getName()+","+teacher.getTeacherId()
            				+","+ft.format(teacher.getRegisterTime())+","+teacher.getCredit()
            				+","+ft.format(teacher.getCreditDate()));
 
            writeText.flush();

            writeText.close();
        }catch (FileNotFoundException e){
            System.out.println("没有找到指定文件");
        }catch (IOException e){
            System.out.println("文件读写出错");
        }
		
//		List<Teacher> ts = new ArrayList<>();
//		int maxId = 0;
//		List<Teacher> allts = getData();
//		for(Teacher tch : allts) {if(tch.getTeacherId() > maxId) maxId = tch.getTchId();}
//		teacher.setTchId(maxId+1);
//		ts.add(teacher);
//		FileIO.writeFileAppended(ts, "teacher");
	}

	@Override
	public void deleteData(Teacher teacher) {
		List<Teacher> ts = new ArrayList<>();
		getData().forEach(tch -> {if(tch.getTeacherId() != teacher.getTeacherId()) ts.add(tch);});
		FileIO.writeFile(ts, Teacher.class, "teacher");
	}

	@Override
	public void updateData(Teacher teacher) {
		List<Teacher> ts = new ArrayList<>();
		getData().forEach(tch -> {
			if(tch.getTeacherId() != teacher.getTeacherId()) ts.add(tch);
			else ts.add(teacher);
		});
		FileIO.writeFile(ts, Teacher.class, "teacher");
	}

	@Override
	public void setData() {
		// TODO Auto-generated method stub
		try {
			BufferedReader reader = new BufferedReader(new FileReader("static/teacher.csv"));//换成你的文件名
			reader.readLine();
			String line = null;
			while((line=reader.readLine())!=null){
				Teacher teacher = (Teacher)TeacherFactory.getTeacherFactory().getObject(line);
				PersonList.getInstance().addTeacher(teacher);
				System.out.print(teacher);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		TeacherDataManagement tea=new TeacherDataManagement();
//		StudentDataManagement stu=new StudentDataManagement();
////		RuleManagement rul=new RuleManagement();
////		ImmuDataManagement imm=new ImmuDataManagement();
//		tea.setData();
////		stu.setData();
////		rul.setData();
////		imm.setData();
//	}
}
