package com.validators;

import java.util.List;

import com.model.Vehicle;

public class Validator {

	public static boolean validateVehicle(Vehicle vehicle) {
		if(vehicle!=null &&
				vehicle.getCapacity()>0 &&
				vehicle.getType()!=null &&
				vehicle.getFuel()!=null
				)
			return true;
		return false;
	}

	public static boolean validateRoute(List<String> route) {
		//Considering vehicle should be returned from where is is borrowed i.e. only round trips are allowed.
		//This validation can be modified for one way trips.
		
		if(route!=null &&
				route.size()>2 &&
				route.get(0).equalsIgnoreCase(route.get(route.size()-1))
				)
			return true;
		return false;
	}

	
}
