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

public class QueryWindow extends JFrame {
    JTextField jtId;
    JTextField jtSno;
    JTextField jtName;
    JTextField jtAge;
    JTextField jtMajor;
    public QueryWindow() throws HeadlessException {
        this.init();
        this.setLocation(400, 200);
        this.setSize(300, 250);
        this.setTitle("Query Interface");
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

        JButton jbAdd=new JButton("Query");
        jbAdd.addActionListener(new QueryWindow.SearchActionListener(this));
        JButton jbCancel=new JButton("Cancel");
        jbCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        contenPane.add(lbSno);
        contenPane.add(jtSno);
        contenPane.add(jbAdd);
        contenPane.add(jbCancel);
        this.setContentPane(contenPane);
    }
    class SearchActionListener implements ActionListener {
        private QueryWindow ad;
        public SearchActionListener(QueryWindow ad) {
            this.ad = ad;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String sno = jtSno.getText().trim();
            if (!"".equals(sno)) {
                System.out.println(sno);
//                if (stu.getId() == null) {
                    JOptionPane.showMessageDialog(ad, "Not Found！", "Prompt", JOptionPane.INFORMATION_MESSAGE);
//                } else {
                    view();
//                    jtId.setText(stu.getId() + "");
//                    jtId.setEditable(false);
//                    jtSno.setText(stu.getSno());
//                    jtSno.setEditable(false);
//                    jtName.setText(stu.getName());
//                    jtName.setEditable(false);
//                    jtAge.setText(stu.getAge() + "");
//                    jtAge.setEditable(false);
//                    jtMajor.setText(stu.getMajor());
//                    jtMajor.setEditable(false);
//                }
                ad.setVisible(false);
                ad.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "The information cannot be empty！", "Prompt", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    private void view() {
        JFrame frame = new JFrame();
        frame.setLocation(400, 200);
        frame.setSize(580, 250);
        frame.setTitle(AppConstants.QUERY_WIN_TITLE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.validate();

        Container contenPane = new Container();
        contenPane.setLayout(new FlowLayout());

        JLabel lbId = new JLabel();
        lbId.setFont(new Font("Dialog", Font.PLAIN, 19));
        lbId.setText("           ID  ");
        lbId.setAlignmentX(2);
        jtId = new JTextField(8);
        JLabel lbSno = new JLabel();
        lbSno.setFont(new Font("Dialog", Font.PLAIN, 19));
        lbSno.setText("         StuId  ");
        lbSno.setAlignmentX(2);
        jtSno = new JTextField(9);
        JLabel lbName = new JLabel("Name：");
        lbName.setFont(new Font("Dialog", Font.PLAIN, 19));
        lbName.setText("           Name");
        lbName.setAlignmentX(2);
        jtName = new JTextField(9);
        JLabel lbAge = new JLabel("Age：");
        lbAge.setFont(new Font("Dialog", Font.PLAIN, 19));
        lbAge.setText("         Age  ");
        lbAge.setAlignmentX(2);
        jtAge = new JTextField(6);
        JLabel lbMajor = new JLabel("Major：");
        lbMajor.setFont(new Font("Dialog", Font.PLAIN, 19));
        lbMajor.setText("         Major  ");
        lbMajor.setAlignmentX(2);
        jtMajor = new JTextField(10);

        contenPane.add(lbId);
        contenPane.add(lbSno);
        contenPane.add(lbName);
        contenPane.add(lbAge);
        contenPane.add(lbMajor);
        contenPane.add(jtId);
        contenPane.add(jtSno);
        contenPane.add(jtName);
        contenPane.add(jtAge);
        contenPane.add(jtMajor);
        frame.setContentPane(contenPane);
    }
}
