package edu.neu.csye6200.Objects;

import java.util.Vector;

public class Group {
    private int capacity;
    private Vector<Student> studentList;
    private Vector<Teacher> teacherList;
    private Rule groupType;

    public Group(Rule groupType) {
        capacity = groupType.getGroupSize();
        this.groupType = groupType;
        studentList = new Vector<>();
        teacherList = new Vector<>();
    }

    public void add(Student student){
        if(capacity>studentList.size())
            studentList.add(student);
        else throw new RuntimeException("student size over the capacity");
    }
    public void add(Teacher teacher){
        teacherList.add(teacher);
    }

	public Vector<Student> getStudentList() {
		return studentList;
	}

	public Vector<Teacher> getTeacherList() {
		return teacherList;
	}

	public Rule getGroupType() {
		return groupType;
	}

	/**
	 * capacity.
	 *
	 * @return  the capacity
	 * @since   JDK 1.8
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * capacity.
	 *
	 * @param   capacity    the capacity to set
	 * @since   JDK 1.8
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Group [capacity=" + capacity + ", studentList=" + studentList + ", teacherList=" + teacherList
				+ ", groupType=" + groupType + "]";
	}
	
	
	
	

}
