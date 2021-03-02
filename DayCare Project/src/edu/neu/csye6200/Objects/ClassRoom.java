package edu.neu.csye6200.Objects;

import java.util.Vector;

public class ClassRoom {
    private int capacity;
    private Vector<Group> groupList;
    private Rule classroomType;
    private String name;

    public ClassRoom(Rule classroomType, String name) {
        capacity = classroomType.getGroupSize();
        this.groupList = new Vector<>();
        this.classroomType = classroomType;
        this.name = name;
    }

    public void add(Group group){
        if(groupList.size()<capacity)
            groupList.add(group);
        else throw new RuntimeException("group size over the capacity");
    }

	public Vector<Group> getGroupList() {
		return groupList;
	}

	public void setGroupList(Vector<Group> groupList) {
		this.groupList = groupList;
	}

	public Rule getClassroomType() {
		return classroomType;
	}

	public void setClassroomType(Rule classroomType) {
		this.classroomType = classroomType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "ClassRoom [capacity=" + capacity + ", groupList=" + groupList + ", classroomType=" + classroomType
				+ ", name=" + name + "]";
	}
	
	
	
	
}
