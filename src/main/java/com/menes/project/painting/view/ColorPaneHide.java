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
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;


	public class ColorPaneHide extends JPanel {
		JButton[] colors = new JButton[40]; // creat buttons contain color
		JButton more = new JButton("More >>>"); // button direction to JColorChooser
		JPanel center = new JPanel(); // panel contain color buttons
		// constructor

		public ColorPaneHide(DrawBoard p, ColorPane c) {

			more.setBackground(Color.white);
			more.setFont(new Font("", Font.BOLD, 10));
			more.setFocusable(false);

			center.setLayout(new GridLayout(5, 6));

			// set color background and shapes
			ActionListener action = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == more) {
						Color color = JColorChooser.showDialog(null, "ColorBoard", Color.black);
						p.getCommand().getContent().setText(p.getCommand().getContent().getText() +"Selected more colors! "+ "\n............\n");
						if (c.getMode().getShape().isSelected()) {
							p.setColor(color);
							c.getColor().setShowColor(color);
							if(color!=null)
							p.getCommand().getContent().setText(p.getCommand().getContent().getText() +"Color for shape is " + color.toString()+ "\n............\n");
						}
						else {
							p.setBackground(color);
							p.getCommand().getContent().setText(p.getCommand().getContent().getText() +"Color for background is " + color.toString()+ "\n............\n");
						
							
						}
					}

					else {
						for (int i = 0; i < 40; i++) {
							if (e.getSource() == colors[i]) {
								if (c.getMode().getShape().isSelected()) {
									p.setColor(colors[i].getBackground());
									c.getColor().setShowColor(colors[i].getBackground());
									p.getCommand().getContent().setText(p.getCommand().getContent().getText() +"Color for shape is " + colors[i].getBackground().toString()+ "\n............\n");
								}
								else {
									p.setBackground(colors[i].getBackground());
									p.getCommand().getContent().setText(p.getCommand().getContent().getText() +"Color for background is " + colors[i].getBackground().toString()+ "\n............\n");
								}
							}
						}

					}
				}
			};
			// initializing colors and add action them
			for (int i = 0; i < colors.length; i++) {
				colors[i] = new JButton();
				colors[i].setFocusable(false);
				colors[i].addActionListener(action);
				center.add(colors[i]);
			}
			// set color for buttons
			colors[0].setBackground(new Color(128,0,0));
			colors[1].setBackground(new Color(220,20,60));
			colors[2].setBackground(new Color(255,0,0));
			colors[3].setBackground(new Color(229, 87, 34));
			colors[4].setBackground(new Color(211, 114, 76));
			colors[5].setBackground(new Color(234, 169, 147));
			colors[6].setBackground(new Color(255,165,0));
			colors[7].setBackground(new Color(184,134,11));
			colors[8].setBackground(new Color(189,183,107));
			colors[9].setBackground(new Color(128,128,0));
			colors[10].setBackground(new Color(255,255,0));
			colors[11].setBackground(new Color(155, 215, 58));
			colors[12].setBackground(new Color	(65, 206, 9));
			colors[13].setBackground(new Color(0,100,0));
			colors[14].setBackground(new Color(144,238,144));
			colors[15].setBackground(new Color(0,250,154));
			colors[16].setBackground(new Color(32,178,170));
			colors[17].setBackground(new Color(0,255,255));
			colors[18].setBackground(new Color	(224,255,255));
			colors[19].setBackground(new Color(64,224,208));
			colors[20].setBackground(new Color(127,255,212));
			colors[21].setBackground(new Color(70,130,180));
			colors[22].setBackground(new Color(0,191,255));
			colors[23].setBackground(new Color(135,206,250));
			colors[24].setBackground(new Color	(25,25,112));
			colors[25].setBackground(new Color	(0,0,255));
			colors[26].setBackground(new Color(138,43,226));
			colors[27].setBackground(new Color(147,112,219));
			colors[28].setBackground(new Color(128,0,128));
			colors[29].setBackground(new Color(238,130,238));
			colors[30].setBackground(new Color(255,20,147));
			colors[31].setBackground(new Color(255,105,180));
			colors[32].setBackground(new Color(173, 74, 92));
			colors[33].setBackground(new Color(255,255,255));
			colors[34].setBackground(new Color(245,255,250));
			colors[35].setBackground(new Color(211,211,211));
			colors[36].setBackground(new Color(227, 223, 223));
			colors[37].setBackground(new Color(190, 187, 187));
			colors[38].setBackground(new Color(128,128,128));
			colors[39].setBackground(new Color(0,0,0));
			

			more.addActionListener(action);

			// change cursor when drawing in board
			setCursor(new Cursor(Cursor.HAND_CURSOR));

			setPreferredSize(new Dimension(200, 150));
			setLayout(new BorderLayout());
			add(center, BorderLayout.CENTER);
			add(more, BorderLayout.SOUTH);
		}

}
