package me.Josh123likeme.RoverGame.UI;

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import me.Josh123likeme.RoverGame.Main;
import me.Josh123likeme.RoverGame.UI.Panes.CMD_PANE;
import me.Josh123likeme.RoverGame.UI.Panes.Pane;

public class UIManager {

	private final int paneHeaderHeight = 20;
	private final int paneBorderThickness = 5;
	
	//this is the pixel width of the hitbox for the stretching portions of the pane
	private final int stretchBoundryThickness = 10;
	
	private final int buttonWidth = 15;
	
	private List<Pane> panes = new ArrayList<Pane>();
	
	private Pane grabbedPane;
	private int grabbedOffsetX;
	private int grabbedOffsetY;
	
	private Pane stretchedPane;
	
	public UIManager() {
		
		panes.add(new CMD_PANE());
		
	}
	
	public void update() {
		
		int mx = Main.game.mouseWitness.getMouseX();
		int my = Main.game.mouseWitness.getMouseY();
		
		//clicking pane buttons check
		
		if (Main.game.mouseWitness.isLeftClicked()) {
			
			for (Pane pane : panes) {
				
				//green button
				if (Math.sqrt(Math.pow(mx - (pane.getX() + pane.getWidth() + paneBorderThickness - 2.5 * buttonWidth), 2) +
						Math.pow(my - (pane.getY() - paneHeaderHeight / 2), 2)) < (double) buttonWidth / 2) {
					
					System.out.println("Green button");
					
				}
				//yellow button
				else if (Math.sqrt(Math.pow(mx - (pane.getX() + pane.getWidth() + paneBorderThickness - 1.5 * buttonWidth), 2) +
						Math.pow(my - (pane.getY() - paneHeaderHeight / 2), 2)) < (double) buttonWidth / 2) {
					
					System.out.println("Yellow button");
					
				}
				//red button
				else if (Math.sqrt(Math.pow(mx - (pane.getX() + pane.getWidth() + paneBorderThickness - 0.5 * buttonWidth), 2) +
						Math.pow(my - (pane.getY() - paneHeaderHeight / 2), 2)) < (double) buttonWidth / 2) {
					
					System.out.println("Red button");
					
					pane.close();
					
				}
				
			}
			
		}
		
		//moving panes check
		
		//checking for grabbing a pane
		if (Main.game.mouseWitness.isLeftClicked()) {
			
			if (grabbedPane == null) {
				
				for (Pane pane : panes) {
					
					if (mx < pane.getX() - paneBorderThickness) continue;
					if (mx > pane.getX() + pane.getWidth() + paneBorderThickness) continue;
					if (my < pane.getY() - paneHeaderHeight) continue;
					if (my > pane.getY()) continue;
					
					grabbedOffsetX = mx - pane.getX();
					grabbedOffsetY = my - pane.getY();
					
					grabbedPane = pane;
					
					break;
					
				}
				
			}
			
		}
		
		if (Main.game.mouseWitness.isDragging()) {
			
			//check for dragging pane
			if (grabbedPane != null) {
				
				grabbedPane.setX(mx - grabbedOffsetX);
				grabbedPane.setY(my - grabbedOffsetY);
				
			}
			
		}
		//check for dropping pane
		else if (grabbedPane != null) {
			
			grabbedPane = null;
			
		}
		
		//stretched panes check
		
		if (Main.game.mouseWitness.isLeftClicked()) {
			
			//checking for starting to stretch a pane
			if (stretchedPane == null) {
				
				for (Pane pane : panes) {
					
					if (mx < pane.getX() + pane.getWidth() + paneBorderThickness - stretchBoundryThickness) continue;
					if (mx > pane.getX() + pane.getWidth() + paneBorderThickness) continue;
					if (my < pane.getY() + pane.getHeight() + paneBorderThickness - stretchBoundryThickness) continue;
					if (my > pane.getY() + pane.getHeight() + paneBorderThickness) continue;
					
					stretchedPane = pane;
					
					break;
					
				}
				
			}
			
		}
		
		if (Main.game.mouseWitness.isDragging()) {
			
			//check for dragging pane
			if (stretchedPane != null) {
				
				stretchedPane.setWidth(mx - stretchedPane.getX());
				stretchedPane.setHeight(my - stretchedPane.getY());
				
			}
			
		}
		//check for dropping pane
		else if (stretchedPane != null) {
			
			stretchedPane = null;
			
		}
		
		//removing dead panes
		for (int i = 0; i < panes.size(); i++) {
			
			if (panes.get(i).isDead()) panes.remove(i);
			
		}
		
	}
	
	public void render(Graphics g) {
		
		for (Pane pane : panes) {
			
			//pane border
			g.setColor(Color.gray);
			g.fillRoundRect(pane.getX() - paneBorderThickness,
					pane.getY() - paneHeaderHeight,
					pane.getWidth() + 2 * paneBorderThickness,
					pane.getHeight() + paneHeaderHeight + paneBorderThickness,
					10, 10);
			
			//pane text
			g.setColor(Color.black);
			g.drawString(pane.getName(), pane.getX() - paneBorderThickness + 5, pane.getY() - 5);
			
			//pane red button
			g.setColor(Color.red);
			g.fillOval(pane.getX() + pane.getWidth() + paneBorderThickness - buttonWidth, pane.getY() - 15, 10, 10);
			
			//pane yellow button
			g.setColor(Color.yellow);
			g.fillOval(pane.getX() + pane.getWidth() + paneBorderThickness - 2 * buttonWidth, pane.getY() - 15, 10, 10);
			
			//pane green button
			g.setColor(Color.green);
			g.fillOval(pane.getX() + pane.getWidth() + paneBorderThickness - 3 * buttonWidth, pane.getY() - 15, 10, 10);
			
			//this is in case the pane has no content
			g.setColor(Color.darkGray);
			
			g.fillRect(pane.getX(), pane.getY(), pane.getWidth(), pane.getHeight());
			
			pane.render(g);
			
		}
		
	}
	
}
