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
import edu.neu.csye6200.Objects.ClassRoom;
import edu.neu.csye6200.Objects.PersonList;
import edu.neu.csye6200.Objects.Rules;

public class ClassRoomInsertWindow extends JFrame {
    JTextField jtAge;
    JTextField jtName;
  
    Boolean isUpdate = false;

    public ClassRoomInsertWindow(Boolean isUpdate) throws HeadlessException {
        this.isUpdate = isUpdate;
        this.init();
        this.setLocation(400, 200);
        //this.setLayout(new FlowLayout());
        this.setSize(280, 350);
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

        JLabel lbAge = new JLabel();
        lbAge.setFont(new Font("Dialog", Font.PLAIN, 18));
        lbAge.setText("age: ");
        lbAge.setAlignmentX(2);
        jtAge = new JTextField(15);

        
        JLabel lbName = new JLabel("name：");
        lbName.setFont(new Font("Dialog", Font.PLAIN, 18));
        lbName.setText("name：");
        lbName.setAlignmentX(2);
        jtName = new JTextField(15);

        jbAdd.addActionListener(new AddActionListener(this));
        JButton jbCancel = new JButton("cancel");
        jbCancel.addActionListener((e) -> {
            this.dispose();
        });

        
        contenPane.add(lbAge);
        contenPane.add(jtAge);
        contenPane.add(lbName);
        contenPane.add(jtName);
    

        contenPane.add(jbAdd);
        contenPane.add(jbCancel);
        this.setContentPane(contenPane);
    }

    class AddActionListener implements ActionListener {
        private ClassRoomInsertWindow ad;

        public AddActionListener(ClassRoomInsertWindow ad) {
            this.ad = ad;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            String name = jtName.getText().trim();
            String age = jtAge.getText().trim();

            if (!"".equals(age) && !"".equals(name)) {
            	System.out.println(age);//rule
            	System.out.println(name);//name
                if (!isUpdate) {
                	
                	// 添加
                	PersonList.getInstance().addClassRoom(new ClassRoom(Rules.getInstance().getClassroomSize(Integer.parseInt(age)),name));

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
