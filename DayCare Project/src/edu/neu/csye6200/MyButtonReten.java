/**
 * Project Name:school
 * File Name:MyButtonReten.java
 * Package Name:liubingchen
 * Date:2020年8月14日下午8:47:54
 * Copyright (c) 2020, 深圳金融电子结算中心 All Rights Reserved.
 *
*/

package edu.neu.csye6200;


import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


/**
 * ClassName:MyButtonReten <br/>
 * Function: TODO  <br/>
 * Date:     2020年8月14日 下午8:47:54 <br/>
 * @author   FL
 * @version   1.0
 * @since    JDK 1.7
 * @see 	 
 */
public class MyButtonReten implements TableCellRenderer {
	  private JPanel jPanel;
	  private JButton jButton;

	  public MyButtonReten(String s) {
	    initJPanel();
	    initButton(s);
	      jPanel.add(jButton);
	  }

	  private void initButton(String s) {
	      jButton = new JButton();
	      jButton.setText(s);
	      jButton.setBounds(2, 3, 100, 20);
	  }

	  private void initJPanel() {
	      jPanel = new JPanel();
	      jPanel.setLayout(null);
	  }

	  @Override
	  public Component getTableCellRendererComponent(
	      JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		  Font font = new Font("楷体", Font.BOLD, 11);
	      
	      jButton.setFont(font);
	      
	    return jPanel;
	  }
	}
