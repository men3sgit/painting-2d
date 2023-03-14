package com.menes.project.painting.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Eraser extends AShape {
	private List<Point> list;
	private Color color;

	public Eraser(Point p, Color color, int d) {
		super(p, color, d);
		list = new ArrayList<Point>();
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		list.add(new Point(second.x, second.y));
		g.setColor(color);
		if (list.size() > 1) {
			for (int i = 0; i < list.size() - 1; i++) {
				g.drawLine((int) list.get(i).getX(), (int) list.get(i).getY(), (int) list.get(i + 1).getX(),
						(int) list.get(i + 1).getY());
			}
		}
	}

	@Override
	public void setColor(Color c) {
		this.color = c;
	}

	@Override
	public String comment() {
		return "Thickness " + this.dimension + 2;
	}

	@Override
	public boolean checkSelected(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectCenter(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void moveByCenter(Point pressed, Point dragged) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRelease() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLocationOfAShape(Point p) {
		// TODO Auto-generated method stub

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
