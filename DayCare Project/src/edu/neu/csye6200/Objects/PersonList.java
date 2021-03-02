package edu.neu.csye6200.Objects;

import java.util.List;
import java.util.Vector;

public class PersonList {
	
	private List<Student> studentList;
	private List<Teacher> teacherList;
	private List<ClassRoom> classroomList;
	
	private static final PersonList instance = new PersonList();
	
	private PersonList() {
		studentList = new Vector<>();
		teacherList = new Vector<>();
		classroomList = new Vector<>();
	}
	
	public static PersonList getInstance() {
		return instance;
	}
	
	public void addStudent(Student student) {
		studentList.add(student);
	}
	
	public void addTeacher(Teacher tea) {
		teacherList.add(tea);
	}
	
	public void addClassRoom(ClassRoom classRoom) {
		classroomList.add(classRoom);
	}
	
	public List<Student> getStudent() {
		return studentList;
	}
	
	public List<Teacher> getTeacher() {
		return teacherList;
	}
	
	public List<ClassRoom> getClassRoom() {
		return classroomList;
	}

}
