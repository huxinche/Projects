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
import edu.neu.csye6200.Data.TeacherDataManagement;
import edu.neu.csye6200.Factories.TeacherFactory;
import edu.neu.csye6200.Objects.PersonList;
import edu.neu.csye6200.Objects.Student;
import edu.neu.csye6200.Objects.Teacher;

public class TeacherInsertWindow extends JFrame {
	
	JTextField jtxuefen;//学分
    JTextField jtSno;//注册时间
    JTextField jtName;
    JTextField jtAge;
    JTextField jtMajor;//学年
    JTextField jtId;
    Boolean isUpdate = false;

    public TeacherInsertWindow(Boolean isUpdate) throws HeadlessException {
        this.isUpdate = isUpdate;
        this.init();
        this.setLocation(400, 200);
        //this.setLayout(new FlowLayout());
//        this.setSize(250, 250);
        this.setSize(250, 500);
        this.setTitle(AppConstants.INSERT_WIN_TITLE);
        this.setVisible(true);
        this.setResizable(false);
        this.validate();
    }

    private void init() {
        Container contenPane = new Container();
        contenPane.setLayout(new FlowLayout());
        JButton jbAdd;
//        if (isUpdate) {
//            JLabel lbId = new JLabel();
//            lbId.setFont(new Font("Dialog", Font.PLAIN, 18));
//            lbId.setText("序号Id：");
//            lbId.setAlignmentX(2);
//            jtId = new JTextField(15);
//            jbAdd = new JButton("修 改");
//            contenPane.add(lbId);
//            contenPane.add(jtId);
//        } else {
            jbAdd = new JButton("add");
//        }
//        JLabel lbSno = new JLabel();
//        lbSno.setFont(new Font("Dialog", Font.PLAIN, 18));
//        lbSno.setText("regist：");
//        lbSno.setAlignmentX(2);
//        jtSno = new JTextField(15);
        
        JLabel lbName = new JLabel("name：");
        lbName.setFont(new Font("Dialog", Font.PLAIN, 18));
        lbName.setText("name：");
        lbName.setAlignmentX(2);
        jtName = new JTextField(15);
        
        JLabel lbId = new JLabel("ID：");
        lbId.setFont(new Font("Dialog", Font.PLAIN, 18));
        lbId.setText("ID：");
        lbId.setAlignmentX(2);
        jtId= new JTextField(15);
        
        JLabel lbAge = new JLabel("age：");
        lbAge.setFont(new Font("Dialog", Font.PLAIN, 18));
        lbAge.setText("age：");
        lbAge.setAlignmentX(2);
        jtAge = new JTextField(15);
        
        
        JLabel lbMajor = new JLabel("credit：");
        lbMajor.setFont(new Font("Dialog", Font.PLAIN, 18));
        lbMajor.setText("crdeit：");
        lbMajor.setAlignmentX(2);
        jtMajor = new JTextField(15);
        
//        JLabel lbxuefen = new JLabel("year：");
//        lbxuefen.setFont(new Font("Dialog", Font.PLAIN, 18));
//        lbxuefen.setText("year：");
//        lbxuefen.setAlignmentX(2);
//        jtxuefen = new JTextField(15);


        jbAdd.addActionListener(new AddActionListener(this));
        JButton jbCancel = new JButton("cancel");
        jbCancel.addActionListener((e) -> {
            this.dispose();
        });
        
        contenPane.add(lbId);
        contenPane.add(jtId);
        
        contenPane.add(lbName);
        contenPane.add(jtName);
        
//        contenPane.add(lbSno);
//        contenPane.add(jtSno);
        
        contenPane.add(lbAge);
        contenPane.add(jtAge);
        
//        contenPane.add(lbxuefen);
//        contenPane.add(jtxuefen);
        
        contenPane.add(lbMajor);
        contenPane.add(jtMajor);
        
        contenPane.add(jbAdd);
        contenPane.add(jbCancel);
        this.setContentPane(contenPane);
    }

    class AddActionListener implements ActionListener {
        private TeacherInsertWindow ad;

        public AddActionListener(TeacherInsertWindow ad) {
            this.ad = ad;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,"add teacher");
//            String sno = jtSno.getText().trim();
            String id = jtId.getText().trim();
            String name = jtName.getText().trim();
            String age = jtAge.getText().trim();
            String major = jtMajor.getText().trim();
            if (!"".equals(name) && !"".equals(age) && !"".equals(major)) {
                if (!isUpdate) {
//                    Student student = new Student(0, sno, name, Integer.parseInt(age), major);
                	SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
                	Teacher tea = (Teacher) TeacherFactory.getTeacherFactory().getObject(age+","+name+","+id+","+df.format(new Date())+","+major+","+df.format(new Date()));
                    TeacherDataManagement teaData = new TeacherDataManagement();
                    teaData.addData(tea);
                    PersonList.getInstance().addTeacher(tea);
                	JOptionPane.showMessageDialog(null, "Success!", "Prompt", JOptionPane.INFORMATION_MESSAGE);
                    ad.dispose();
                    MainWindow.flushTable();
                }
            } else {
                JOptionPane.showMessageDialog(null, "The information cannot be empty！", "Prompt", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public JTextField getJtSno() {
        return jtSno;
    }

    public void setJtSno(JTextField jtSno) {
        this.jtSno = jtSno;
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

    public JTextField getJtMajor() {
        return jtMajor;
    }

    public void setJtMajor(JTextField jtMajor) {
        this.jtMajor = jtMajor;
    }

    public JTextField getJtId() {
        return jtId;
    }

    public void setJtId(JTextField jtId) {
        this.jtId = jtId;
    }
}
