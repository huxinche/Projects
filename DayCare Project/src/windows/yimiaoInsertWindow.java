package windows;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.neu.csye6200.AppConstants;
import windows.StudentInsertWindow.AddActionListener;

public class yimiaoInsertWindow extends JFrame {

	JTextField jtId;
    JTextField jtStudentId;
    JTextField jtName;
    JTextField jtTime;
    Boolean isUpdate = false;

    public yimiaoInsertWindow(Boolean isUpdate) throws HeadlessException {
        this.isUpdate = isUpdate;
        this.init();
        this.setLocation(400, 200);
        //this.setLayout(new FlowLayout());
        this.setSize(260, 380);
//        this.setTitle(AppConstants.INSERT_WIN_TITLE);
        this.setTitle("add");
        this.setVisible(true);
        this.setResizable(false);
        this.validate();
    }
    
    private void init() {
    	 Container contenPane = new Container();
         contenPane.setLayout(new FlowLayout());
         JButton jbAdd;
         JButton jbCancel;
         jbAdd = new JButton("submit");
         jbCancel = new JButton("cancel");

         
         JLabel lbId = new JLabel("ID：");
         lbId.setFont(new Font("Dialog", Font.PLAIN, 18));
         lbId.setText("ID：");
         lbId.setAlignmentX(2);
         jtId = new JTextField(15);
         
         JLabel lbStuId = new JLabel("StuId：");
         lbStuId.setFont(new Font("Dialog", Font.PLAIN, 18));
         lbStuId.setText("StuId：");
         lbStuId.setAlignmentX(2);
         jtStudentId = new JTextField(15);
         
         JLabel lbName = new JLabel("Name：");
         lbName.setFont(new Font("Dialog", Font.PLAIN, 18));
         lbName.setText("Name：");
         lbName.setAlignmentX(2);
         jtName = new JTextField(15);
         
         
         JLabel lbTime = new JLabel("Date：");
         lbTime.setFont(new Font("Dialog", Font.PLAIN, 18));
         lbTime.setText("Date：");
         lbTime.setAlignmentX(2);
         jtTime = new JTextField(15);

         jbCancel.addActionListener((e) -> {
             this.dispose();
         });

         
         
         contenPane.add(lbId);
         contenPane.add(jtId);
         
         contenPane.add(lbStuId);
         contenPane.add(jtStudentId);
         
         contenPane.add(lbName);
         contenPane.add(jtName);
         
         contenPane.add(lbTime);
         contenPane.add(jtTime);
         
         contenPane.add(jbAdd);
         contenPane.add(jbCancel);
         this.setContentPane(contenPane);
    }
}
