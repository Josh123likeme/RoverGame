package me.Josh123likeme.RoverGame.Rover.Equipment;

import me.Josh123likeme.RoverGame.Rover.Rover;

public class LIGHT_ANTENNA extends Equipment implements IAffectPower {
	
	private boolean sendingData = false;
	
	public LIGHT_ANTENNA(Rover rover) {
		super(rover);
	}

	@Override
	public String getName() {
		return "Light Antenna";
	}

	@Override
	public String getDescription() {
		return "A light antenna capable of transmitting signals in clear weather.\nCAUTION: can be affected by dust storms";
	}

	@Override
	public String getStatus() {
		return sendingData ? "Sending Data" : "Awaiting Command";
	}

	@Override
	public double getPowerChange() {
		return sendingData ? -50 : -10;
	}

	@Override
	public int getSlotSize() {
		return 0;
	}
	
}
