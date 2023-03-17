package com.menes.project.painting.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JToolBar;


public class ColorPane extends JToolBar {
	JButton[] colors = new JButton[24]; // creat buttons contain color
	JButton more = new JButton("Add color",new ImageIcon("add (1).png")); // button direction to JColorChooser
	JPanel center = new JPanel(); // panel contain color buttons
	// constructor
	ModeSetColor mode; // mode for object for setColor (AShapes or BackGround)
	DisplayCurrentColor color;
	DrawBoard draw;
	public ColorPane(DrawBoard d ,DisplayCurrentColor c) {
		this.color = c;
		this.draw = d;
		setBorderPainted(false);
		mode = new ModeSetColor();
		more.setBackground(new Color(50,50,50));
		more.setForeground(new Color(220,100,0));
		
		more.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20));
		more.setFocusable(false);

		center.setLayout(new GridLayout(4, 5));

		// set color background and shapes
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == more) {
					Color color = JColorChooser.showDialog(null, "ColorBoard", Color.black);
					d.getCommand().getContent().setText(d.getCommand().getContent().getText() +"Selected add color! "+ "\n............\n");
					if (mode.getShape().isSelected()) {
						draw.setColor(color);
						c.setShowColor(color);
						d.getCommand().getContent().setText(d.getCommand().getContent().getText() +"Color for shape is " + color.toString()+ "\n............\n");
						}
					else {
						draw.setBackground(color);
						d.getCommand().getContent().setText(d.getCommand().getContent().getText() +"Color for background is " + color.toString()+ "\n............\n");
				}
				}

				else {
					for (int i = 0; i < colors.length; i++) {
						if (e.getSource() == colors[i]) {
							if (mode.getShape().isSelected()) {
								draw.setColor(colors[i].getBackground());
								c.setShowColor(draw.getColor());
								d.getCommand().getContent().setText(d.getCommand().getContent().getText() +"Color for shape is " + colors[i].getBackground().toString()+ "\n............\n");
							}
							else {
								
								draw.setBackground(colors[i].getBackground());
								d.getCommand().getContent().setText(d.getCommand().getContent().getText() +"Color for background is " + colors[i].getBackground().toString()+ "\n............\n");
							}

						}
					}

				}
			}
		};
		// initializing colors and add action them
		for (int i = 0; i < colors.length; i++) {
			colors[i] = new JButton();
			colors[i].addActionListener(action);
			colors[i].setBorder(BorderFactory.createEmptyBorder());
			center.add(colors[i]);
		}
		// set color for buttons
		colors[18].setBackground(new Color(255, 255, 255));
		colors[1].setBackground(new Color(255, 0, 0));
		colors[2].setBackground(new Color(0, 255, 0));
		colors[3].setBackground(new Color(0,0,255));
		colors[4].setBackground(new Color(139,69,19));
		colors[5].setBackground(new Color(128,0,128));
		colors[12].setBackground(new Color(192, 192, 192));
		colors[7].setBackground(new Color(255,100 , 0));
		colors[8].setBackground(new Color(0,120,0));
		colors[9].setBackground(new Color(20,70,220));
		colors[10].setBackground(new Color(180,100,30));
		colors[11].setBackground(new Color(255,0,255));
		colors[6].setBackground(new Color(128, 128, 128));
		colors[13].setBackground(new Color(255, 255, 0));
		colors[14].setBackground(new Color(60, 170, 60));
		colors[15].setBackground(new Color(40,120,180));
		colors[16].setBackground(new Color(222,184,135));
		colors[17].setBackground(new Color(255,105,180));
		colors[0].setBackground(new Color(0, 0, 0));
		colors[19].setBackground(new Color(255, 250, 180));
		colors[20].setBackground(new Color(180,200,100));
		colors[21].setBackground(new Color(20,220,240));
		colors[22].setBackground(new Color(255,228,225));
		colors[23].setBackground(new Color(255,192,203));
		
		
		
		more.addActionListener(action);

		// change cursor when drawing in board
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		center.setBorder(BorderFactory.createEmptyBorder());
		setPreferredSize(new Dimension(0, 260));
		setLayout(new BorderLayout(-1,-1));
		add(mode,BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(more, BorderLayout.SOUTH);
		
		setBorder(BorderFactory.createEmptyBorder());

	}
	public JButton[] getColors() {
		return colors;
	}
	public JButton getMore() {
		return more;
	}
	public JPanel getCenter() {
		return center;
	}
	public ModeSetColor getMode() {
		return mode;
	}
	public DisplayCurrentColor getColor() {
		return color;
	}
	
}
