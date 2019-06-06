package com.model;

import com.constants.FUEL;

public abstract class Vehicle {

	private String type;
	private FUEL fuel;
	private boolean ac;
	private int capacity;
	private String model;

	protected Vehicle(String type, FUEL fuel, int capacity) {
		this.type = type;
		this.fuel = fuel;
		this.capacity = capacity;
	}
	
	public String getType() {
		return type;
	}
	public FUEL getFuel() {
		return fuel;
	}
	public void setFuel(FUEL fuel) {
		this.fuel = fuel;
	}
	public boolean isAc() {
		return ac;
	}
	public void setAc(boolean ac) {
		this.ac = ac;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
}
