package me.Josh123likeme.RoverGame.UI.Panes;

import java.awt.Graphics;
import java.awt.Color;

public class CMD_PANE extends Pane {

	@Override
	public String getName() {
		return "cmd";
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(new Color(32, 32, 32));
		
		g.fillRect(x, y, width, height);
		
		g.setColor(Color.white);
		
		g.drawString("CMD WINDOW", x + 10, y + 20);
		
	}
	
}
