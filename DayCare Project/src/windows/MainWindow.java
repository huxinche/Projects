package windows;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye6200.AppConstants;

public class MainWindow extends JFrame {
    private static JTable jTable;
    public MainWindow() throws HeadlessException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle(AppConstants.MAIN_WIN_TITLE);
        this.setLocation(200, 40);
        this.setSize(500, 520);
        this.init();
        this.setVisible(true);
        this.setResizable(false);
        this.validate();
    }

    private void init() {
        Container contentPane = new Container();

        JButton addJb = new JButton("Teacher");
        JButton deleteJb = new JButton("Student");
        JButton updateJb = new JButton("Classroom");
        JButton exitJb = new JButton("Quit");
        exitJb.addActionListener(e -> this.dispose());
        Font font=new Font("楷体", Font.PLAIN, 13);
        addJb.setFont(font);
        deleteJb.setFont(font);
        updateJb.setFont(font);
        addJb.setForeground(Color.yellow);
        deleteJb.setForeground(Color.yellow);
        updateJb.setForeground(Color.yellow);
        exitJb.setForeground(Color.yellow);
        addJb.setBackground(Color.BLUE);
        deleteJb.setBackground(Color.BLUE);
        updateJb.setBackground(Color.BLUE);
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
        addListenerForButton(addJb, deleteJb, updateJb);
        JPanel btnPanl = new JPanel();
        btnPanl.setLayout(new FlowLayout());
        btnPanl.add(addJb);
        btnPanl.add(deleteJb);
        btnPanl.add(updateJb);
        btnPanl.add(exitJb);
        contentPane.add(jScrollPane);
        contentPane.add(btnPanl);
        contentPane.setLayout(new FlowLayout());
        this.setContentPane(contentPane);
    }

    public static void flushTable() {
       
    }

    private void addListenerForButton(JButton addJb, JButton deleteJb, JButton updateJb) {
        addJb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TeacherQueryWindow();
            }
        });
        deleteJb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					new StudentQueryWindow();
				} catch (HeadlessException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				} catch (ParseException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
            }
        });
        updateJb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClassQueryWindow();
            }
        });
    }

}
