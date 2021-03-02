package windows;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import edu.neu.csye6200.AppConstants;

public class UpdateWindow extends JFrame {
    JTextField jtSno;
    public UpdateWindow() throws HeadlessException {
        this.init();
        this.setLocation(400, 200);
        this.setSize(300, 250);
        this.setTitle(AppConstants.UPDATE_WIN_TITLE);
        this.setVisible(true);
        this.setResizable(false);
        this.validate();
    }
    private void init() {
        Container contenPane = new Container();
        contenPane.setLayout(new FlowLayout());
        JLabel lbSno = new JLabel();
        lbSno.setFont(new Font("Dialog", Font.PLAIN, 18));
        lbSno.setText("StuId：");
        jtSno = new JTextField(15);

        JButton jbAdd=new JButton("Modify");
        jbAdd.addActionListener(new UpdateWindow.UpdateActionListener(this));
        JButton jbCancel=new JButton("Cancel");
        jbCancel.addActionListener((e)-> { setVisible(false);});
        contenPane.add(lbSno);
        contenPane.add(jtSno);
        contenPane.add(jbAdd);
        contenPane.add(jbCancel);
        this.setContentPane(contenPane);
    }
    class UpdateActionListener implements ActionListener {
        private UpdateWindow updateWindow;
        public UpdateActionListener(UpdateWindow updateWindow) {
            this.updateWindow = updateWindow;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String sno = jtSno.getText().trim();
            if (!"".equals(sno)) {
//                StudentDao studentDao = new StudentDaoImpl();
//                Student stu = studentDao.searchStudent(sno);
                TeacherInsertWindow insertWindow = new TeacherInsertWindow(true);
//                JTextField jtId = insertWindow.getJtId();
//                jtId.setText(stu.getId() + "");
//                JTextField jtSno = insertWindow.getJtSno();
//                jtSno.setText(stu.getSno());
//                JTextField jtName = insertWindow.getJtName();
//                jtName.setText(stu.getName());
//                JTextField jtAge = insertWindow.getJtAge();
//                jtAge.setText(stu.getAge() + "");
//                JTextField jtMajor = insertWindow.getJtMajor();
//                jtMajor.setText(stu.getMajor());
                updateWindow.dispose();
                MainWindow.flushTable();
            } else {
                JOptionPane.showMessageDialog(null, "The information cannot be empty！", "Prompt", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
