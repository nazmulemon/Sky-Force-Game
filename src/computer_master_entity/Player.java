package computer_master_entity;


import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import computer_master_bullets.Bullet;
import computer_master_display.Display;
import computer_master_graphics.loadImage;
import computer_master_manager.gameManager;

public class Player implements KeyListener{
	
	private int x;
	private int y;
	private boolean left,right;
	private boolean fire;
	private long current;
	private long delay;
	private int health;
	
	public Player(int x,int y){
		this.x=x;
		this.y=y;
	}
	
    public void init(){
		Display.frame.addKeyListener(this);
		current=System.nanoTime();
		delay=100;
		health=3;
	}
	public void tick(){
		if(!(health<=0)){
			if(left){
				if(x>=50){
					x-=4;	
				}
			}
			if(right){
				if(x<=450-60){
					x+=4;
				}
			}
			if(fire){
				long breaks=(System.nanoTime()-current)/1000000;
				if(breaks > delay){
					gameManager.bullet.add(new Bullet(x+30,y));
				}
				current=System.nanoTime();
			}
		}
		
	}
	public void render(Graphics g){
		if(!(health<=0)){
			g.drawImage(loadImage.player,x, y, 60, 60,null);
		}
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int source=e.getKeyCode();
		if(source==KeyEvent.VK_LEFT){
			left=true;
		}
		if(source==KeyEvent.VK_RIGHT){
			right=true;
		}
		if(source==KeyEvent.VK_B){
			fire=true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int source=e.getKeyCode();
		if(source==KeyEvent.VK_LEFT){
			left=false;
		}
		if(source==KeyEvent.VK_RIGHT){
			right=false;
		}
		if(source==KeyEvent.VK_B){
			fire=false;
		}
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	

}
