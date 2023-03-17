package com.menes.project.painting.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class HelpContent extends JFrame {
	ImageIcon icon = new ImageIcon("./icons/paint-brush.png"); // set title icon
	JTextArea text = new JTextArea(); // contain
	JScrollPane scroll = new JScrollPane(text); // align contents

	public HelpContent() {
		super("Help");
		text.setText("The elements of a String are called characters. The number of characters in a String is called the length, and it can be retrieved with the String.length() method.\r\n"
				+ "\r\n"
				+ "Given two strings of lowercase English letters,  and , perform the following operations:\r\n"
				+ "\r\n"
				+ "Sum the lengths of  and .\r\n"
				+ "Determine if  is lexicographically larger than  (i.e.: does  come before  in the dictionary?).\r\n"
				+ "Capitalize the first letter in  and  and print them on a single line, separated by a space.\r\n"
				+ "Input Format\r\n"
				+ "\r\n"
				+ "The first line contains a string . The second line contains another string . The strings are comprised of only lowercase English letters.\r\n"
				+ "\r\n"
				+ "Output Format\r\n"
				+ "\r\n"
				+ "There are three lines of output:\r\n"
				+ "For the first line, sum the lengths of  and .\r\n"
				+ "For the second line, write Yes if  is lexicographically greater than  otherwise print No instead.\r\n"
				+ "For the third line, capitalize the first letter in both  and  and print them on a single line, separated by a space.");
		setIconImage(icon.getImage());
		text.setFont(new Font("Comic Sans", Font.ITALIC, 15)); // set font for paragraph
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(scroll);
		setSize(500, 500); 
		setVisible(true);
	}   
 
}
