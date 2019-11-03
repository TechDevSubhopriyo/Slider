package Slider;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Gameplay extends JPanel implements KeyListener, ActionListener{

	private boolean play=false;
	private Timer timer;
	private int delay = 8;
	private int player1Y = 310;
	private int player2Y = 310;
	private int ballposX = 120;
	private int ballposY = 350;
	private int ballXdir = -2;
	private int ballYdir = -1;
	private int win=100000,win1=100000;
	//private MapGenerator map;
	
	public Gameplay() {
		//map=new MapGenerator();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start(); 
	}
	
	public void paint(Graphics g) {
		// background
		g.setColor(Color.black);
		g.fillRect(1,1,800,600);
		
		g.setColor(Color.YELLOW);
		g.drawString("PLAYER 1 WINS THE GAME", win, win);
		g.setColor(Color.YELLOW);
		g.drawString("PLAYER 2 WINS THE GAME", win1, win1);

		// border
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 800);
		g.fillRect(800, 0, 3, 800);
		g.fillRect(0, 600, 800, 3);
		// the paddle
		g.setColor(Color.green);
		g.fillRect(20,player1Y, 8, 100);
		g.fillRect(780,player2Y, 8,100);
		
		// ball
		g.setColor(Color.yellow);
		g.fillOval(ballposX, ballposY, 20, 20);
		g.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play) {
			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(20,player1Y,8,100))) {
				ballXdir=-ballXdir;
			}
			else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(780,player2Y,8,100))) {
				ballXdir=-ballXdir;
			}
			ballposX+=ballXdir;
			ballposY+=ballYdir;
			if(ballposY<0) {
				ballYdir=-ballYdir;
			}
			if(ballposY>560) {
				ballYdir=-ballYdir;
			}
			if(ballposX>800)
			{
				win=300;
			}
			if(ballposX<-5)
			{
				win1=300;
			}
			}	
			repaint();
				}
			
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			if(player1Y<1)
				player1Y=0;
			else
				moveUp1();
		}
        if(e.getKeyCode()==KeyEvent.VK_DOWN) {
        	if(player1Y>479)
				player1Y=480;
			else
				moveDown1();
		}
        if(e.getKeyChar()=='w')
        {
        	if(player2Y<1)
				player2Y=0;
			else
				moveUp2();
        }
        if(e.getKeyChar()=='s')
        {
        	if(player2Y>479)
				player2Y=480;
			else
				moveDown2();
        }
	}
	public void moveUp2()
	{
		play=true;
		player2Y-=20;
	}
	public void moveUp1()
	{
		play=true;
		player1Y-=20;
	}
	public void moveDown1()
	{
		play=true;
		player1Y+=20;
	}
	public void moveDown2()
	{
		play=true;
		player2Y+=20;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
