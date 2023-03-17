package com.menes.project.painting.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;


public class ModifyButtons extends JToolBar {
	JButton move, scissor, u, r, trash, select, copy, paste, nothing; // creat control buttons
	ImageIcon icon; // icon of button

	public ModifyButtons(DrawBoard d) {
		setLayout(new GridLayout(1, 5));
		setBorderPainted(false);
		setBackground(new Color(50, 50, 50));
		icon = new ImageIcon("./icons/move2.png");
		move = new JButton(icon);
		move.setBackground(getBackground());
		move.setFocusable(false);
		move.setBorder(BorderFactory.createEmptyBorder());

		icon = new ImageIcon("./icons/selected.png");
		select = new JButton(icon);
		select.setBackground(getBackground());
		select.setFocusable(false);
		select.setBorder(BorderFactory.createEmptyBorder());

		icon = new ImageIcon("./icons/scissors2.png");
		scissor = new JButton(icon);
		scissor.setBackground(getBackground());
		scissor.setFocusable(false);
		scissor.setBorder(BorderFactory.createEmptyBorder());

		icon = new ImageIcon("./icons/paste1.png");
		paste = new JButton(icon);
		paste.setBackground(getBackground());
		paste.setFocusable(false);
		paste.setBorder(BorderFactory.createEmptyBorder());

		icon = new ImageIcon("./icons/nothing.png");
		nothing = new JButton(icon);
		nothing.setBackground(getBackground());
		nothing.setFocusable(false);
		nothing.setBorder(BorderFactory.createEmptyBorder());

		icon = new ImageIcon("./icons/copy1.png");
		copy = new JButton(icon);
		copy.setBackground(getBackground());
		copy.setFocusable(false);
		copy.setBorder(BorderFactory.createEmptyBorder());

		u = d.getUndo();

		r = d.getRedo();

		icon = new ImageIcon("./icons/remove2.png");
		trash = new JButton(icon);
		trash.setBackground(getBackground());
		trash.setFocusable(false);
		trash.setBorder(BorderFactory.createEmptyBorder());

		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == u) {
					d.getShapes2().add(d.getShapes().get(d.getShapes().size() - 1)); // shape2 + 1
					d.UndoShape(); // -1 shape
					d.setShowHideRe(); // always true
					d.getCommand().getContent()
							.setText(d.getCommand().getContent().getText() + "Undo a shape" + "\n............\n");

				} else if (e.getSource() == r) {
					d.reShape(); // +1
					d.setShowHideRe(); // if length<1 false
					d.setShowHideUn(); // always true
					d.getCommand().getContent()
							.setText(d.getCommand().getContent().getText() + "Redo a shape" + "\n............\n");
				} else if (e.getSource() == select) {
					d.setToolType("Select");
					d.getCommand().getContent()
							.setText(d.getCommand().getContent().getText() + "Select a shape " + "\n............\n");

				} else if (e.getSource() == move) {
					d.setToolType("Move");
					d.getCommand().getContent().setText(
							d.getCommand().getContent().getText() + "Move or Edit a shape " + "\n............\n");
				} else if (e.getSource() == trash) {
					
					d.ReMove();
					d.setShowHideUn(); // always true
					d.getCommand().getContent()
							.setText(d.getCommand().getContent().getText() + "Remove a shape " + "\n............\n");
				} else if (e.getSource() == scissor) {
					d.setAShapeCut();
					d.setShowHideUn(); // always true
					d.getCommand().getContent()
							.setText(d.getCommand().getContent().getText() + "Cut a shape " + "\n............\n");
				} else if (e.getSource() == paste) {
					d.setToolType("Paste");
					d.getCommand().getContent()
							.setText(d.getCommand().getContent().getText() + "Paste a shape " + "\n............\n");

				} else if (e.getSource() == copy) {
					d.setCopy(true);
					d.getCommand().getContent()
							.setText(d.getCommand().getContent().getText() + "Copy a shape " + "\n............\n");
				} else if (e.getSource() == nothing) {
					d.Nothing();
					d.getCommand().getContent().setText(d.getCommand().getContent().getText()
							+ "Cancel all of the editing operation " + "\n............\n");
				}
				d.setStarted(false);

			}

		};
		u.addActionListener(action);
		r.addActionListener(action);
		select.addActionListener(action);
		move.addActionListener(action);
		trash.addActionListener(action);
		paste.addActionListener(action);
		scissor.addActionListener(action);
		nothing.addActionListener(action);
		scissor.setMnemonic(KeyEvent.VK_X);
		paste.setMnemonic(KeyEvent.VK_V);
		copy.addActionListener(action);
		copy.setMnemonic(KeyEvent.VK_C);
		add(u);
		add(r);
		addSeparator();
		add(nothing);
		add(select);
		add(move);
		add(scissor);
		//add(copy);
		add(paste);
		add(trash);

	}

}
