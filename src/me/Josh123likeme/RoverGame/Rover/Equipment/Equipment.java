package me.Josh123likeme.RoverGame.Rover.Equipment;

import me.Josh123likeme.RoverGame.Rover.IHaveIdentity;
import me.Josh123likeme.RoverGame.Rover.Rover;

public abstract class Equipment implements IHaveIdentity {

	protected Rover rover;
	
	public abstract String getStatus();
	
	public abstract int getSlotSize();
	
	public Equipment(Rover rover) {
		
		this.rover = rover;
		
	}
	
}
