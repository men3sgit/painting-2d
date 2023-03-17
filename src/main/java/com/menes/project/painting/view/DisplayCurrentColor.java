package com.menes.project.painting.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayCurrentColor extends JPanel{
	JLabel title = new JLabel("Current Color");
	JPanel center = new JPanel();
	public CurrentlyColor() {
		title.setForeground(new Color(255,222,50));
		title.setBackground(new Color(123,123,123));
		title.setOpaque(true);
		title.setFont(new Font("Comic Sans",Font.BOLD,12));
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(0,100));
		center.setBackground(Color.CYAN);
		add(title,BorderLayout.NORTH);
		add(center,BorderLayout.CENTER);
	}
	public void setShowColor(Color c) {
		center.setBackground(c);
	}
	public JLabel getTitle() {
		return title;
	}
	public JPanel getCenter() {
		return center;
	}
	

}
