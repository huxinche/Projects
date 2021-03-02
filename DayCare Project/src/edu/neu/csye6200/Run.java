package edu.neu.csye6200;

import java.text.ParseException;

import edu.neu.csye6200.Data.ImmuDataManagement;
import edu.neu.csye6200.Data.RuleManagement;
import edu.neu.csye6200.Data.StudentDataManagement;
import edu.neu.csye6200.Data.TeacherDataManagement;
import edu.neu.csye6200.Objects.ClassRoom;
import edu.neu.csye6200.Objects.Group;
import edu.neu.csye6200.Objects.PersonList;
import edu.neu.csye6200.Objects.Rules;
import windows.LoginWindow;

public class Run {
    public static void main(String[] args) throws ParseException {
    	StudentDataManagement studentDataManagement = new StudentDataManagement();
        studentDataManagement.setData();
        TeacherDataManagement teacherDataManagement = new TeacherDataManagement();
        teacherDataManagement.setData();
        ImmuDataManagement immuDataManagement = new ImmuDataManagement();
    	immuDataManagement.setData();
    	RuleManagement ruleManagement = new RuleManagement();
    	ruleManagement.setData();
    	ClassRoom c1 = new ClassRoom(Rules.getInstance().getClassroomSize(10),"small");
    	Group g1 = new Group(Rules.getInstance().getClassroomSize(10));
    	System.out.println(g1);
    	g1.add(PersonList.getInstance().getStudent().get(0));
    	g1.add(PersonList.getInstance().getTeacher().get(0));
    	c1.add(g1);
    	
    	PersonList.getInstance().addClassRoom(c1);
    	PersonList.getInstance().addClassRoom(new ClassRoom(Rules.getInstance().getClassroomSize(13),"middle"));
    	
        new LoginWindow();
    	
         
         
    }

}
