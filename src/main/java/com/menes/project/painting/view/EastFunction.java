package com.menes.project.painting.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class EastFunction extends JPanel{
	
	ColorPane colors; // color board import java
	DisplayCurrentColor colorStatus = new DisplayCurrentColor();
	DrawBoard draw;
	StrokesSize stroke;
	JPanel fakethis = new JPanel();
	JPanel center = new JPanel();
	DrawingButtons buttons;
	public EastFunction(DrawBoard d) {
		this.draw = d;
		stroke = new StrokesSize(draw);
		setBackground(new Color(123,123,123));
		buttons = new DrawingButtons(d,d.getCommand(),stroke);
		buttons.setPreferredSize(new Dimension(0,100));
		buttons.setLayout(new GridLayout(2,3));
		
		colors = new ColorPane(draw,colorStatus);
		colors.setBorder(BorderFactory.createEmptyBorder());
		setLayout(new BorderLayout());
		fakethis.setLayout(new BorderLayout());
		center.setLayout(new BorderLayout());
		center.add(colors,BorderLayout.NORTH);
		center.add(colorStatus,BorderLayout.CENTER);
		fakethis.add(center,BorderLayout.CENTER);
		fakethis.add(stroke,BorderLayout.NORTH);
		add(fakethis,BorderLayout.CENTER);
		add(buttons,BorderLayout.NORTH);
		setPreferredSize(new Dimension(220,0));
		setBorder(BorderFactory.createLineBorder(new Color(123,123,123),5));
	}
	public ColorPane getColors() {
		return colors;
	}
	public DisplayCurrentColor getColorStatus() {
		return colorStatus;
	}
	public DrawBoard getDraw() {
		return draw;
	}
	public StrokesSize getStroke() {
		return stroke;
	}
	public JPanel getCenter() {
		return center;
	}

}
