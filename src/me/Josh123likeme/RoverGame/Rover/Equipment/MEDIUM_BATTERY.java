package me.Josh123likeme.RoverGame.Rover.Equipment;

import me.Josh123likeme.RoverGame.Rover.Rover;

public class MEDIUM_BATTERY extends Equipment implements IRequireUpdating, IBattery {

	private final double maxCharge = 400D;
	private double charge = 50D;
	
	public MEDIUM_BATTERY(Rover rover) {
		super(rover);
	}

	@Override
	public String getName() {
		return "Medium Battery";
	}

	@Override
	public String getDescription() {
		return "A medium weight battery that can hold " + maxCharge + " watt hours of power";
	}

	@Override
	public String getStatus() {
		return "Charge: " + String.format("%.2f", charge / maxCharge * 100) + 
				"% (" + String.format("%.2f", charge) + " / " + String.format("%.2f", maxCharge) + ")";
	}

	@Override
	public void update() {
		
	}

	@Override
	public void charge(double amount) {
		
		charge += amount;
		if (charge > maxCharge) {
			
			charge = maxCharge;
			throw new IllegalArgumentException("Battery has been charged above the max");
			
		}
		else if (charge < 0) {
			
			charge = 0;
			throw new IllegalArgumentException("Battery has been discharged into the negatives");
			
		}
		
	}

	@Override
	public double getCharge() {
		return charge;
	}

	@Override
	public double getMaxCharge() {
		return maxCharge;
	}

	@Override
	public int getSlotSize() {
		return 1;
	}

}
