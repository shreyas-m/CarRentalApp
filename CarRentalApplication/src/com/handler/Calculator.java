package com.handler;

import java.util.Iterator;
import java.util.List;

import com.constants.CommonConstants;
import com.constants.FUEL;
import com.model.Bus;
import com.model.Vehicle;

public class Calculator {
	
	public static double calculateRate(Vehicle vehicle, int passangers) {
		double rate = CommonConstants.STANDARD_RATE;
	
		if(vehicle instanceof Bus) {
			rate = rate - CommonConstants.STANDARD_RATE*0.02;
		}
		
		if(FUEL.DIESEL.equals(vehicle.getFuel())){
			rate = rate - CommonConstants.DIESEL_DISCOUNT;
		}
		if(vehicle.isAc()) {
			rate = rate + CommonConstants.AC_RATE;
		}
		if(passangers-vehicle.getCapacity()>0) {
			rate = rate + passangers-vehicle.getCapacity();
		}
				
		return rate;
	}
	
	public static double calculateDistance(List<String> route) {
		double distance = 0;
		Iterator<String> iterator = route.iterator();
		String source = iterator.hasNext()?iterator.next():null;
		if(source!=null) {
			while (iterator.hasNext()) {
				String destination = iterator.next();
				distance += DistanceCalculator.getDistance(source,destination);
				source = destination;
			}
		}else {
			System.err.println("Trip details are not correct.");
		}
		
		return distance;
	}
	
}
