package com.menes.project.painting.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class StatusBar extends JToolBar{
	JLabel locationCursor = new JLabel("Location Cursor : 0, 0 px");
	JLabel sizeOfBoard = new JLabel("Drawing Board Size : ");
	JPanel inforCursor = new JPanel();// Display information location cursor and size board
	JLabel label = new JLabel("StatusBar "); // set title text
	JPanel title = new JPanel(); // set title pane
	JTextArea content  = new JTextArea(); // content
	JScrollPane scroll; // set scrollpane contains content
	Color colorText = new Color(255,222,50);
	public StatusBar() {
		label.setFont(new Font("",Font.BOLD,15));
		label.setForeground(new Color(255,222,50));
		locationCursor.setForeground(colorText);
		sizeOfBoard.setForeground(colorText);
		inforCursor.setLayout(new GridLayout(1,2));
		inforCursor.setPreferredSize(new Dimension(0,25));
		inforCursor.setBackground(new Color(55,55,55));
		inforCursor.add(locationCursor);
		inforCursor.add(sizeOfBoard);
		inforCursor.setVisible(true);
		content.setEditable(false); // set can't insert 
		content.setBackground(new Color(50,50,50));
		content.setForeground(new Color(255,230,213));
		content.setFont(new Font("MV Boli",Font.PLAIN,12));

		title.setLayout(new BoxLayout(title,BoxLayout.X_AXIS));
		title.add(label);
		title.setBackground(new Color(123,123,123));
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(0,170));
		
		scroll = new JScrollPane(content); 
		add(title,BorderLayout.NORTH);
		add(scroll,BorderLayout.CENTER);
		add(inforCursor,BorderLayout.SOUTH);
		setBorder(BorderFactory.createLineBorder(new Color(123,123,123),3));
			
	}
	public void setText(String location,String size) {
		locationCursor.setText(location);
		sizeOfBoard.setText(size);
	}
	public void setVisibleForInfor(boolean power) {
		this.inforCursor.setVisible(power);
	}
	public void reSet() {
		this.content.setText("");
	}
	public JLabel getLocationCursor() {
		return locationCursor;
	}
	public JLabel getSizeOfBoard() {
		return sizeOfBoard;
	}
	public JPanel getInforCursor() {
		return inforCursor;
	}
	public JLabel getLabel() {
		return label;
	}
	public JPanel getTitle() {
		return title;
	}
	public JTextArea getContent() {
		return content;
	}
	public JScrollPane getScroll() {
		return scroll;
	}
	public Color getColorText() {
		return colorText;
	}
	
}
