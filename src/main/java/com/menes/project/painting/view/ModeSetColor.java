package com.menes.project.painting.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

public class ModeSetColor extends JToolBar { 
	// choose shapes for setColor
	 JRadioButton shape = new JRadioButton("Color Stroke");
	/*
	 * choose the background of Drawing Board for setColor
	 */
	JRadioButton background = new JRadioButton("Color Background");
	// set selected once in buttons
	ButtonGroup group = new ButtonGroup();
	Color color = new Color(220,100,0);

	public ModeSetColor() {
		
		setBorderPainted(false);
		
		getShape().setSelected(true);
		getShape().setFocusable(false);
		getShape().setForeground(Color.lightGray);
		getShape().setFont(new Font("Ink Free",Font.BOLD,20));
		
		background.setFocusable(false);
		background.setForeground(Color.lightGray);
		background.setFont(new Font("Ink Free",Font.BOLD,20));
		group.add(getShape());
		group.add(background);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		getShape().setBackground(new Color(50,50,50));
		background.setBackground(new Color(50,50,50));
		setBackground(new Color(50,50,50));

		add(getShape());
		add(background);
		getShape().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				setColorSelect();
			}
			
		});
		setColorSelect();
		
	}
	public void setColorSelect() {
			getShape().setForeground(Color.LIGHT_GRAY);
			background.setForeground(Color.LIGHT_GRAY);
		if(getShape().isSelected()) {
			getShape().setForeground(color);
		
		}
		else
			background.setForeground(color);
		
	}
	public JRadioButton getShape() {
		return shape;
	}
	public void setShape(JRadioButton shape) {
		this.shape = shape;
	}

}
