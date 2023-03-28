package me.Josh123likeme.RoverGame.Rover.Body;

import me.Josh123likeme.RoverGame.Rover.*;
import me.Josh123likeme.RoverGame.Rover.Equipment.*;

public abstract class Body implements  IHaveIdentity, IHaveMass {
	
	private Equipment[] lightEquipment;
	private Equipment[] mediumEquipment;
	private Equipment[] heavyEquipment;
	
	public abstract int getNumberOfLightEquipmentSlots();
	public abstract int getNumberOfMediumEquipmentSlots();
	public abstract int getNumberOfHeavyEquipmentSlots();;
	
	public Body() {
		
		lightEquipment = new Equipment[getNumberOfLightEquipmentSlots()];
		mediumEquipment = new Equipment[getNumberOfMediumEquipmentSlots()];
		heavyEquipment = new Equipment[getNumberOfHeavyEquipmentSlots()];
		
	}
	
	public Equipment[] getLightEquipment() {
		
		return lightEquipment;
		
	}
	public void setLightEquipment(int index, Equipment equipment) {
		
		lightEquipment[index] = equipment;
		
	}
	
	public Equipment[] getMediumEquipment() {
		
		return mediumEquipment;
		
	}
	public void setMediumEquipment(int index, Equipment equipment) {
		
		mediumEquipment[index] = equipment;
		
	}
	
	public Equipment[] getHeavyEquipment() {
	
	return heavyEquipment;
	
	}
	public void setHeavyEquipment(int index, Equipment equipment) {
		
		heavyEquipment[index] = equipment;
		
	}
	
	public Equipment[] getAllEquipment() {
		
		Equipment[] all = new Equipment[lightEquipment.length + mediumEquipment.length + heavyEquipment.length];
		
		int i = 0;
		
		for (Equipment equipment : lightEquipment) {
			
			all[i] = equipment;
			i++;
			
		}
		for (Equipment equipment : mediumEquipment) {
			
			all[i] = equipment;
			i++;
			
		}
		for (Equipment equipment : heavyEquipment) {
	
			all[i] = equipment;
			i++;
	
		}
		
		return all;
		
	}
	
}
