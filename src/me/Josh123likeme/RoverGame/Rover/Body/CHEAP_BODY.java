package me.Josh123likeme.RoverGame.Rover.Body;

public class CHEAP_BODY extends Body {

	@Override
	public double getMass() {
		return 100D;
	}

	@Override
	public String getName() {
		return "Cheap Body";
	}

	@Override
	public String getDescription() {
		return "A Cheap Body that's perfect for a first rover";
	}
	
	@Override
	public int getNumberOfLightEquipmentSlots() {
		return 2;
	}

	@Override
	public int getNumberOfMediumEquipmentSlots() {
		return 1;
	}

	@Override
	public int getNumberOfHeavyEquipmentSlots() {
		return 0;
	}


}
