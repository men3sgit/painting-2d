package com.menes.project.painting.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;


public class FileToolBar extends JToolBar{
	JButton neww, open, save;
	ImageIcon icon;
	Color color = new Color(220,100,0);
	
	public FileToolBar(DrawBoard d) {
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == neww) {
				 int a = JOptionPane.showConfirmDialog(null, "There are unsaved changes to Painting-2D", "Do you want to save your work ?", JOptionPane.YES_NO_CANCEL_OPTION);
				 if(a==0||a==1) {
					d.reSet();
					d.getCommand().reSet();
					d.setBackground(Color.black);
					d.setSize(4);
					d.getUndo().setEnabled(false);
					//d.setBBackGround(Color.black);
	
				}
				}
			}
			
		};
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBackground(new Color(50,50,50));
		setBorderPainted(false);
		icon = new ImageIcon("./icons/new2.png");
		neww = new JButton("New", icon);
		neww.addActionListener(action);
		neww.setForeground(color);
		neww.setBackground(getBackground());
		neww.setBorder(BorderFactory.createEmptyBorder());
		addSeparator();	
		add(neww);

		icon = new ImageIcon("./icons/open2.png");
		open = new JButton("Open", icon);
		open.setForeground(color);
		open.setBackground(getBackground());
		open.setBorder(BorderFactory.createEmptyBorder());
		addSeparator();
		add(open);

		icon = new ImageIcon("./icons/save2.png");
		save = new JButton("Save", icon);
		save.setForeground(color);
		save.setBackground(getBackground());
		save.setBorder(BorderFactory.createEmptyBorder());
		addSeparator();
		add(save);
		
	}

}
