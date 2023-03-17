package com.menes.project.painting.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JToolBar;


public class DrawingButtons extends JToolBar {
	JButton rec, cir, line, pen, era,oval,square,triangle,fill; // buttons draw and delete
	ImageIcon icon; // show active
	// Constructor
	StatusBar command;
	public DrawingButtons(DrawBoard p, StatusBar c,StrokesSize s) {
		this.command =c ;
		setBorderPainted(false);
		// set action Drawing and show Command
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
 
				if (e.getSource() == line) {
					p.setType("Line");
					command.getContent().setText(command.getContent().getText() + "You selected drawing Line!\n........\n");
					s.setValue(3);
				} else if (e.getSource() == cir) {
					p.setType("Circle");
					command.getContent().setText(command.getContent().getText() + "You selected drawing Circle!\n........\n");
					s.setValue(12);
				}
				else if (e.getSource() == oval) {
					p.setType("Oval");
					s.setValue(2);
					command.getContent().setText(command.getContent().getText() + "You selected drawing Oval!\n........\n........\n");
				}

				else if (e.getSource() == rec) {
					p.setType("Rectangle");
					s.setValue(5);
					command.getContent().setText(command.getContent().getText() + "You selected drawing Rectangle!\n.........\n");
				}

				else if (e.getSource() == pen) {
					p.setType("Pencil");
					s.setValue(2);
					command.getContent().setText(command.getContent().getText() + "You selected drawing with Pencil!\n........\n");
				} else if (e.getSource() == era) {
					p.setType("Eraser");
					s.setValue(18);
					command.getContent().setText(command.getContent().getText() + "You selected Eraser!\n........\n");
				}
				else if (e.getSource() == square) {
					p.setType("Square");
					s.setValue(4);
					command.getContent().setText(command.getContent().getText() + "You selected Square!\n........\n");
				}
				else if (e.getSource() == triangle) {
					p.setType("Triangle");
					s.setValue(5);
					command.getContent().setText(command.getContent().getText() + "You selected drawing Triangle!\n.........\n");
				}
				else if (e.getSource() == fill) {
					p.setType("Fill");
					command.getContent().setText(command.getContent().getText() + "You selected Fill!\n........\n");
				}
				p.setStarted(true);
			}
		};
		
		
		// initializing line button
		setLayout(new GridLayout(1, 9));
		icon = new ImageIcon("line3.png");
		line = new JButton(icon);
		line.addActionListener(action);
		line.setFocusable(false);
		line.setBackground(new Color(50,50,50));
		line.setBorder(BorderFactory.createEmptyBorder());
		add(line);
		
		// initializing circle button
		icon = new ImageIcon("circel4.png");
		cir = new JButton(icon);
		cir.addActionListener(action);
		cir.setFocusable(false);
		cir.setBackground(new Color(50,50,50));
		cir.setBorder(BorderFactory.createEmptyBorder());
		add(cir);
		
		// initializing rectangle button
		icon = new ImageIcon("ellipse4.png");
		oval = new JButton(icon);
		oval.addActionListener(action);
		oval.setFocusable(false);
		oval.setBackground(new Color(50,50,50));
		oval.setBorder(BorderFactory.createEmptyBorder());
		add(oval); 	
				
		// initializing rectangle button
		icon = new ImageIcon("square3.png");
		rec = new JButton(icon);
		rec.addActionListener(action);
		rec.setFocusable(false);
		rec.setBackground(new Color(50,50,50));
		rec.setBorder(BorderFactory.createEmptyBorder());
		add(rec);
		
		// initializing triangle button
		icon = new ImageIcon("triangle2.png");
		triangle = new JButton(icon);
		triangle.addActionListener(action);
		triangle.setFocusable(false);
		triangle.setBackground(new Color(50,50,50));
		triangle.setBorder(BorderFactory.createEmptyBorder());
		add(triangle);
		
		// initializing pencil button
		icon = new ImageIcon("pencil2.png");
		pen = new JButton(icon);
		pen.addActionListener(action);
		pen.setFocusable(false);
		pen.setBackground(new Color(50,50,50));
		pen.setBorder(BorderFactory.createEmptyBorder());
		add(pen);
		
		// initializing eraser button
		icon = new ImageIcon("eraser2.png");
		era = new JButton(icon);
		era.addActionListener(action);
		era.setFocusable(false);
		era.setBackground(new Color(50,50,50));
		era.setBorder(BorderFactory.createEmptyBorder());
		add(era);
		
		icon = new ImageIcon("fill1.png");
		fill = new JButton(icon);
		fill.addActionListener(action);
		fill.setFocusable(false);
		fill.setBackground(new Color(50,50,50));
		fill.setBorder(BorderFactory.createEmptyBorder());
		add(fill);
		
//		square = new JButton("Square");	
//		square.addActionListener(action);
//		square.setFocusable(false);
//		square.setBackground(new Color(50,50,50));
//		square.setBorder(BorderFactory.createEmptyBorder());
	//	add(square);
		
		
		
		// set class
		setBackground(new Color(50,50,50));
		setPreferredSize(new Dimension(250, 50));
	}

}
