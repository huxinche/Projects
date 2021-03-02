package windows;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.neu.csye6200.Objects.Group;
import edu.neu.csye6200.Objects.PersonList;
import edu.neu.csye6200.Objects.Student;
import edu.neu.csye6200.Objects.Teacher;

public class GroupQueryWindow_AddStudent extends JFrame {

	JTextField jtId;
	JTextField jtId1;
	Boolean isUpdate = false;
   JButton jbAdd;
   JButton jbAdd1;
   JButton jbCancel;
   JButton jbCancel1;
	
	String value;
	Group group;

	public GroupQueryWindow_AddStudent(Group g) throws HeadlessException {
		this.isUpdate = isUpdate;
		this.group=g;
		this.init();
		this.setLocation(400, 200);
		this.setSize(230, 380);
		this.setTitle("add");
		this.setVisible(true);
		this.setResizable(false);
		this.validate();
	}
	
	private void init() {
		Container contenPane = new Container();
        contenPane.setLayout(new FlowLayout());
        
     
        jbAdd = new JButton("submit");
        
        jbAdd1 = new JButton("submit");
        
        jbCancel = new JButton("cancel");
        
        jbCancel1 = new JButton("cancel");
        
        
        JLabel lbId = new JLabel("StuId：");
        lbId.setFont(new Font("Dialog", Font.PLAIN, 18));
        lbId.setText("StuId：");
        lbId.setAlignmentX(2);
        jtId = new JTextField(15);
        
        JLabel lbId1 = new JLabel("TeaId：");
        lbId1.setFont(new Font("Dialog", Font.PLAIN, 18));
        lbId1.setText("TeaId：");
        lbId1.setAlignmentX(2);
        jtId1 = new JTextField(15);
        
        

        jbCancel.addActionListener((e) -> {
            this.dispose();
        });
        

        jbCancel1.addActionListener((e) -> {
            this.dispose();
        });

        jbAdd.addActionListener((e) -> {
        	System.out.println(this.value);
            Integer studentId = Integer.parseInt(jtId.getText().trim());
            for(Student stu:PersonList.getInstance().getStudent()) {
            	if(stu.getStudentId().equals(studentId)) {
            		this.group.add(stu);
            	}
            }
            System.out.println(studentId);
            
        });
        
        jbAdd1.addActionListener((e) -> {
        	System.out.println(this.value);
            Integer teacherId = Integer.parseInt(jtId1.getText().trim());
            for(Teacher tea:PersonList.getInstance().getTeacher()) {
            	if(tea.getTeacherId().equals(teacherId)) {
            		this.group.add(tea);
            	}
            }
            System.out.println(teacherId);
            
        });
           
        contenPane.add(lbId);
        contenPane.add(jtId);
        contenPane.add(jbAdd);
        contenPane.add(jbCancel1);
        
        contenPane.add(lbId1);
        contenPane.add(jtId1);
        
        contenPane.add(jbAdd1);
        contenPane.add(jbCancel);
        this.setContentPane(contenPane);
	}
}
