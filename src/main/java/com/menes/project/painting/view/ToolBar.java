package com.menes.project.painting.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JToolBar;


public class ToolBar extends JToolBar {
	ColorPane colors; // color board import java

	// DrawingButtons draw; // Drawing
	ModifyButtons control;
	DrawBoard paint;
	StatusBar command;
	FileToolBar file;
	StrokesSize s;

	public ToolBar(EastFunction e) {
		this.paint = e.getDraw();
		this.command = e.getDraw().getCommand();
		this.s = e.getStroke();
		setBorderPainted(false);

		file = new FileToolBar(e.getDraw());
		control = new ModifyButtons(e.getDraw());
		// draw = new DrawingButtons(e.draw, command,s);
		setPreferredSize(new Dimension(0, 50));
		setBackground(new Color(50, 50, 50));
		add(file);
		add(control);
		addSeparator();
		addSeparator();
		addSeparator();
		// add(draw);
		addSeparator();
		// add(size);
		// add(mode);
		// add(colors);
		setBorder(BorderFactory.createLineBorder(new Color(50, 50, 50), 5));
		setVisible(true);

	}

	public void setVis(boolean power) {
		this.setVisible(power);
	}

	public ColorPane getColors() {
		return colors;
	}

//	public DrawingButtons getDraw() {
//		return draw;
//	}

	public ModifyButtons getControl() {
		return control;
	}

	public DrawingBoard getPaint() {
		return paint;
	}

	public StatusBar getCommand() {
		return command;
	}

	public File getFile() {
		return file;
	}

	public StrokesSize getS() {
		return s;
	}

}
