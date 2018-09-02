package com.game1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import com.game1.Game.KeyMonitor;

public class Plane extends GameObject {
	int speed=5;
	boolean left;
	boolean right;
	boolean top;
	boolean down;
	public Plane(Image img,double x, double y) {
		image=img;
		this.x=x;
		this.y=y;
	}

	public void drawSelf(Graphics g) {
		g.drawImage(image, (int)x,(int) y, null);
		
	}
	public void move() {
		if(top) {
			y-=speed;
		}
		if(down) {
			y+=speed;
		}
		if(left) {
			x-=speed;
		}
		if(right) {
			x+=speed;
		}
	}
	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			top=true;
			break;
		case KeyEvent.VK_DOWN:
			down=true;
			break;
		case KeyEvent.VK_LEFT:
			left=true;
			break;
		case KeyEvent.VK_RIGHT:
			right=true;
			break;
		default:
			break;
		}
	}
		public void minusDirection(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				top=false;
				break;
			case KeyEvent.VK_DOWN:
				down=false;
				break;
			case KeyEvent.VK_LEFT:
				left=false;
				break;
			case KeyEvent.VK_RIGHT:
				right=false;
				break;
			default:
				break;
			}
	}
}
