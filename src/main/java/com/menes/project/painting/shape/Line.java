package com.menes.project.painting.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Line2D;

public class Line extends AShape {
	boolean f = false;
	boolean center = false;
	boolean l = false;

	public Line(Point p, Color color, int d) {
		super(p, color, d);
	}

	@Override
	public void draw(Graphics g) {

		g.setColor(color);
		g.drawLine(root.x, root.y, second.x, second.y);
		if (showPoints) {
			g.setColor(Color.red);
			g.fillRect(root.x - 3, root.y - 3, 6, 6);
			g.fillRect(second.x - 3, second.y - 3, 6, 6);
			g.fillRect(root.x + ((second.x - root.x) / 2) - 3, root.y + ((second.y - root.y) / 2) - 3, 6, 6);
		}
	}

	@Override
	public void setColor(Color c) {
		// TODO Auto-generated method stub

	}

	@Override
	public String comment() {
		return "";
	}

	@Override
	public boolean checkSelected(Point point) {
		Line2D check = new Line2D.Double(root.x, root.y, second.x, second.y);
		return check.intersects(point.x - 2, point.y - 2, 4, 4);
	}

	@Override
	public boolean selectCenter(Point p) {
		if (p.x >= root.x + ((second.x - root.x) / 2) - 5 && p.x <= root.x + ((second.x - root.x) / 2) + 5
				&& (p.y >= root.y + ((second.y - root.y) / 2) - 5 && p.y <= root.y + ((second.y - root.y) / 2) + 5))
			setCenter(true);

		return true;
	}

	@Override
	public void moveByCenter(Point pressed, Point dragged) {
		if (center) {
			this.root.translate((int) (dragged.getX() - pressed.getX()), (int) (dragged.getY() - pressed.getY()));
			this.second.translate((int) (dragged.getX() - pressed.getX()), (int) (dragged.getY() - pressed.getY()));
		}
		if (pressed.x >= root.x + -5 && pressed.x <= root.x + 5 && (pressed.y >= root.y - 5 && pressed.y <= root.y + 5))

			setF(true);
		else if (pressed.x >= second.x + -5 && pressed.x <= second.x + 5
				&& (pressed.y >= second.y - 5 && pressed.y <= second.y + 5))
			setL(true);

		if (f)
			root = dragged;
		else if (l)
			second = dragged;
	}

	@Override
	public void setLocationOfAShape(Point p) {
		int x1 = (second.x - root.x) / 2;
		int y1 = (second.y - root.y) / 2;

		root.setLocation(p.x - x1, p.y - y1);
		second.setLocation(p.x + x1, p.y + y1);

	}

	@Override
	public void setRelease() {
		setF(false);
		setCenter(false);
		setL(false);
	}

	public boolean isF() {
		return f;
	}

	public void setF(boolean f) {
		this.f = f;
	}

	public boolean isCenter() {
		return center;
	}

	public void setCenter(boolean center) {
		this.center = center;
	}

	public boolean isL() {
		return l;
	}

	public void setL(boolean l) {
		this.l = l;
	}

	@Override
	public boolean fillAShape(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getTypeShape() {
		// TODO Auto-generated method stub
		return null;
	}


}
