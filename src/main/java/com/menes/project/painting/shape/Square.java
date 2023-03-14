package com.menes.project.painting.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

public class Square extends AShape {
	int x;
	int y;
	int edge;
	boolean s1 = false;
	boolean s3 = false;
	boolean s5 = false;
	boolean s7 = false;
	boolean s9 = false;

	public Square(Point p, Color color, int d) {
		super(p, color, d);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		edge = Math.max(Math.abs(root.x - second.x), Math.abs(root.y - second.y));
		if (second.x < root.x && second.y < root.y) {// 2
			x = root.x - edge;
			y = root.y - edge;
		} else if (second.x < root.x && second.y > root.y) {// 3
			x = root.x - edge;
			y = root.y;
		} else if (second.x > root.x && second.y < root.y) {// 4
			x = root.x;
			y = root.y - edge;
		} else {// 1
			x = Math.min(second.x, root.x);
			y = Math.min(second.x, root.y);
		}

		g.setColor(color);
		g.drawRect(x, y, edge, edge);

		if (fill) {
			g.setColor(colorFill);
			g.fillRect(x, y, edge, edge);
		}
		if (showPoints) {
			g.setColor(Color.red);
			g.fillOval(x - 4 + edge / 2, y - 4 + edge / 2, 8, 8);// 5
//			g.setColor(Color.red);
//			g.fillRect(x-2, y-2, 4, 4);//1
//			g.fillRect(x-2+edge, y-2, 4, 4);//3
//			
//			g.fillRect(x-2, y-2+edge, 4, 4);//7
//			g.fillRect(x-2+edge, y-2+edge, 4, 4);//9

		}
	}

	@Override
	public void setColor(Color c) {
		// TODO Auto-generated method stub

	}

	@Override
	public String comment() {
		return "Edge: " + edge;
	}

	@Override
	public boolean checkSelected(Point p) {
		Rectangle2D check = new Rectangle2D.Double(x, y, edge, edge);
		return check.intersects(p.x - 2, p.y - 2, 4, 4);
	}

	@Override
	public boolean selectCenter(Point p) {
		if (p.x >= x + edge / 2 - 2 && p.x <= x + edge / 2 + 2 && p.y >= y + edge / 2 - 2 && p.y <= y + edge / 2 + 2) {
			setS5(true);
		}
		return true;
	}

	@Override
	public void moveByCenter(Point p, Point dragged) {
		if (s5) {
			this.root.translate((int) (dragged.getX() - p.getX()), (int) (dragged.getY() - p.getY()));
			this.second.translate((int) (dragged.getX() - p.getX()), (int) (dragged.getY() - p.getY()));
		}
//		else if (p.getX() >= x - 3 && p.getX() <= x + 3 && p.getY() >= x - 3 && p.getY() <= x + 3)
//			setS1(true); // 1
//		else if (p.getX() >= x+edge - 3 && p.getX() <= x+edge + 3 && p.getY() >= y - 3 && p.getY() <= y + 3)
//			setS3(true); // 3
//		else if (p.getX() >= x- 3 && p.getX() <= x + 3 && p.getY() >= y+edge - 3 && p.getY() <= y+edge + 3)
//			setS7(true);// 7
//		else if (p.getX() >= x+edge - 3 && p.getX() <= x+edge + 3 && p.getY() >= y+edge - 3 && p.getY() <= y+edge + 3)
//			setS9(true);// 9
//		
//		
//		else if (s1)
//			root = dragged; // 1
//		else if (s3) { // 3
//			root.setLocation(root.x, root.y + (dragged.y - root.y));
//			second.setLocation(second.x + (dragged.x - second.x), second.y);
//		}
//		else if (s7) { // 7
//			root.setLocation(root.x + (p.x - root.x), root.y);
//			second.setLocation(second.x, second.y + (p.y - second.y));
//		}
//		else if (s9)
//			second.setLocation(p);// 9

	}

	@Override
	public void setRelease() {
		setS1(false);
		setS7(false);
		setS3(false);
		setS9(false);
		setS5(false);

	}

	@Override
	public void setLocationOfAShape(Point p) {
		int secondX = second.x - root.x;
		int secondY = second.y - root.y;
		root.setLocation(p.x - edge / 2, p.y - edge / 2);
		second.setLocation(p.x + secondX - edge / 2, p.y + secondY - edge / 2);
	}

	public boolean isS1() {
		return s1;
	}

	public void setS1(boolean s1) {
		this.s1 = s1;
	}

	public boolean isS3() {
		return s3;
	}

	public void setS3(boolean s3) {
		this.s3 = s3;
	}

	public boolean isS5() {
		return s5;
	}

	public void setS5(boolean s5) {
		this.s5 = s5;
	}

	public boolean isS7() {
		return s7;
	}

	public void setS7(boolean s7) {
		this.s7 = s7;
	}

	public boolean isS9() {
		return s9;
	}

	public void setS9(boolean s9) {
		this.s9 = s9;
	}

	@Override
	public boolean fillAShape(Point p) {
		Rectangle2D check = new Rectangle2D.Double(x, y, edge, edge);
		if (check.intersects(p.x - 2, p.y - 2, 4, 4))
			setFill(true);
		return check.intersects(p.x - 2, p.y - 2, 4, 4);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getEdge() {
		return edge;
	}

	public void setEdge(int edge) {
		this.edge = edge;
	}

	@Override
	public String getTypeShape() {
		// TODO Auto-generated method stub
		return null;
	}


}
