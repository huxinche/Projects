package windows;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye6200.AppConstants;
import edu.neu.csye6200.Data.TeacherDataManagement;
import edu.neu.csye6200.Objects.Person;
import edu.neu.csye6200.Objects.PersonList;
import edu.neu.csye6200.Objects.Teacher;

public class TeacherQueryWindow extends JFrame {

    private static JTable jTable;

    public TeacherQueryWindow() throws HeadlessException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle(AppConstants.INSERT_WIN_TITLE);
        this.setLocation(200, 40);
        this.setSize(500, 520);
        this.init();
        this.setVisible(true);
        this.setResizable(false);
        this.validate();
    }

    private void init() {
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
        addJb.addActionListener(
        		new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new TeacherInsertWindow(false);
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

    public static void flushTable() {
        Vector<String> vColumnName = new Vector<>();
        vColumnName.add("ID");
        vColumnName.add("Name");
        vColumnName.add("Registration Date");
        vColumnName.add("Age");
        vColumnName.add("Credit");
        vColumnName.add("Year");
        Vector<Vector<Object>> vData = new Vector<>();

     
        
        
        PersonList personList= PersonList.getInstance();
        List<Teacher> data = personList.getTeacher();
//        List<Teacher> data = teacherDataManagement.getData();
        for(int i=0;i<data.size();i++) {
        	 Vector<Object> vector = new Vector<>();
   	      vector.add(data.get(i).getTeacherId());
   	      vector.add(data.get(i).getName());
   	      vector.add(data.get(i).getRegisterTime());
   	      vector.add(data.get(i).getAge());
   	      vector.add(data.get(i).getCredit());
   	      vector.add(data.get(i).getCreditDate());
   	      vData.add(vector);
        }
       
        
        DefaultTableModel tableModel1 = new DefaultTableModel();
        tableModel1.setRowCount(0);//qingchu
        tableModel1.setDataVector(vData, vColumnName);
        jTable.setModel(tableModel1);
    }

}
