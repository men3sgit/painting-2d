package com.menes.project.painting.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circle extends AShape {
	private int radius;
	boolean north = false;
	boolean east = false;
	boolean west = false;
	boolean south = false;
	boolean center = false;

	public Circle(Point p, Color color, int d) {
		super(p, color, d);
		this.radius = 0;
	}

	@Override
	public void draw(Graphics g) {
		this.radius = (int) Math
				.sqrt(Math.abs((root.x - second.x) * (root.x - second.x)) + (root.y - second.y) * (root.y - second.y));
		g.setColor(color);
		g.drawOval(root.x - radius, root.y - radius, radius * 2, radius * 2);
		if (fill) {
			g.setColor(colorFill);
			g.fillOval(root.x - radius, root.y - radius, radius * 2, radius * 2);
		}
		if (showPoints) {
			g.setColor(Color.red);
			g.fillOval(root.x - 4, root.y, 8, 8);
			g.fillRect(root.x - 4 - radius, root.y, 8, 8);
			g.fillRect(root.x - 4, root.y + radius - 4, 8, 8);
			g.fillRect(root.x - 4, root.y - 4 - radius, 8, 8);
			g.fillRect(root.x - 4 + radius, root.y, 8, 8);

		}

	}

	@Override
	public void setColor(Color c) {
		// TODO Auto-generated method stub

	}

	@Override
	public String comment() {
		return "Radius: " + this.radius + " with thickness: " + (this.dimension + 2);

	}

	public boolean checkSelected(Point p) {
		int fx = (int) root.getX();
		int fy = (int) root.getY();

		return (radius >= (int) Math.sqrt((p.getX() - fx) * (p.getX() - fx) + (p.getY() - fy) * (p.getY() - fy)) - 2)
				&& (radius <= (int) Math.sqrt((p.getX() - fx) * (p.getX() - fx) + (p.getY() - fy) * (p.getY() - fy))
						+ 2);
	}

	public void setShowPoints(boolean b) {
		this.showPoints = b;
	}

	public void moveByCenter(Point p, Point dragged) {
		if (center) {
			this.root.translate((int) (dragged.getX() - p.getX()), (int) (dragged.getY() - p.getY()));
			this.second.translate((int) (dragged.getX() - p.getX()), (int) (dragged.getY() - p.getY()));
		}
		if ((p.x >= root.x - 5 && p.x <= root.x + 5) && (p.y >= root.y - radius - 5) && (p.y <= root.y - radius + 5))
			setNorth(true);
		;// north
		if ((p.x >= root.x - 5 + radius && p.x <= root.x + 5 + radius) && (p.y >= root.y - 5) && (p.y <= root.y + 5))
			setEast(true); // east
		if ((p.x >= root.x - 5 - radius && p.x <= root.x + 5 - radius) && (p.y >= root.y - 5) && (p.y <= root.y + 5))
			setWest(true);
		;// west
		if ((p.x >= root.x - 5 && p.x <= root.x + 5) && (p.y >= root.y + radius - 5) && (p.y <= root.y + radius + 5))
			setSouth(true);
		;// south

		if (north || east || west || south)
			setSecondPoint(dragged);

	}

	public boolean selectCenter(Point p) {
		int fx = (int) root.getX();
		int fy = (int) root.getY();

		if (p.x >= (fx - 5) && (p.x <= (fx + 5)) && (p.y >= fy - 5) && (p.y <= fy + 5))
			setCenter(true);
		return true;
	}

	public boolean getShowPoints() {
		return this.showPoints;
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
	public void setLocationOfAShape(Point p) {

		int x1 = (second.x - root.x);
		int y1 = (second.y - root.y);

		second.setLocation(p.x + x1, p.y + y1);
		root.setLocation(p);
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

	public boolean isCenter() {
		return center;
	}

	public void setCenter(boolean center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public boolean fillAShape(Point p) {
		int fx = (int) root.getX();
		int fy = (int) root.getY();
		if (radius >= (int) (Math.sqrt((p.getX() - fx) * (p.getX() - fx) + (p.getY() - fy) * (p.getY() - fy)) - 2))
			setFill(true);
		return radius >= (int) (Math.sqrt((p.getX() - fx) * (p.getX() - fx) + (p.getY() - fy) * (p.getY() - fy)) - 2);
	}

	@Override
	public String getTypeShape() {
		// TODO Auto-generated method stub
		return "Circle";
	}


}
