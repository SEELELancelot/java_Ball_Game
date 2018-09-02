package com.game1;

import java.awt.Graphics;

public class Ball {
	private float x;
	private float y;
	private float width;
	private float height;
	private float degree;
	public Ball(float x,float y,float width,float height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		degree=(int) (Math.random()*Math.PI*2);
	}
	public void draw_Self(Graphics g) {
		g.fillOval((int)x, (int)y, (int)width, (int)height);
		x+=3*Math.cos(degree);
		y+=3*Math.sin(degree);
		if(x<0||x>500) {
			degree=(int)Math.PI-degree;
		}
		if(y<0||y>400) {
			degree=-degree;
		}
	}
}
