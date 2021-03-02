package windows;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye6200.Data.ImmuDataManagement;
import edu.neu.csye6200.Objects.Immunization;
import edu.neu.csye6200.Objects.ImmunizationList;
import edu.neu.csye6200.Objects.PersonList;
import edu.neu.csye6200.Objects.Student;

public class yimiaoQueryWindow extends JFrame {

    private static JTable jTable;
    private String value;

    private Vector<Vector<Object>> vData = new Vector<>();
    private List<Immunization> list;
    public yimiaoQueryWindow(String v) throws HeadlessException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Vaccine record");
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
        
        JButton addJb=new JButton("add");
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
        	vData=null;
        	list=null;
            this.dispose();
        });
        JPanel btnPanl = new JPanel();
        btnPanl.setLayout(new FlowLayout());
        
        btnPanl.add(addJb);
        addJb.addActionListener((e)->{
        	new yimiaoInsertWindow(false);
        });
        
        btnPanl.add(exitJb);
        contentPane.add(jScrollPane);
        contentPane.add(btnPanl);
        contentPane.setLayout(new FlowLayout());
        this.setContentPane(contentPane);
    }

    public  void flushTable() {
    	
    	
    	
    	
    	ImmunizationList instance2 = ImmunizationList.getInstance();
        list = instance2.getImmunByStudentId(Integer.valueOf(value));
        
        Vector<String> vColumnName = new Vector<>();
        vColumnName.add("Id");
        vColumnName.add("StuId");
        vColumnName.add("Name");
        vColumnName.add("Date");
        if(list!=null && list.size()>0) {
            
            for (int i = 0; i < list.size(); i++) {
            	 Vector<Object> vector = new Vector<>();
            	 vector.add(list.get(i).getImmuId());
                 vector.add(list.get(i).getStudentId());
                 vector.add(list.get(i).getName());
                 vector.add(list.get(i).getImmuDate());
                 vData.add(vector);
     		}
        }
         
        DefaultTableModel tableModel1 = new DefaultTableModel();
        tableModel1.setRowCount(0);//qingchu
        tableModel1.setDataVector(vData, vColumnName);
        jTable.setRowHeight(20);
        jTable.setModel(tableModel1);
    }

}

