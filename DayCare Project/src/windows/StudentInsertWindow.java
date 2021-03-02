package windows;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import edu.neu.csye6200.AppConstants;
import edu.neu.csye6200.Data.StudentDataManagement;
import edu.neu.csye6200.Factories.StudentFactory;
import edu.neu.csye6200.Objects.PersonList;
import edu.neu.csye6200.Objects.Student;

public class StudentInsertWindow extends JFrame {
    JTextField jtId;
    JTextField jtAge;
    JTextField jtName;
    JTextField jtResTime;
    JTextField jtGrade;
    JTextField jtMumName;
    JTextField jtDadName;
    JTextField jtAddress;
    JTextField jtPhone;
    JTextField jtStudentId;
    JTextField jtImmunRecord;
    Boolean isUpdate = false;

    public StudentInsertWindow(Boolean isUpdate) throws HeadlessException {
        this.isUpdate = isUpdate;
        this.init();
        this.setLocation(400, 200);
        //this.setLayout(new FlowLayout());
//        this.setSize(260, 380);
        this.setSize(280, 500);
        this.setTitle(AppConstants.INSERT_WIN_TITLE);
        this.setVisible(true);
        this.setResizable(false);
        this.validate();
    }

    private void init() {
        Container contenPane = new Container();
        contenPane.setLayout(new FlowLayout());
        JButton jbAdd;
        jbAdd = new JButton("add");


        
        JLabel lbAge = new JLabel("age");
        lbAge.setFont(new Font("Dialog", Font.PLAIN, 18));
        lbAge.setText("age：");
        lbAge.setAlignmentX(2);
        jtAge = new JTextField(15);
        

        JLabel lbName = new JLabel("name：");
        lbName.setFont(new Font("Dialog", Font.PLAIN, 18));
        lbName.setText("name：");
        lbName.setAlignmentX(2);
        jtName = new JTextField(15);
        
	      JLabel lbId = new JLabel("ID");
	      lbId.setFont(new Font("Dialog", Font.PLAIN, 18));
	      lbId.setText("ID：");
	      lbId.setAlignmentX(2);
	      jtId = new JTextField(15);
        
//        JLabel lbResTime = new JLabel("regist：");
//        lbResTime.setFont(new Font("Dialog", Font.PLAIN, 18));
//        lbResTime.setText("regist：");
//        lbResTime.setAlignmentX(2);
//        jtResTime = new JTextField(15);

        JLabel lvGrade = new JLabel("grade：");
        lvGrade.setFont(new Font("Dialog", Font.PLAIN, 18));
        lvGrade.setText("grade：");
        lvGrade.setAlignmentX(2);
        jtGrade = new JTextField(15);

        JLabel lbMumName = new JLabel("mother：");
        lbMumName.setFont(new Font("Dialog", Font.PLAIN, 18));
        lbMumName.setText("mother：");
        lbMumName.setAlignmentX(2);
        jtMumName = new JTextField(15);

        JLabel lbDadName = new JLabel("father：");
        lbDadName.setFont(new Font("Dialog", Font.PLAIN, 18));
        lbDadName.setText("father：");
        lbDadName.setAlignmentX(2);
        jtDadName = new JTextField(15);

        JLabel lbAddress = new JLabel("address：");
        lbAddress.setFont(new Font("Dialog", Font.PLAIN, 18));
        lbAddress.setText("address：");
        lbAddress.setAlignmentX(2);
        jtAddress = new JTextField(15);

        JLabel lbPhone = new JLabel("phone：");
        lbPhone.setFont(new Font("Dialog", Font.PLAIN, 18));
        lbPhone.setText("phone：");
        lbPhone.setAlignmentX(2);
        jtPhone = new JTextField(15);

//        JLabel lbImmunRecord = new JLabel("vero：");
//        lbImmunRecord.setFont(new Font("Dialog", Font.PLAIN, 18));
//        lbImmunRecord.setText("vero：");
//        lbImmunRecord.setAlignmentX(2);
//        jtImmunRecord = new JTextField(15);

        jbAdd.addActionListener(new AddActionListener(this));
        JButton jbCancel = new JButton("cancel");
        jbCancel.addActionListener((e) -> {
            this.dispose();
        });

        
        
        contenPane.add(lbId);
        contenPane.add(jtId);
        
        contenPane.add(lbName);
        contenPane.add(jtName);
        
//        contenPane.add(lbResTime);
//        contenPane.add(jtResTime);
        
        contenPane.add(lbAge);
        contenPane.add(jtAge);

        contenPane.add(lvGrade);
        contenPane.add(jtGrade);
        contenPane.add(lbMumName);
        contenPane.add(jtMumName);
        contenPane.add(lbDadName);
        contenPane.add(jtDadName);
        contenPane.add(lbAddress);
        contenPane.add(jtAddress);
        contenPane.add(lbPhone);
        contenPane.add(jtPhone);
//        contenPane.add(lbImmunRecord);
//        contenPane.add(jtImmunRecord);

        contenPane.add(jbAdd);
        contenPane.add(jbCancel);
        this.setContentPane(contenPane);
    }

    class AddActionListener implements ActionListener {
        private StudentInsertWindow ad;

        public AddActionListener(StudentInsertWindow ad) {
            this.ad = ad;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            JOptionPane.showMessageDialog(null,"add student");
            String id = jtId.getText().trim();
            String name = jtName.getText().trim();
            String age = jtAge.getText().trim();
            String grade = jtGrade.getText().trim();
            String mumName = jtMumName.getText().trim();
            String dadName = jtDadName.getText().trim();
            String address = jtAddress.getText().trim();
            String phone = jtPhone.getText().trim();
//            String immunRecord = jtImmunRecord.getText().trim();

            if (!"".equals(grade) && !"".equals(name) && !"".equals(age) && !"".equals(mumName)&& !"".equals(dadName)
                    && !"".equals(address)&& !"".equals(phone)) {
                if (!isUpdate) {
                	SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
                	Student s = (Student)StudentFactory.getStudentFactory().getObject(age+","+name+","+id+","+df.format(new Date())+","+grade+","+mumName+","+dadName+","+address+","+phone);
                	StudentDataManagement StuData=new StudentDataManagement();
                	StuData.addData(s);
                	PersonList.getInstance().addStudent(s);
                	JOptionPane.showMessageDialog(null, "Success!", "Prompt", JOptionPane.INFORMATION_MESSAGE);
                    ad.dispose();
                    MainWindow.flushTable();
                }
            } else {
                JOptionPane.showMessageDialog(null, "The information cannot be empty！", "Prompt", JOptionPane.WARNING_MESSAGE);
            }
        }
    }



    public JTextField getJtName() {
        return jtName;
    }

    public void setJtName(JTextField jtName) {
        this.jtName = jtName;
    }

    public JTextField getJtAge() {
        return jtAge;
    }

    public void setJtAge(JTextField jtAge) {
        this.jtAge = jtAge;
    }

}
