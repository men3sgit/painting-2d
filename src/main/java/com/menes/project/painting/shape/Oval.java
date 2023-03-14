
package com.menes.project.painting.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class Oval extends AShape {
	boolean north = false;
	boolean east = false;
	boolean west = false;
	boolean south = false;
	boolean center = false;

	public Oval(Point p, Color color, int d) {
		super(p, color, d);
	}

	@Override
	public void draw(Graphics g) {

		int minX = Math.min(root.x, second.x);
		int minY = Math.min(root.y, second.y);
		int maxX = Math.max(root.x, second.x);
		int maxY = Math.max(root.y, second.y);

		int width = maxX - minX;
		int height = maxY - minY;

		g.setColor(color);
		g.drawOval(minX, minY, maxX - minX, maxY - minY);

		if (fill) {
			g.setColor(colorFill);
			g.fillOval(minX + this.dimension / 2 - 1, minY + this.dimension / 2 - 1,
					maxX - minX - this.dimension / 2 - 1, maxY - minY - this.dimension / 2 - 1);
		}
		if (showPoints) {
			g.setColor(color.red);
			g.fillRect(minX - 4, minY - 4 + (height / 2), 8, 8);
			g.fillRect(maxX - 4, minY - 4 + (height / 2), 8, 8);
			g.fillRect(minX - 4 + (width / 2), minY - 4, 8, 8);
			g.fillRect(minX - 4 + (width / 2), maxY - 4, 8, 8);
			g.fillRect(minX - 4 + (width / 2), minY - 4 + (height / 2), 8, 8);
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
	public boolean checkSelected(Point p) {
		int minX = Math.min(root.x, second.x);
		int minY = Math.min(root.y, second.y);
		int maxX = Math.max(root.x, second.x);
		int maxY = Math.max(root.y, second.y);

		int width = maxX - minX;
		int height = maxY - minY;
		Ellipse2D check = new Ellipse2D.Double(minX, minY, width, height);
		return check.intersects(p.x - 2, p.y - 2, 4, 4) && !check.contains(p.x - 2, p.y - 2, 4, 4); // for case
	}

	@Override
	public boolean selectCenter(Point p) {
		int minX = Math.min(root.x, second.x);
		int minY = Math.min(root.y, second.y);
		int maxX = Math.max(root.x, second.x);
		int maxY = Math.max(root.y, second.y);

		int width = maxX - minX;
		int height = maxY - minY;
		if (p.x >= (minX + (width / 2) - 5) && p.x <= (minX + (width / 2) + 5) && p.y >= -5 + minY + (height / 2)
				&& p.y <= (minY + 5 + (height / 2)))
			setCenter(true);
		return true;
	}

	@Override
	public void moveByCenter(Point p, Point dragged) {
		int minX = Math.min(root.x, second.x);
		int minY = Math.min(root.y, second.y);
		int maxX = Math.max(root.x, second.x);
		int maxY = Math.max(root.y, second.y);
		int width = maxX - minX;
		int height = maxY - minY;
		if (p.getX() >= minX - 3 + (width / 2) && p.getX() <= minX + 3 + (width / 2) && p.getY() >= minY - 3
				&& p.getY() <= minY + 3)
			setNorth(true);// 2
		// else
		// if(p.getX()>=maxX-3&&p.getX()<=maxX+3&&p.getY()>=minY-3&&p.getY()<=minY+3)
		// return true; // 3
		else if (p.getX() >= minX - 3 && p.getX() <= minX + 3 && p.getY() >= minY - 3 + (height / 2)
				&& p.getY() <= minY + 3 + (height / 2))
			setWest(true);// 4
		// else
		// if(p.getX()>=minX-3&&p.getX()<=minX+3&&p.getY()>=maxY-3&&p.getY()<=maxY+3)
		// return true;//7

		else if (p.getX() >= minX - 3 + (width / 2) && p.getX() <= minX + 3 + (width / 2) && p.getY() >= maxY - 3
				&& p.getY() <= maxY + 3)
			setSouth(true);// 8
		else if (p.getX() >= maxX - 3 && p.getX() <= maxX + 3 && p.getY() >= minY - 3 + (height / 2)
				&& p.getY() <= minY + 3 + (height / 2))
			setEast(true);// 6
		// else if(p.getX()>=maxX-3&&p.getX()<=m
		if (center) {
			this.root.translate((int) (dragged.getX() - p.getX()), (int) (dragged.getY() - p.getY()));
			this.second.translate((int) (dragged.getX() - p.getX()), (int) (dragged.getY() - p.getY()));
		}
		if (west)
			root.setLocation(root.x + (p.x - root.x), root.y); // 4

		else if (north)
			root.setLocation(root.x, root.y + (p.y - root.y));// 2
		else if (south)
			second.setLocation(second.x, second.y + (p.y - second.y));// 8
		else if (east)
			second.setLocation(second.x + (p.x - second.x), second.y);// 6

//	}
	}

	@Override
	public void setLocationOfAShape(Point p) {
		int minX = Math.min(root.x, second.x);
		int minY = Math.min(root.y, second.y);
		int maxX = Math.max(root.x, second.x);
		int maxY = Math.max(root.y, second.y);
		int width = maxX - minX;
		int height = maxY - minY;
		int newRootx = p.x - root.x;
		int newRooty = p.y - root.y;

		root.setLocation(root.x + newRootx - (width / 2), root.y + newRooty - (height / 2));
		second.setLocation(second.x + newRootx - (width / 2), second.y + newRooty - (height / 2));

	}

	public boolean isNorth() {
		return north;
	}

	public void setNorth(boolean north) {
		this.north = north;
	}

	public boolean isEast() {
		return east;
	}

	public void setEast(boolean east) {
		this.east = east;
	}

	public boolean isWest() {
		return west;
	}

	public void setWest(boolean west) {
		this.west = west;
	}

	public boolean isSouth() {
		return south;
	}

	public void setSouth(boolean south) {
		this.south = south;
	}

	public void setCenter(boolean center) {
		this.center = center;
	}

	@Override
	public void setRelease() {
		setEast(false);
		setWest(false);
		setNorth(false);
		setSouth(false);
		setCenter(false);
	}

	@Override
	public boolean fillAShape(Point p) {
		int minX = Math.min(root.x, second.x);
		int minY = Math.min(root.y, second.y);
		int maxX = Math.max(root.x, second.x);
		int maxY = Math.max(root.y, second.y);

		int width = maxX - minX;
		int height = maxY - minY;
		Ellipse2D check = new Ellipse2D.Double(minX, minY, width, height);
		if (check.intersects(p.x - 2, p.y - 2, 4, 4))
			setFill(true);
		return check.intersects(p.x - 2, p.y - 2, 4, 4);
	}

	@Override
	public String getTypeShape() {
		// TODO Auto-generated method stub
		return null;
	}


}
