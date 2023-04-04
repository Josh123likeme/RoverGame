package me.Josh123likeme.RoverGame.UI.Panes;

import java.awt.Graphics;

public abstract class Pane {
	
	private boolean alive = true;
	
	protected int x = 50;
	protected int y = 50;
	
	protected int width = 400;
	protected int height = 400;
	
	public abstract String getName();
	
	public abstract void render(Graphics g);
	
	public void close() {
		
		
		alive = false;
		
	}
	
	public boolean isDead() {
		
		return !alive;
		
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
	
	public int getWidth() {
		
		return width;
		
	}
	
	public void setWidth(int width) {
		
		this.width = width;
		
	}
	
	public int getHeight() {
		
		return height;
		
	}
	
	public void setHeight(int height) {
		
		this.height = height;
		
	}
	
}
