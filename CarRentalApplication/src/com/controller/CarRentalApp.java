package com.controller;

import java.util.List;

import com.handler.Calculator;
import com.model.ExpenseReport;
import com.model.Vehicle;
import com.validators.Validator;

public class CarRentalApp {

	public ExpenseReport getExpense(Vehicle vehicle, int totalPassangers, List<String> route) {
		
		boolean vehicleValidity = Validator.validateVehicle(vehicle);
		boolean routeValidity = Validator.validateRoute(route);
		ExpenseReport response = new ExpenseReport();
		if(vehicleValidity && routeValidity && totalPassangers>0) {
			response.setExpense(Calculator.calculateRate(vehicle, totalPassangers)*Calculator.calculateDistance(route));
			response.setResponseCode(0);
			response.setResponseDescription("SUCCESS");
			return response;
		}else {
			if(!routeValidity) {
				response.setResponseCode(1);
				response.setResponseDescription("Route provided is not valid");
				System.err.println("Route provided is not valid");
			}
			if(!vehicleValidity) {
				response.setResponseCode(2);
				response.setResponseDescription("Vehicle is not valid");
				System.err.println("Vehicle is not valid");
			}
			if(totalPassangers<=0) {
				response.setResponseCode(3);
				response.setResponseDescription("Passengers cant be zero");
				System.err.println("Passengers cant be zero");
			}
		}
		
		return response;
	}
	
}
