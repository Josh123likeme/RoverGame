package me.Josh123likeme.RoverGame.Rover.Equipment;

import me.Josh123likeme.RoverGame.Rover.Rover;

public class LIGHT_SOLAR_PANEL extends Equipment implements IAffectPower {

	private double maxProductionRate = 20D;
	
	public LIGHT_SOLAR_PANEL(Rover rover) {
		super(rover);
	}

	@Override
	public String getName() {
		return "Light Solar Panel";
	}

	@Override
	public String getDescription() {
		return "A light solar panel that";
	}

	@Override
	public double getPowerChange() {
		return maxProductionRate;
	}

	@Override
	public String getStatus() {
		return "Generating " + String.format("%.2f", getPowerChange()) + " watt hours of power";
	}

	@Override
	public int getSlotSize() {
		return 0;
	}

}
