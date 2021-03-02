package windows;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye6200.AppConstants;
import edu.neu.csye6200.MyButtonReten;
import edu.neu.csye6200.Objects.PersonList;
import edu.neu.csye6200.Objects.Student;

public class StudentQueryWindow extends JFrame {

    private static JTable jTable;

    public StudentQueryWindow() throws HeadlessException, ParseException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle(AppConstants.DELETE_WIN_TITLE);
        this.setLocation(200, 40);
        this.setSize(500, 520);
        this.init();
        this.setVisible(true);
        this.setResizable(false);
        this.validate();
    }

    private void init() throws ParseException {
        Container contentPane = new Container();
        JButton addJb = new JButton("add");
        JButton exitJb = new JButton("exit");
        exitJb.setForeground(Color.yellow);
        exitJb.setBackground(Color.BLUE);
        addJb.setForeground(Color.yellow);
        addJb.setBackground(Color.BLUE);

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
        addJb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentInsertWindow(false);
            }
        });
        
        JPanel btnPanl = new JPanel();
        btnPanl.setLayout(new FlowLayout());
        btnPanl.add(exitJb);
        btnPanl.add(addJb);
        
        contentPane.add(jScrollPane);
        contentPane.add(btnPanl);
        contentPane.setLayout(new FlowLayout());
        this.setContentPane(contentPane);
    }

    public  void flushTable() throws ParseException {
        Vector<String> vColumnName = new Vector<>();
        vColumnName.add("StuId");
        vColumnName.add("Name");
        vColumnName.add("Registration Date");
        vColumnName.add(">1 year?");
        vColumnName.add("Age");
        vColumnName.add("Grade");
        vColumnName.add("Mother");
        vColumnName.add("Father");
        vColumnName.add("Address");
        vColumnName.add("Phone");
        vColumnName.add("Opeation");
        
        
        
        PersonList instance = PersonList.getInstance();
        List<Student> student = instance.getStudent();
        
        Vector<Vector<Object>> vData = new Vector<>();
        
        for (int i = 0; i < student.size(); i++) {
        	 Vector<Object> vector = new Vector<>();
             vector.add(student.get(i).getStudentId());
             vector.add(student.get(i).getName());
             vector.add(student.get(i).getRegisterTime());
             
             Date time =new Date(student.get(i).getRegisterTime().toString());
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String timeFormat = sdf.format(time);
             long a = new Date().getTime()-time.getTime();
             
             if((a/(1000*3600*24))/365 >=1){
            	 
            	 vector.add("yes");
             }else {
            	 vector.add("no");
             }
             
             
             
             vector.add(student.get(i).getAge());
             vector.add(student.get(i).getGrade());
             vector.add(student.get(i).getMumName());
             vector.add(student.get(i).getDadName());
             vector.add(student.get(i).getAddress());	
             vector.add(student.get(i).getPhone());
             vData.add(vector);
		}
        DefaultTableModel tableModel1 = new DefaultTableModel();
        tableModel1.setRowCount(0);//qingchu
        tableModel1.setDataVector(vData, vColumnName);
        jTable.setRowHeight(20);
        jTable.setModel(tableModel1);
        jTable.getColumnModel().getColumn(10).setCellRenderer(new MyButtonReten("Vaccine Record"));
        jTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				int rowAtPoint = jTable.rowAtPoint(e.getPoint());
				Object valueAt = jTable.getValueAt(rowAtPoint, 0);
				System.out.println(valueAt);
				
				
//				JOptionPane.showMessageDialog(null, "根据"+valueAt+"去查询");
				new yimiaoQueryWindow(valueAt.toString());
				
				
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
    }

}
