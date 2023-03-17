package com.menes.project.painting.view;

import com.menes.project.painting.shape.*;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DrawBoard extends JPanel {
	JLabel label; // title text
	JPanel title = new JPanel(); // title pane
	Color color = Color.cyan; // color of shapes
	String type = "A"; // type shapse
	List<AShape> shapes = new ArrayList<AShape>(); // list AShape
	AShape shape; // abstract shape
	StatusBar command;
	JButton undo, redo; // Modify Button
	ImageIcon icon; // icon of button (Undo,Redo)
	boolean showLines = false;
	List<AShape> shapes2 = new ArrayList<AShape>(); // list save AShape when you click undo button
	int size;
	Point p;
	boolean started = false;
	String toolType = "";
	AShape cuted;
	boolean copy = false;
	AShape fakeShape;
	boolean highlight = false;
	List<Point> twoLines = new ArrayList<Point>();

	public DrawBoard(StatusBar c) {
		this.command = c;
		label = new JLabel("Drawing Board");
		label.setFont(new Font("", Font.BOLD, 20));
		label.setForeground(new Color(255, 222, 50));
		title.setLayout(new BoxLayout(title, BoxLayout.X_AXIS));
		title.add(label);
		title.setBackground(new Color(100, 100, 100));
		setLayout(new BorderLayout());
		add(title, BorderLayout.NORTH);
		setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 5));

		icon = new ImageIcon("undo2.png");
		undo = new JButton(icon);
		undo.setBackground(new Color(50, 50, 50));
		undo.setEnabled(false);
		undo.setFocusable(false);
		undo.setBorder(BorderFactory.createEmptyBorder());

		icon = new ImageIcon("redo2.png");
		redo = new JButton(icon);
		redo.setBackground(new Color(50, 50, 50));
		redo.setEnabled(false);
		redo.setFocusable(false);
		redo.setBorder(BorderFactory.createEmptyBorder());
		setBackground(Color.black);

		MouseAdapter click = new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				switch (toolType) {
				case "Select":
					checkSelect(e.getPoint());
					break;
				case "Move":
					for (AShape a : shapes) {
						if (a.getShowPoints())
							a.selectCenter(e.getPoint());
					}
					break;
				case "Paste":
					if (cuted != null) {
						cuted.setLocationOfAShape(e.getPoint());
						shapes.add(cuted);
						command.content.setText(command.content.getText() + "The object has been pasted at "
								+ e.getPoint().toString() + "\n..........\n");
						repaint();
						setToolType("");
						;

					}
					if (copy) {
						for (int i = 0; i < shapes.size(); i++) {
							if (shapes.get(i).getShowPoints()) {

								switch (shapes.get(i).getTypeShape()) {
								case "Circle":
									fakeShape = new Circle(shapes.get(i).getRoot(), shapes.get(i).getColor(),
											shapes.get(i).getDimension());
									break;
								case "Oval":
									fakeShape = new Oval(shapes.get(i).getRoot(), shapes.get(i).getColor(),
											shapes.get(i).getDimension());
									break;
								case "Rectangle":
									fakeShape = new Rectangle(shapes.get(i).getRoot(), shapes.get(i).getColor(),
											shapes.get(i).getDimension());
									break;
								case "Square":
									fakeShape = new Square(shapes.get(i).getRoot(), shapes.get(i).getColor(),
											shapes.get(i).getDimension());
									break;
								case "Line":
									fakeShape = new Line(shapes.get(i).getRoot(), shapes.get(i).getColor(),
											shapes.get(i).getDimension());
									break;
								case "Triangle":
									fakeShape = new Triangle(shapes.get(i).getRoot(), shapes.get(i).getColor(),
											shapes.get(i).getDimension());
									break;
								}

								repaint();
								break;
							}

						}
//						setAShapeCopy();
//						if(fakeShape!=null) {
//							fakeShape.setLocationOfAShape(e.getPoint());
//							shapes.add(fakeShape);
//							System.out.println(fakeShape.getRoot());
//						repaint();
					}
				}

				// it's a pencil when you haven't selected the shape type
//				shape = new Pencil(e.getPoint(), getColor(), size);
				if (started) {
					switch (type) {
					case "Line":
						shape = new Line(e.getPoint(), getColor(), size);
						break;
					case "Circle":
						shape = new Circle(e.getPoint(), getColor(), size);
						break;
					case "Oval":
						shape = new Oval(e.getPoint(), getColor(), size);
						break;
					case "Rectangle":
						shape = new Rectangle(e.getPoint(), getColor(), size);
						break;
					case "Pencil":
						shape = new Pencil(e.getPoint(), getColor(), size);
						break;
					case "Eraser":
						shape = new Eraser(e.getPoint(), getBackground(), size);

						break;
					case "Square":
						shape = new Square(e.getPoint(), getColor(), size);
						break;
					case "Triangle":
						shape = new Triangle(e.getPoint(), getColor(), size);
						break;
					case "Fill":
						if (shapes.size() > 0) {
							for (AShape a : shapes) {
								if (a.fillAShape(e.getPoint())) {
									a.setColorFill(color);
									repaint();
								}
							}
						}
						break;

					}
					if (!type.equals("Fill")) {
						shapes.add(shape);
						setRedoDraw();
					}
				}
				p = e.getPoint();

			}

			// convert cursor when drawing in drawing board
			@Override
			public void mouseEntered(MouseEvent e) {
				title.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

			}

			public void mouseReleased(MouseEvent e) {
				if (started) {
					if (shape != null) {
						c.content.setText(c.content.getText() + type + " From " + p.toString() + " To "
								+ e.getPoint().toString() + shape.comment() + "\n..........\n");

						// update length for set Show or Hide of both
						getLength();
						// if have a shape enable undo == true
						setShowHideUn(); 
					}

				}
				for (AShape a : shapes) {
					a.setRelease();
				}
//
//				switch (type) {
//				case "Rectangle":
//					setStarted(false);
//					break;
//				case "Circle":
//					setStarted(false);
//					break;
//				case "Oval":
//					setStarted(false);
//					break;
//				case "Square":
//					setStarted(false);
//					break;
//				case "Line":
//					setStarted(false);
//					break;
//				case "Triangle":
//					setStarted(false);
//					break;
//				case "Fill":
//					setStarted(false);
//					break;
//				}

			}

		};
		MouseMotionListener move = new MouseMotionListener() {
			// add last Points for AShape
			@Override
			public void mouseMoved(MouseEvent e) {
				String l = "Location Cursor : " + (e.getX() - 5) + ", " + (e.getY() - 30) + " px"; // getLocation now
				String s = "Drawing Board Size : " + getWidth() + " x " + getHeight() + " px"; // getSize of Painting
				command.setText(l, s);

				twoLines.add(e.getPoint());
				repaint();

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// System.out.println(shape.points.size());
				twoLines.add(e.getPoint());
				repaint();
				switch (toolType) {
				case "Move":
					for (AShape a : shapes) {
						if (a.getShowPoints()) {
							a.moveByCenter(p, e.getPoint());
							p.setLocation(e.getPoint());
							repaint();

						}
					}
					break;
				}

				if (started) {
					if (shape != null) {
						shape.setSecondPoint(e.getPoint());
						String l = "Location Cursor : " + (e.getX() - 5) + ", " + (e.getY() - 30) + " px";
						String s = "Drawing Board Size : " + getWidth() + " x " + getHeight() + " px";
						command.setText(l, s);
						repaint();
					}
				}
				String l = "Location Cursor : " + (e.getX() - 5) + ", " + (e.getY() - 30) + " px";
				String s = "Drawing Board Size : " + getWidth() + " x " + getHeight() + " px";
				command.setText(l, s);
			}

		};
		// add Events
		addMouseListener(click);
		addMouseMotionListener(move);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (showLines) {
			g.setColor(new Color(100, 100, 100));
			for (int i = 0; i < 50; i++) {
				for (int j = 0; j < 50; j++) {
					g.drawRect(6 + j * 26, 4 + i * 26, 26, 26);
				}
			}
		}
		if (highlight) {
			if (twoLines.size() > 0) {
				g.setColor(new Color(200, 200, 200));
				g.drawLine(twoLines.get(twoLines.size() - 1).x, twoLines.get(twoLines.size() - 1).y - 1000,
						twoLines.get(twoLines.size() - 1).x, twoLines.get(twoLines.size() - 1).y + 1000);
				g.drawLine(twoLines.get(twoLines.size() - 1).x - 1000, twoLines.get(twoLines.size() - 1).y,
						twoLines.get(twoLines.size() - 1).x + 1000, twoLines.get(twoLines.size() - 1).y);
			}
		}
		Graphics2D g2D = (Graphics2D) g;
		if (shapes.size() > 0) {
			for (AShape a : shapes) {
				a.setColor(getBackground());
				g2D.setStroke(new BasicStroke(a.getDimension()));
				a.draw(g2D);

			}
		}

	}

	// shape type you want to drawing
	public void setType(String type) {
		this.type = type;
	}

	// set thickness
	public void setSize(int s) {
		this.size = s;
	}

// remove shape when you click undo button
	public void UndoShape() {
		if (shapes.size() > 0) {
			shapes.remove(shapes.size() - 1);
			getLength();
			setShowHideUn();

		}
		repaint();
	}

	public void reShape() {
		if (shapes2.size() > 0) {
			shapes.add(shapes2.get(shapes2.size() - 1));
			getLength();
			shapes2.remove(shapes2.get(shapes2.size() - 1));

		}
		repaint();

	}

	// update size of Shapes(List)
	public int getLength() {
		return shapes.size();
	}

	// Buoc trung gian de tuong tac giua 2 doi tuong
	// enable = false when shapes.size() = 0 ;
	public void setShowHideUn() {
		if (getLength() < 1)
			undo.setEnabled(false);
		else {
			undo.setEnabled(true);
			// setRedoButton();
		}
	}

	// if you draw a new shape, enable = false
	public void setRedoDraw() {
		redo.setEnabled(false);
		shapes2.removeAll(shapes2);

	}

	// show Enable Redo Button
	public void setShowHideRe() {
		if (shapes2.size() > 0) {
			redo.setEnabled(true);
		} else
			redo.setEnabled(false);

	}

	public void reSet() {
		setType("");
		shapes.removeAll(shapes);
		repaint();
	}

	public void setStarted(boolean s) {
		started = s;
	}

	public JLabel getLabel() {
		return label;
	}

	public JPanel getTitle() {
		return title;
	}

	public Color getColor() {
		return color;
	}

//	
	public void setToolType(String s) {
		this.toolType = s;
	}

	public String getType() {
		return type;
	}

	public List<AShape> getShapes() {
		return shapes;
	}

	public AShape getShape() {
		return shape;
	}

	public StatusBar getCommand() {
		return command;
	}

	public JButton getUndo() {
		return undo;
	}

	public JButton getRedo() {
		return redo;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public List<AShape> getShapes2() {
		return shapes2;
	}

	public Point getP() {
		return p;
	}

	public boolean isStarted() {
		return started;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void Nothing() {
		for (AShape a : shapes) {
			a.setShowPoints(false);
			repaint();
		}
	}

	public void checkSelect(Point p) {
		for (AShape a : shapes) {
			if (a.checkSelected(p)) {
				a.setShowPoints(true);
				this.command.content
						.setText(this.command.content.getText() + "Select object by intersect \n..........\n");
			} else {
				// this.command.content.setText(this.command.content.getText()+"Not specify
				// object\n..........\n");
				a.setShowPoints(false);
				a.setRelease();
			}
			repaint();
		}

	}

	public void setAShapeCut() {
		for (int i = 0; i < shapes.size(); i++) {
			if (shapes.get(i).getShowPoints()) {
				cuted = shapes.get(i);
				shapes.remove(shapes.get(i));
			}
			repaint();

		}
	}

	public void ReMove() {
		for (int i = 0; i < shapes.size(); i++) {
			if (shapes.get(i).getShowPoints()) {
				shapes.remove(shapes.get(i));
				repaint();
			}
		}
	}

	public boolean isShowLines() {
		return showLines;
	}

	public void setShowLines(boolean showLines) {
		this.showLines = showLines;
	}

	public boolean isCopy() {
		return copy;
	}

	public void setCopy(boolean copy) {
		this.copy = copy;
	}

	public boolean isHighlight() {
		return highlight;
	}

	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}

}
