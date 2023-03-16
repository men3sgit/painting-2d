package com.menes.project.painting.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class StrokesSize extends JToolBar{
	JSlider size = new JSlider();
	JLabel value = new JLabel();
	JLabel title = new JLabel();
	public StrokesSize(DrawingBoard d) {
		setBackground(new Color(50,50,50));
		setBorderPainted(false);
		title.setText("Thickness :   ");
		title.setFont(new Font("Comis Sans",Font.ITALIC,15));
		title.setForeground(new Color(255,222,50));
		
		
		size.setPreferredSize(new Dimension(10,10));
		size.setMaximum(38);
		size.setCursor(new Cursor(Cursor.HAND_CURSOR));
		size.setValue(2);
		size.setPaintLabels(true); // show value
		size.setFocusable(false);
		size.setBackground(new Color(50,50,50));
		
		
		value.setText(" "+(size.getValue()+2)+" px");
		value.setForeground(new Color(255,222,50));
		
		size.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
			
				value.setText(" "+(size.getValue()+2)+" px");
				d.setSize(size.getValue());
				
			}
			
		});
		
		add(title);
		add(size);
		add(value);
	}
	public void setValue(int value) {
		size.setValue(value);
	}

}
