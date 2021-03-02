package windows;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye6200.MyButtonReten;
import edu.neu.csye6200.Objects.ClassRoom;
import edu.neu.csye6200.Objects.Group;
import edu.neu.csye6200.Objects.Person;
import edu.neu.csye6200.Objects.PersonList;
import edu.neu.csye6200.Objects.Rule;
import edu.neu.csye6200.Objects.Student;
import edu.neu.csye6200.Objects.Teacher;

public class GroupQueryWindow extends JFrame {

    private static JTable jTable;
    private int value;

    public GroupQueryWindow(int v) throws HeadlessException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Group Query");
        this.setLocation(400, 40);
        this.value=v;
        this.setSize(500, 520);
        this.init();
        this.setVisible(true);
        this.setResizable(false);
        this.validate();
    }

    private void init() {
    	Container contentPane = new Container();
        JButton exitJb = new JButton("exit");
        exitJb.setForeground(Color.yellow);
        exitJb.setBackground(Color.BLUE); 
//        JButton addTeaJb=new JButton("addTeacher");
//        addTeaJb.setForeground(Color.yellow);
//        addTeaJb.setBackground(Color.BLUE);
//        JButton addStuJb=new JButton("addStudent");
//        addStuJb.setForeground(Color.yellow);
//        addStuJb.setBackground(Color.BLUE);
        
//        addTeaJb.addActionListener((e)->{
//        	new GroupQueryWindow_AddTeacher(false);
//        });
//        
//        addStuJb.addActionListener((e)->{
//        	new GroupQueryWindow_AddStudent(false);
//        });
//        

        jTable = new JTable();
        flushTable();
        //滚动条设置面板
        JScrollPane jScrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setViewportView(jTable);

        jTable.setBackground(Color.PINK);
        //jScrollPane.setBounds(new Rectangle(1, 1, 580, 470));
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        //监听器
        exitJb.addActionListener(e -> {
            this.dispose();
        });
        JPanel btnPanl = new JPanel();
        btnPanl.setLayout(new FlowLayout());
        btnPanl.add(exitJb);
        
//        btnPanl.add(addTeaJb);
//        btnPanl.add(addStuJb);
        
        contentPane.add(jScrollPane);
        contentPane.add(btnPanl);
        contentPane.setLayout(new FlowLayout());
        this.setContentPane(contentPane);
    }

    public  void flushTable() {
    	
        Vector<String> vColumnName = new Vector<>();
        vColumnName.add("capacity");
        vColumnName.add("Student");
        vColumnName.add("Teacher");
        vColumnName.add("Operation");
        
        Vector<Vector<Object>> vData = new Vector<>();
        
        
        List<ClassRoom> classRoomList = PersonList.getInstance().getClassRoom();
        
        ClassRoom classRoom = classRoomList.get(value);
        List<Group> groupList=classRoom.getGroupList();
        for (int j = 0; j < groupList.size(); j++) {
        	Vector<Student> studentList = groupList.get(j).getStudentList();
        	Vector<Teacher> teachers = groupList.get(j).getTeacherList();
        	String stu="";
        	for (int k = 0; k < studentList.size(); k++) {
        		stu= stu+studentList.get(k).getName()+",";
        	}
			String tea="";
			
			for (int k = 0; k < teachers.size(); k++) {
				tea= tea + teachers.get(k).getName()+",";
			}
			Vector<Object> vector = new Vector<>();
			vector.add(groupList.get(j).getCapacity());
			vector.add(stu);
			vector.add(tea);
			
			vData.add(vector);
        }
        DefaultTableModel tableModel1 = new DefaultTableModel();
        tableModel1.setRowCount(0);//qingchu
        tableModel1.setDataVector(vData, vColumnName);
        jTable.setRowHeight(20);
        jTable.setModel(tableModel1);
        jTable.getColumnModel().getColumn(3).setCellRenderer(new MyButtonReten("add"));
        jTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				int rowAtPoint = jTable.rowAtPoint(e.getPoint());
				Object valueAt = jTable.getValueAt(rowAtPoint, 0);
				ClassRoom classRoom = classRoomList.get(value);
		        List<Group> groupList=classRoom.getGroupList();
		        Group g = groupList.get(rowAtPoint);
				System.out.println(valueAt);
				
				
				new GroupQueryWindow_AddStudent(g);
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// TODO Auto-generated method stub
				
			}
		});
//        for (int i = 0; i < classRoom.size(); i++) {
//
//        	Vector<Group> groupList = classRoom.get(i).getGroupList();
//    		for (int j = 0; j < groupList.size(); j++) {
//    			Vector<Object> vector = new Vector<>();
//    			Vector<Student> studentList = groupList.get(j).getStudentList();
//    			Vector<Teacher> teachers = groupList.get(j).getTeacherList();
//    			
//    			String stu="";
//    			
//    			for (int k = 0; k < studentList.size(); k++) {
//    				stu= stu+studentList.get(k).getName()+",";
//				}
//    			
//    			String tea="";
//    			
//    			for (int k = 0; k < teachers.size(); k++) {
//    				tea= stu+teachers.get(k).getName()+",";
//				}
//    			
//    			System.out.println(stu);
//    			System.out.println(tea);
//    			
//    			
//                vector.add(groupList.get(j).getCapacity());
//                vector.add(stu);
//                vector.add(tea);
//                
//                vData.add(vector);
//    			
//    		
//    		}
//        
//        }
//      	
//        DefaultTableModel tableModel1 = new DefaultTableModel();
//        tableModel1.setRowCount(0);//qingchu
//        tableModel1.setDataVector(vData, vColumnName);
//        jTable.setRowHeight(20);
//        jTable.setModel(tableModel1);
    }

}
