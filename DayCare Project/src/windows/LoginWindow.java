package windows;



import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.neu.csye6200.AppConstants;

public class LoginWindow extends JFrame {
    public LoginWindow()  {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
        this.setSize(new Dimension(435, 314));
        this.setLocation(277,122);
        this.setTitle(AppConstants.LOGIN_WIN_TITLE);
        this.setVisible(true);
        this.setResizable(false);
    }

    private void init() {
        Container contentPane =  new Container();
        contentPane.setBackground(Color.magenta);
        JLabel welcomeTitle = new JLabel("Student Information System");
        JLabel jLUsername = new JLabel("Username:");
        JLabel jLPassword = new JLabel("Password:");
//        JLabel jLleixing = new JLabel("类  型:");
        JButton jBLogin = new JButton("Login");
        JButton jBCancel = new JButton("Reset");
//        JButton jBregister = new JButton("注  册");
        JTextField jtName = new JTextField();
        JPasswordField jtPwd = new JPasswordField();

//        JComboBox<String> jtlx = new JComboBox<String>();
//        jtlx.addItem("老师");
//        jtlx.addItem("学生");
        Font font = new Font("楷体", Font.BOLD, 18);
        welcomeTitle.setFont(font);
        jLUsername.setFont(font);
        jLPassword.setFont(font);
//        jLleixing.setFont(font);
        jBLogin.setFont(font);
        jBCancel.setFont(font);
//        jBregister.setFont(font);
        jtName.setFont(font);
//        jtlx.setFont(font);



        welcomeTitle.setFont(font);
        welcomeTitle.setBounds(new Rectangle(122, 39, 346, 30));
        jLUsername.setBounds(new Rectangle(75, 123, 70, 25));
        jLPassword.setBounds(new Rectangle(75, 162, 70, 21));
//        jLleixing.setBounds(new Rectangle(75, 202, 70, 21));
        jtName.setBounds(new Rectangle(158, 122, 212, 27));
        jtPwd.setBounds(new Rectangle(158, 162, 213, 26));
//        jtlx.setBounds(new Rectangle(158, 202, 213, 26));
        jBLogin.setBounds(new Rectangle(84, 243, 93, 30));
        jBCancel.setBounds(new Rectangle(286, 243, 93, 30));
//        jBregister.setBounds(new Rectangle(185, 243, 93, 30));
        jtName.setBorder(BorderFactory.createLoweredBevelBorder());
        jtPwd.setBorder(BorderFactory.createLoweredBevelBorder());
//        jtlx.setBorder(BorderFactory.createLoweredBevelBorder());
        jBLogin.setBorder(BorderFactory.createRaisedBevelBorder());
        jBLogin.setBackground(Color.blue);
        jBLogin.setForeground(Color.red);
//        jBregister.setForeground(Color.blue);
//        jBregister.setBackground(Color.red);

        jBCancel.setBorder(BorderFactory.createRaisedBevelBorder());
        jBCancel.setBackground(Color.blue);
        jBCancel.setForeground(Color.red);
        jtName.setText("admin");
        jtPwd.setText("admin");
//        jBregister.setBorder(BorderFactory.createRaisedBevelBorder());
//        jBregister.setForeground(Color.red);
//        jBregister.setBackground(Color.blue);
//
//        jBregister.addActionListener(e -> {
//            int selectedIndex = jtlx.getSelectedIndex();
//
//            if (selectedIndex==0) {
//                new TeacherInsertWindow(false);
//            }
//
//            if (selectedIndex==1) {
//                new StudentInsertWindow(false);
//
//            }
//
//        });

        jBCancel.addActionListener(e -> {
            jtName.setText("");
            jtPwd.setText("");
        });
        contentPane.add(welcomeTitle);
        contentPane.add(jLUsername);
        contentPane.add(jLPassword);
//        contentPane.add(jLleixing);
        contentPane.add(jtName);
        contentPane.add(jtPwd);
//        contentPane.add(jtlx);

        contentPane.add(jBLogin);
        contentPane.add(jBCancel);
//        contentPane.add(jBregister);
        contentPane.setForeground(Color.GREEN);
        this.setContentPane(contentPane);
        jBLogin.addActionListener(e -> {
//            JOptionPane.showMessageDialog(this, "去登陆!");
            new MainWindow();
            this.dispose();
//            if (jtName.getText().length() == 0) {
//                JOptionPane.showMessageDialog(this, "用户名不能为空！", "提 示",
//                        JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                String pwd= String.valueOf(jtPwd.getPassword());
//                System.out.println(jtName.getText());
//                if (jtName.getText().trim().equals(user.getUsername()) && pwd.equals(user.getPassword()) ) {
//                    new MainWindow();
//                    this.dispose();
//                } else {
//                    JOptionPane.showMessageDialog(this, "用户名或密码错误！", "提 示",
//                            JOptionPane.INFORMATION_MESSAGE);
//                }
//            }
        });
    }
}
