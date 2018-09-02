package com.game1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	Image image;
	double x,y;
	int speed;
	int width,height;
	public void drawSelf(Graphics g) {
		g.drawImage(image, (int)x,(int) y, null);
	}
	public GameObject(Image image, double x, double y) {
		super();
		this.image = image;
		this.x = x;
		this.y = y;
	}
	public GameObject() {
		
	}
	public Rectangle getRectanle() {
		return new Rectangle((int)x, (int)y, width, height);
	}
}
