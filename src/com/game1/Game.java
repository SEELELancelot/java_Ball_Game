package com.game1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Game extends JFrame {
	Image GreatBall=GameUtil.getImage("images/Great_Ball.png");
	Plane plane1=new Plane(GreatBall,150,100);
	Plane plane2=new Plane(GreatBall,250,50);
	Plane plane3=new Plane(GreatBall,0,0);
	
	Ball ball=new Ball(100, 100, 30,30);
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLUE);
		g.setFont(new Font("", Font.BOLD, 32));
		g.drawLine(100, 100, 300, 300);
		g.setColor(Color.RED);
		g.drawString("我是熟", 50, 132);
		
		plane1.drawSelf(g);
		ball.draw_Self(g);
	}
	class PaintThread extends Thread{
		@Override
		public void run() {
			super.run();
			while(true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			plane1.addDirection(e);
			plane1.move();
			super.keyPressed(e);
		
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyReleased(e);
			plane1.minusDirection(e);
		}
		
	}
	public void lannuchGame() {
		setTitle("遊戲一");
		setSize(500, 400);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			} 
		});
		new PaintThread().start();
		addKeyListener(new KeyMonitor());
	}
	public static void main(String[] args) {
		Game game1=new Game();
		game1.lannuchGame();
	}
}
