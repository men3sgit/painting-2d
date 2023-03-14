package com.menes.project.painting.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class AShape {
	protected Color color;
	protected Point root;
	protected Point second;
	protected int dimension;
	protected boolean showPoints = false;
	protected boolean fill = false;
	protected Color colorFill;

	public AShape(Point r, Color color, int d) {
		this.color = color;
		this.dimension = d;
		this.root = r;
		this.second = r;
	}

	public void setSecondPoint(Point p) {
		this.second = p;
	}

	public void setColorFill(Color c) {
		colorFill = c;
	}

	public abstract void draw(Graphics g);

	public abstract void setColor(Color c);

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public abstract boolean fillAShape(Point p);

	public abstract String comment();

	public abstract boolean checkSelected(Point p); // select

	public abstract boolean selectCenter(Point p); // check when you press center point

	public abstract void moveByCenter(Point pressed, Point dragged);

	public abstract void setRelease();

	public void setShowPoints(boolean b) {
		showPoints = b;
	}
	public abstract String getTypeShape(); 
	

	public Point getRoot() {
		return root;
	}

	public void setRoot(Point root) {
		this.root = root;
	}

	public Color getColor() {
		return color;
	}

	public Point getSecond() {
		return second;
	}

	public boolean getShowPoints() {
		return this.showPoints;
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}
	public abstract void setLocationOfAShape(Point p);
}
