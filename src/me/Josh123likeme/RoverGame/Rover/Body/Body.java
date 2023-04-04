package me.Josh123likeme.RoverGame.Rover.Body;

import me.Josh123likeme.RoverGame.Rover.*;
import me.Josh123likeme.RoverGame.Rover.Equipment.*;

public abstract class Body implements  IHaveIdentity, IHaveMass {
	
	private Equipment[] lightEquipmentSlots;
	private Equipment[] mediumEquipmentSlots;
	private Equipment[] heavyEquipmentSlots;
	
	public abstract int getNumberOfLightEquipmentSlots();
	public abstract int getNumberOfMediumEquipmentSlots();
	public abstract int getNumberOfHeavyEquipmentSlots();;
	
	public Body() {
		
		lightEquipmentSlots = new Equipment[getNumberOfLightEquipmentSlots()];
		mediumEquipmentSlots = new Equipment[getNumberOfMediumEquipmentSlots()];
		heavyEquipmentSlots = new Equipment[getNumberOfHeavyEquipmentSlots()];
		
	}
	
	public Equipment[] getLightEquipment() {
		
		return lightEquipmentSlots;
		
	}
	public void setLightEquipment(int index, Equipment equipment) {
		
		if (index >= lightEquipmentSlots.length) throw new IllegalArgumentException("There aren't that many slots");
		
		if (equipment.getSlotSize() > 0) throw new IllegalArgumentException("The equipment is too large for this slot");
		
		lightEquipmentSlots[index] = equipment;
		
	}
	
	public Equipment[] getMediumEquipment() {
		
		return mediumEquipmentSlots;
		
	}
	public void setMediumEquipment(int index, Equipment equipment) {
		
		if (index >= mediumEquipmentSlots.length) throw new IllegalArgumentException("There aren't that many slots");
		
		if (equipment.getSlotSize() > 1) throw new IllegalArgumentException("The equipment is too large for this slot");
		
		mediumEquipmentSlots[index] = equipment;
		
	}
	
	public Equipment[] getHeavyEquipment() {
	
	return heavyEquipmentSlots;
	
	}
	public void setHeavyEquipment(int index, Equipment equipment) {
		
		if (index >= heavyEquipmentSlots.length) throw new IllegalArgumentException("There aren't that many slots");
		
		if (equipment.getSlotSize() > 2) throw new IllegalArgumentException("The equipment is too large for this slot");
		
		heavyEquipmentSlots[index] = equipment;
		
	}
	
	public Equipment[] getAllEquipment() {
		
		Equipment[] all = new Equipment[lightEquipmentSlots.length + mediumEquipmentSlots.length + heavyEquipmentSlots.length];
		
		int i = 0;
		
		for (Equipment equipment : lightEquipmentSlots) {
			
			all[i] = equipment;
			i++;
			
		}
		for (Equipment equipment : mediumEquipmentSlots) {
			
			all[i] = equipment;
			i++;
			
		}
		for (Equipment equipment : heavyEquipmentSlots) {
	
			all[i] = equipment;
			i++;
	
		}
		
		return all;
		
	}
	
}
