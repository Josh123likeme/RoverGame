package me.Josh123likeme.RoverGame.Rover;

import me.Josh123likeme.RoverGame.*;
import me.Josh123likeme.RoverGame.Rover.Body.*;
import me.Josh123likeme.RoverGame.Rover.Equipment.*;
import me.Josh123likeme.RoverGame.Rover.MovementType.*;

public class Rover {

	private Body body;
	private MovementType movementType;
	
	public Rover(Body body, MovementType movementType) {
		
		this.body = body;
		this.movementType = movementType;
		
	}
	
	public void update() {
		
		//calculate power draw / gain for this frame
		double powerChange = 0;
		
		for (Equipment equipment : body.getAllEquipment()) {
			
			if (!(equipment instanceof IAffectPower)) continue;
			
			powerChange += Main.game.getDeltaFrame() * 1/3600 * ((IAffectPower) equipment).getPowerChange();
			
		}
		
		//get sum of max charge
		double sumOfMaxCharge = 0;
		
		for (Equipment equipment : body.getAllEquipment()) {
			
			if (!(equipment instanceof IBattery)) continue;
			
			sumOfMaxCharge += ((IBattery) equipment).getMaxCharge();
			
		}
		
		//this is terrible
		//distribute load evenly
		double balance = powerChange / sumOfMaxCharge;
		
		for (Equipment equipment : body.getAllEquipment()) {
			
			if (!(equipment instanceof IBattery)) continue;
			
			((IBattery) equipment).charge(((IBattery) equipment).getMaxCharge() * balance);
			
		}
		
		//update equipment
		for (Equipment equipment : body.getAllEquipment()) {
			
			if (!(equipment instanceof IRequireUpdating)) continue;
			
			((IRequireUpdating) equipment).update();
			
		}
		
		//temp print status
		for (Equipment equipment : body.getAllEquipment()) {
			
			if (equipment == null) continue;
			
			//System.out.println(equipment.getStatus());
			
		}
		
	}
	
}
