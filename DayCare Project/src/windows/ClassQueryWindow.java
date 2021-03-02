package windows;


import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import edu.neu.csye6200.AppConstants;
import edu.neu.csye6200.MyButtonReten;
import edu.neu.csye6200.Objects.ClassRoom;
import edu.neu.csye6200.Objects.Group;
import edu.neu.csye6200.Objects.PersonList;
import edu.neu.csye6200.Objects.Rule;

public class ClassQueryWindow extends JFrame {

    private static JTable jTable;

    public ClassQueryWindow() throws HeadlessException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle(AppConstants.UPDATE_WIN_TITLE);
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
        addJb.setForeground(Color.yellow);
        addJb.setBackground(Color.BLUE);
        exitJb.setForeground(Color.yellow);
        exitJb.setBackground(Color.BLUE);

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
                new ClassRoomInsertWindow(false);
            }
        });
        
        JPanel btnPanl = new JPanel();
        
        btnPanl.setLayout(new FlowLayout());
        btnPanl.add(exitJb);
        btnPanl.setLayout(new FlowLayout());
        btnPanl.add(addJb);
        
        contentPane.add(jScrollPane);
        contentPane.add(btnPanl);
        contentPane.setLayout(new FlowLayout());
        this.setContentPane(contentPane);
    }

    public static void flushTable() {
    	  Vector<String> vColumnName = new Vector<>();
          vColumnName.add("capacity");
//          vColumnName.add("classroomType");
          vColumnName.add("name");
          vColumnName.add("minmum age");
          vColumnName.add("maxmum age");
          vColumnName.add("Operation");
          
          
          List<ClassRoom> classRoom = PersonList.getInstance().getClassRoom();
          Vector<Vector<Object>> vData = new Vector<>();
          
          
          for (int i = 0; i < classRoom.size(); i++) {
          	 Vector<Object> vector = new Vector<>();
	          	vector.add(classRoom.get(i).getCapacity());
//	          	vector.add(classRoom.get(i).getClassroomType());
	          	vector.add(classRoom.get(i).getName());
	          	vector.add(classRoom.get(i).getClassroomType().getMinAge());
	          	vector.add(classRoom.get(i).getClassroomType().getMaxAge());
               vData.add(vector);
  			}
          DefaultTableModel tableModel1 = new DefaultTableModel();
          tableModel1.setRowCount(0);//qingchu
          tableModel1.setDataVector(vData, vColumnName);
          jTable.setRowHeight(20);
          jTable.setModel(tableModel1);
          jTable.getColumnModel().getColumn(4).setCellRenderer(new MyButtonReten("Group Info"));
          jTable.addMouseListener(new MouseListener() {
  			
  			@Override
  			public void mouseReleased(MouseEvent e) {
  				
  				// TODO Auto-generated method stub
  				
  			}
  			
  			@Override
  			public void mousePressed(MouseEvent e) {
  				int rowAtPoint = jTable.rowAtPoint(e.getPoint());
  				Object valueAt = jTable.getValueAt(rowAtPoint, 1);
  				System.out.println(valueAt);
  				
  				new GroupQueryWindow(rowAtPoint);
  				
  				
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
