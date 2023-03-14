package com.menes.project.painting.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

public class Rectangle extends AShape {
	boolean s1 = false;
	boolean s2 = false;
	boolean s3 = false;
	boolean s4 = false;
	boolean s5 = false;
	boolean s6 = false;
	boolean s7 = false;
	boolean s8 = false;
	boolean s9 = false;

	public Rectangle(Point p, Color color, int d) {
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
		g.drawRect(minX, minY, maxX - minX, maxY - minY);

		if (fill) {
			g.setColor(colorFill);
			g.fillRect(minX, minY, maxX - minX, maxY - minY);
		}
		if (showPoints) {
			g.setColor(color.red);
			g.fillRect(minX - 4, minY - 4, 8, 8); // 1
			g.fillRect(minX - 4, maxY - 4, 8, 8);// 7
			g.fillRect(minX - 4, minY - 4 + (height / 2), 8, 8);// 4
			g.fillRect(maxX - 4, minY - 4, 8, 8);// 3
			g.fillRect(maxX - 4, maxY - 4, 8, 8);// 9
			g.fillRect(maxX - 4, minY - 4 + (height / 2), 8, 8);// 6
			g.fillRect(minX - 4 + (width / 2), minY - 4, 8, 8);// 2
			g.fillRect(minX - 4 + (width / 2), maxY - 4, 8, 8);// 8
			g.fillRect(minX - 4 + (width / 2), minY - 4 + (height / 2), 8, 8);// 5
		}
	}

	@Override
	public void setColor(Color c) {
		// TODO Auto-generated method stub

	}

	@Override
	public String comment() {
		int minX = Math.min(root.x, second.x);
		int minY = Math.min(root.y, second.y);
		int maxX = Math.max(root.x, second.x);
		int maxY = Math.max(root.y, second.y);

		int width = maxX - minX;
		int height = maxY - minY;
		return "width: " + width+", heigh: " + height +" px";
	}

	@Override
	public boolean checkSelected(Point p) {
		int minX = Math.min(root.x, second.x);
		int minY = Math.min(root.y, second.y);
		int maxX = Math.max(root.x, second.x);
		int maxY = Math.max(root.y, second.y);
		int width = maxX - minX;
		int height = maxY - minY;

		Rectangle2D check = new Rectangle2D.Double(minX, minY, width, height);
		return check.intersects(p.x - 2, p.y - 2, 4, 4) && !check.contains(p.x - 2, p.y - 2, 4, 4);
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
			setS5(true);
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

		if (s5) {
			this.root.translate((int) (dragged.getX() - p.getX()), (int) (dragged.getY() - p.getY()));
			this.second.translate((int) (dragged.getX() - p.getX()), (int) (dragged.getY() - p.getY()));
		}

		else if (p.getX() >= minX - 3 && p.getX() <= minX + 3 && p.getY() >= minY - 3 && p.getY() <= minY + 3)
			setS1(true); // 1
		else if (p.getX() >= minX - 3 + (width / 2) && p.getX() <= minX + 3 + (width / 2) && p.getY() >= minY - 3
				&& p.getY() <= minY + 3)
			setS2(true);// 2
		else if (p.getX() >= maxX - 3 && p.getX() <= maxX + 3 && p.getY() >= minY - 3 && p.getY() <= minY + 3)
			setS3(true); // 3
		else if (p.getX() >= minX - 3 && p.getX() <= minX + 3 && p.getY() >= minY - 3 + (height / 2)
				&& p.getY() <= minY + 3 + (height / 2))
			setS4(true);// 4
		else if (p.getX() >= minX - 3 && p.getX() <= minX + 3 && p.getY() >= maxY - 3 && p.getY() <= maxY + 3)
			setS7(true);// 7

		else if (p.getX() >= minX - 3 + (width / 2) && p.getX() <= minX + 3 + (width / 2) && p.getY() >= maxY - 3
				&& p.getY() <= maxY + 3)
			setS8(true);// 8
		else if (p.getX() >= maxX - 3 && p.getX() <= maxX + 3 && p.getY() >= minY - 3 + (height / 2)
				&& p.getY() <= minY + 3 + (height / 2))
			setS6(true);// 6
		else if (p.getX() >= maxX - 3 && p.getX() <= maxX + 3 && p.getY() >= maxY - 3 && p.getY() <= maxY + 3)
			setS9(true);// 9

		else if (s1)
			root = dragged; // 1

		else if (s4)
			root.setLocation(dragged.getX(), root.y); // 4

		else if (s7) { // 7
			root.setLocation(root.x + (p.x - root.x), root.y);
			second.setLocation(second.x, second.y + (p.y - second.y));
		}

		else if (s3) { // 3
			root.setLocation(root.x, root.y + (dragged.y - root.y));
			second.setLocation(second.x + (dragged.x - second.x), second.y);
		}

		else if (s9)
			second.setLocation(p);// 9

		else if (s5) {
			this.root.translate((int) (dragged.getX() - p.getX()), (int) (dragged.getY() - p.getY()));
			this.second.translate((int) (dragged.getX() - p.getX()), (int) (dragged.getY() - p.getY()));
		} else if (s4)
			root.setLocation(root.x + (p.x - root.x), root.y); // 4

		else if (s2)
			root.setLocation(root.x, root.y + (p.y - root.y));// 2
		else if (s8)
			second.setLocation(second.x, second.y + (p.y - second.y));// 8
		else if (s6)
			second.setLocation(second.x + (p.x - second.x), second.y);// 6

	}

//==================================================================================================================================

//=======================================================================================================================================================
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

	@Override
	public void setRelease() {
		setS1(false);
		setS2(false);
		setS3(false);
		setS4(false);
		setS5(false);
		setS6(false);
		setS7(false);
		setS8(false);
		setS9(false);
	}

	public boolean isS1() {
		return s1;
	}

	public void setS1(boolean s1) {
		this.s1 = s1;
	}

	public boolean isS2() {
		return s2;
	}

	public void setS2(boolean s2) {
		this.s2 = s2;
	}

	public boolean isS3() {
		return s3;
	}

	public void setS3(boolean s3) {
		this.s3 = s3;
	}

	public boolean isS4() {
		return s4;
	}

	public void setS4(boolean s4) {
		this.s4 = s4;
	}

	public boolean isS5() {
		return s5;
	}

	public void setS5(boolean s5) {
		this.s5 = s5;
	}

	public boolean isS6() {
		return s6;
	}

	public void setS6(boolean s6) {
		this.s6 = s6;
	}

	public boolean isS7() {
		return s7;
	}

	public void setS7(boolean s7) {
		this.s7 = s7;
	}

	public boolean isS8() {
		return s8;
	}

	public void setS8(boolean s8) {
		this.s8 = s8;
	}

	public boolean isS9() {
		return s9;
	}

	public void setS9(boolean s9) {
		this.s9 = s9;
	}

	@Override
	public boolean fillAShape(Point p) {
		int minX = Math.min(root.x, second.x);
		int minY = Math.min(root.y, second.y);
		int maxX = Math.max(root.x, second.x);
		int maxY = Math.max(root.y, second.y);

		int width = maxX - minX;
		int height = maxY - minY;
		Rectangle2D check = new Rectangle2D.Double(minX, minY, maxX - minX, maxY - minY);
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
