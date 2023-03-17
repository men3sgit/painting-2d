package com.menes.project.painting.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuBar extends JMenuBar {
	JMenu options; // Menu
	JButton buttons; // Button inside file
	JMenuItem neww, open, save, select, cancel, cut, paste, move, delete, undo, redo, pencil, line, circle, rectangle,
			square, triangle, eraser, help, newW, show, hide, locationS, locationH, toolbarS, toolbarH, linesS, linesH,hlH,hlS,
			exit;
	ImageIcon icon;
	JPanel panel = new JPanel();// contain buttons in file
	// Constructor
	ColorPaneHide colors;
	DrawingButtons draw;
	Color color = new Color(220, 100, 0);
	ToolBar tools;

	public MenuBar(ToolBar t, EastFunction e) {
		// initializing Menu for MenuBar
		// add button for file
		this.tools = t;
		add(options = new JMenu("File"));
		options.setForeground(color);
		options.setMnemonic(KeyEvent.VK_F);
		icon = new ImageIcon("./icons/new2.png");
		neww = new JMenuItem("New", icon);
		options.add(neww);

		icon = new ImageIcon("./icons/open2.png");
		open = new JMenuItem("Open", icon);
		options.add(open);

		icon = new ImageIcon("./icons/save2.png");
		save = new JMenuItem("Save", icon);
		options.add(save);

		add(options = new JMenu("Modify"));
		options.setForeground(color);
		options.setMnemonic(KeyEvent.VK_M);

		icon = new ImageIcon("./icons/selected.png");
		select = new JMenuItem("Select", icon);
		options.add(select);

		icon = new ImageIcon("./icons/Nothing.png");
		cancel = new JMenuItem("Cancel", icon);
		options.add(cancel);

		icon = new ImageIcon("./icons/scissors2.png");
		cut = new JMenuItem("Cut", icon);
		options.add(cut);

		icon = new ImageIcon("./icons/paste1.png");
		paste = new JMenuItem("Paste", icon);
		options.add(paste);

		icon = new ImageIcon("./icons/move2.png");
		move = new JMenuItem("Move", icon);
		options.add(move);

		icon = new ImageIcon("./icons/remove2.png");
		delete = new JMenuItem("Delete", icon);
		options.add(delete);
//
//		icon = new ImageIcon("undo2.png");
//		undo = new JMenuItem("Undo", icon);
//		options.add(undo);
//
//		icon = new ImageIcon("redo2.png");
//		redo = new JMenuItem("Redo", icon);
//		options.add(redo); 

		draw = new DrawingButtons(tools.paint, tools.command, tools.s);
		add(options = new JMenu("Draw"));
		options.setForeground(color);
		options.setMnemonic(KeyEvent.VK_D);
		icon = new ImageIcon("./icons/pencil2.png");
		options.add(pencil = new JMenuItem("Pencil", icon));
		pencil.setBackground(Color.white);

		icon = new ImageIcon("./icons/line.png");
		options.add(line = new JMenuItem("Line", icon));
		line.setBackground(Color.white);

		icon = new ImageIcon("./icons/oval.png");
		options.add(circle = new JMenuItem("Circle", icon));
		circle.setBackground(Color.white);

		icon = new ImageIcon("./icons/rec.png");
		options.add(rectangle = new JMenuItem("Rectangle", icon));
		rectangle.setBackground(Color.white);

		icon = new ImageIcon("./icons/square3.png");
		options.add(square = new JMenuItem("Square", icon));
		square.setBackground(Color.white);

		icon = new ImageIcon("./icons/triangle.png");
		options.add(triangle = new JMenuItem("Triangle", icon));
		triangle.setBackground(Color.white);

		icon = new ImageIcon("./icons/eraser2.png");
		options.add(eraser = new JMenuItem("Eraser", icon));
		eraser.setBackground(Color.white);
//		options.add(buttons = t.draw.cir);
//		options.add(buttons = t.draw.rec);
//		options.add(buttons = t.draw.pen);
//		options.add(buttons = t.draw.era);
//		

		add(options = new JMenu("Color"));
		options.setForeground(color);
		options.setMnemonic(KeyEvent.VK_L);
		colors = new ColorPaneHide(t.paint, e.getColors());
		options.add(colors);

		add(options = new JMenu("Window"));
		options.setForeground(color);
		options.setMnemonic(KeyEvent.VK_W);
		// add button and event for Window
		options.add(newW = new JMenuItem("New Window"));
		options.add(show = new JMenu("Show"));
		icon = new ImageIcon("./icons/toado.png");
		show.add(locationS = new JMenuItem("Location", icon));
		icon = new ImageIcon("./icons/tool.png");
		show.add(toolbarS = new JMenuItem("ToolBar", icon));
		icon = new ImageIcon("./icons/gridlines.png");
		show.add(linesS = new JMenuItem("Gridlines", icon));
		icon = new ImageIcon("./icons/highlight.png");
		show.add(hlS = new JMenuItem("Highlight",icon));

		options.add(hide = new JMenu("Hide"));
		icon = new ImageIcon("./icons/toado.png");
		hide.add(locationH = new JMenuItem("Location", icon));
		icon = new ImageIcon("./icons/tool.png");
		hide.add(toolbarH = new JMenuItem("ToolBar", icon));
		icon = new ImageIcon("./icons/gridlines.png");
		hide.add(linesH = new JMenuItem("Gridlines", icon));
		icon = new ImageIcon("./icons/highlight.png");
		hide.add(hlH = new JMenuItem("Highlight",icon));


		add(options = new JMenu("Help"));
		options.setForeground(color);
		options.setMnemonic(KeyEvent.VK_H);
		icon = new ImageIcon("./icons/helppp.png");
		// show contents into help
		help = new JMenuItem("Help Content", icon);
		options.add(help);

		add(options = new JMenu("Exit"));
		options.setForeground(color);
		options.setMnemonic(KeyEvent.VK_E);
		icon = new ImageIcon("./icons/exittt.png");
		options.add(exit = new JMenuItem("Exit", icon));

		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "New":
					neww.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if (e.getSource() == neww) {
								int a = JOptionPane.showConfirmDialog(null, "There are unsaved changes to Painting-2D",
										"Do you want to save your work ?", JOptionPane.YES_NO_CANCEL_OPTION);
								if (a == 0 || a == 1) {
									t.paint.reSet();
									t.command.reSet();
									t.paint.getUndo().setEnabled(false);
									t.paint.setBackground(Color.black);
									t.paint.setSize(4);

								}
							}
						}

					});
					break;
				case "Select":
					t.paint.setToolType("Select");
					t.paint.setStarted(false);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"Select a shape "+ "\n............\n");

					break;
				case "Cancel":
					t.paint.setStarted(false);
					t.paint.Nothing();
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"Cancel all of the edit operation  "+ "\n............\n");

					break;

				case "Paste":
					t.paint.setToolType("Paste");
					t.paint.setStarted(false);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"Paste a shape "+ "\n............\n");

					break;
				case "Cut":
					t.paint.setAShapeCut();
					t.paint.setShowHideUn();
					t.paint.setStarted(false);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"Cut a shape "+ "\n............\n");

				case "Copy":
					t.paint.setShowHideUn();
					t.paint.setStarted(false);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"Copy a shape "+ "\n............\n");

					break;
				case "Delete":
					t.paint.ReMove();
					t.paint.setShowHideUn();
					t.paint.setStarted(false);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"Delete a shape "+ "\n............\n");

					break;
				case "Move":
					t.paint.setToolType("Move");
					t.paint.setStarted(false);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"Move or Edit a shape "+ "\n............\n");

					break;
				case "Help Content":
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"You open help content "+ "\n............\n");
					new HelpContent();
					break;
				case "New Window":
					 Application app = new Application();
					app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					app.setLocation(0, 0);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"New Window "+ "\n............\n");
					// t.command.setVisibleForInfor(true);
					break;
				case "Exit":
					int option = JOptionPane.showConfirmDialog(null, "Do you want to shut down programming ?  ",
							"Shut Down", JOptionPane.OK_CANCEL_OPTION);
					if (option == 0)
						System.exit(0);
					break;
				case "Pencil":
					t.paint.setType(e.getActionCommand());
					t.s.setValue(1);
					t.paint.setStarted(true);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"You selected Pencil! "+ "\n............\n");

					break;

				case "Line":
					t.paint.setType(e.getActionCommand());
					t.s.setValue(2);
					t.paint.setStarted(true);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"You selected drawing Line! "+ "\n............\n");

					
					break;
				case "Circle":
					t.paint.setType(e.getActionCommand());
					t.s.setValue(1);
					t.paint.setStarted(true);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"You selected drawing Circle! "+ "\n............\n");

					break;
				case "Oval":
					t.paint.setType(e.getActionCommand());
					t.s.setValue(18);
					t.paint.setStarted(true);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"You selected drawing Oval! "+ "\n............\n");

					break;
				case "Rectangle":
					t.paint.setType(e.getActionCommand());
					t.s.setValue(1);
					t.paint.setStarted(true);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"You selected drawing Rectangle! "+ "\n............\n");

					break;
				case "Square":
					t.paint.setType(e.getActionCommand());
					t.s.setValue(1);
					t.paint.setStarted(true);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"You selected drawing Square! "+ "\n............\n");

					break;
				case "Triangle":
					t.paint.setType(e.getActionCommand());
					t.s.setValue(3);
					t.paint.setStarted(true);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"You selected drawing Triangle! "+ "\n............\n");

					break;
				case "Eraser":
					t.paint.setType(e.getActionCommand());
					t.s.setValue(18);
					t.paint.setStarted(true);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"You selected Eraser! "+ "\n............\n");

					break;

				}

				if (e.getSource() == locationS) {
					t.command.setVisibleForInfor(true);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"Show the location bar! "+ "\n............\n");
				}
				else if (e.getSource() == locationH) {
					t.command.setVisibleForInfor(false);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"Hide the location bar! "+ "\n............\n");
				}
				else if (e.getSource() == toolbarS) {
					t.setVis(true);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"Show the toolbar! "+ "\n............\n");
				}
				else if (e.getSource() == toolbarH) {
					t.setVis(false);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"Hide the toolbar bar! "+ "\n............\n");
				}
				else if (e.getSource() == linesH) {
					t.paint.setShowLines(false);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"Hide the Gridlines! "+ "\n............\n");
				}

				else if (e.getSource() == linesS) {
					t.paint.setShowLines(true);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"Show the Gridlines! "+ "\n............\n");
					revalidate();
				}
				else if (e.getSource() == hlH) {
					t.paint.setHighlight(false);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"Hide the highlight! "+ "\n............\n");
					repaint();
				}
				else if (e.getSource() == hlS) {
					t.paint.setHighlight(true);
					t.paint.getCommand().getContent().setText(t.paint.getCommand().getContent().getText() +"Show the highlight! "+ "\n............\n");
					repaint();
				}
			}

		};
		hlS.addActionListener(action);
		hlH.addActionListener(action);
		select.addActionListener(action);
		cancel.addActionListener(action);
		paste.addActionListener(action);
		cut.addActionListener(action);
		move.addActionListener(action);
		delete.addActionListener(action);
		help.addActionListener(action);
		locationS.addActionListener(action);
		toolbarH.addActionListener(action);
		locationH.addActionListener(action);
		toolbarS.addActionListener(action);
		exit.addActionListener(action);
		newW.addActionListener(action);
		pencil.addActionListener(action);
		line.addActionListener(action);
		circle.addActionListener(action);
		rectangle.addActionListener(action);
		neww.addActionListener(action);
		triangle.addActionListener(action);
		eraser.addActionListener(action);
		square.addActionListener(action);
		linesH.addActionListener(action);
		linesS.addActionListener(action);
		setBackground(new Color(50, 50, 50));

	}
}