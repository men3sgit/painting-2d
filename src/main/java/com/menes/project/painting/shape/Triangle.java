package com.menes.project.painting.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Line2D;

public class Triangle extends AShape {

	boolean top = false;
	boolean center = false;
	boolean left = false;
	boolean right = false;

	public Triangle(Point p, Color color, int d) {
		super(p, color, d);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		int maxX = Math.max(root.x, second.x);
		int maxY = Math.max(root.y, second.y);
		int minX = Math.min(root.x, second.x);
		int minY = Math.min(root.y, second.y);

		int width = maxX - minX;
		int height = maxY - minY;

		int[] x = { minX, (maxX + minX) / 2, maxX };
		int[] y = { maxY, minY, maxY };
		g.drawPolygon(x, y, 3);

		if (fill) {
			g.fillPolygon(x, y, 3);
		}
		if (showPoints) {
			g.setColor(Color.black.red);
			g.fillRect(minX - 4 + (width / 2), minY - 4, 8, 8);// 2
			g.fillRect(minX - 4 + (width / 2), minY - 4 + (height * 2 / 3), 8, 8);// 5
			g.fillRect(minX - 4, maxY - 4, 8, 8);// 7
			g.fillRect(maxX - 4, maxY - 4, 8, 8);// 9
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

		int maxX = Math.max(root.x, second.x);
		int maxY = Math.max(root.y, second.y);
		int minX = Math.min(root.x, second.x);
		int minY = Math.min(root.y, second.y);

		int width = maxX - minX;
		int height = maxY - minY;

		Line2D left = new Line2D.Double(minX, maxY, (maxX + minX) / 2, minY);
		Line2D right = new Line2D.Double((maxX + minX) / 2, minY, maxX, maxY);
		Line2D bottom = new Line2D.Double(minX, maxY, maxX, maxY);

		if (left.intersects(p.x - 2, p.y - 2, 4, 4))
			return true;
		else if (right.intersects(p.x - 2, p.y - 2, 4, 4))
			return true;
		else if (bottom.intersects(p.x - 2, p.y - 2, 4, 4))
			return true;

		return false;
	}

	@Override
	public boolean selectCenter(Point p) {
		int maxX = Math.max(root.x, second.x);
		int maxY = Math.max(root.y, second.y);
		int minX = Math.min(root.x, second.x);
		int minY = Math.min(root.y, second.y);

		int width = maxX - minX;
		int height = maxY - minY;

		if (p.x >= (minX + (width / 2) - 5) && p.x <= (minX + (width / 2) + 5) && p.y >= -5 + minY + (height * 2 / 3)
				&& p.y <= (minY + 5 + (height * 2 / 3)))
			setCenter(true);
		return true;
	}

	@Override
	public void moveByCenter(Point p, Point dragged) {

		int maxX = Math.max(root.x, second.x);
		int maxY = Math.max(root.y, second.y);
		int minX = Math.min(root.x, second.x);
		int minY = Math.min(root.y, second.y);

		int width = maxX - minX;
		int height = maxY - minY;

		if (center) {
			this.root.translate((int) (dragged.getX() - p.getX()), (int) (dragged.getY() - p.getY()));
			this.second.translate((int) (dragged.getX() - p.getX()), (int) (dragged.getY() - p.getY()));
		}
		if (p.getX() >= minX - 3 && p.getX() <= minX + 3 && p.getY() >= maxY - 3 && p.getY() <= maxY + 3)
			setLeft(true);// 7
		else if (p.getX() >= minX - 3 + (width / 2) && p.getX() <= minX + 3 + (width / 2) && p.getY() >= minY - 3
				&& p.getY() <= minY + 3)
			setTop(true);// 2
		else if (p.getX() >= maxX - 3 && p.getX() <= maxX + 3 && p.getY() >= maxY - 3 && p.getY() <= maxY + 3)
			setRight(true);// 9

		if (top)
			root.setLocation(root.x, root.y + (p.y - root.y));// 2
		else if (right)
			second.setLocation(p);// 9
		else if (left) { // 7
			root.setLocation(root.x + (p.x - root.x), root.y);
			second.setLocation(second.x, second.y + (p.y - second.y));
		}

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

		root.setLocation(root.x + newRootx - (width / 2), root.y + newRooty - (height * 2 / 3));
		second.setLocation(second.x + newRootx - (width / 2), second.y + newRooty - (height * 2 / 3));

	}

	@Override
	public void setRelease() {
		setCenter(false);
		setRight(false);
		setLeft(false);
		setTop(false);

	}

	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

	public boolean isCenter() {
		return center;
	}

	public void setCenter(boolean center) {
		this.center = center;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	@Override
	public boolean fillAShape(Point p) {

		int maxX = Math.max(root.x, second.x);
		int maxY = Math.max(root.y, second.y);
		int minX = Math.min(root.x, second.x);
		int minY = Math.min(root.y, second.y);

		Line2D left = new Line2D.Double(minX, maxY, (maxX + minX) / 2, minY);
		Line2D right = new Line2D.Double((maxX + minX) / 2, minY, maxX, maxY);
		Line2D bottom = new Line2D.Double(minX, maxY, maxX, maxY);

		if (left.intersects(p.x - 2, p.y - 2, 4, 4))
			return true;
		else if (right.intersects(p.x - 2, p.y - 2, 4, 4))
			return true;
		else if (bottom.intersects(p.x - 2, p.y - 2, 4, 4))
			return true;
		return false;
	}

	@Override
	public String getTypeShape() {
		// TODO Auto-generated method stub
		return null;
	}


}
