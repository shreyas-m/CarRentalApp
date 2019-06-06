package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.constants.FUEL;
import com.controller.CarRentalApp;
import com.model.Bus;
import com.model.Car;
import com.model.ExpenseReport;
import com.model.SUV;
import com.model.Vehicle;

class TestCarRentalApp {

	@Test
	void testStandard() {
		SUV suv = new SUV(FUEL.PETROL,8);
		suv.setAc(false);
		List<String> route = new LinkedList<String>();
		route.add("PUNE");
		route.add("MUMBAI");
		route.add("BANGALORE");
		route.add("PUNE");
		CarRentalApp app = new CarRentalApp();
		ExpenseReport expense = app.getExpense(suv, 8, route);
		if(expense.getResponseCode()==0)
		{double actual = expense.getExpense();
		assertEquals(33757.5, actual);
		}
	}
	@Test
	void testDiesedVehicle() {
		SUV vehicle = new SUV(FUEL.DIESEL, 8);
		List<String> route = new LinkedList<String>();
		route.add("PUNE");
		route.add("MUMBAI");
		route.add("BANGALORE");
		route.add("PUNE");
		CarRentalApp app = new CarRentalApp();
		double actual = app.getExpense(vehicle, 8, route).getExpense();
		assertEquals(31507.0, actual);
	}
	@Test
	void testDiesedVehicleWithFullRoute() {
		SUV vehicle = new SUV(FUEL.DIESEL, 8);
		vehicle.setAc(false);
		List<String> route = new LinkedList<String>();
		route.add("PUNE");
		route.add("MUMBAI");
		route.add("BANGALORE");
		route.add("DELHI");
		route.add("PUNE");
		route.add("CHENNAI");
		route.add("PUNE");
		
		CarRentalApp app = new CarRentalApp();
		double actual = app.getExpense(vehicle, 8, route).getExpense();
		assertEquals(107107.0, actual);
	}
	@Test
	void testStandardWithFullDetails() {
		SUV vehicle = new SUV(FUEL.DIESEL, 8);
		vehicle.setAc(false);
		vehicle.setModel("Swift");
		List<String> route = new LinkedList<String>();
		route.add("PUNE");
		route.add("MUMBAI");
		route.add("BANGALORE");
		route.add("PUNE");
		CarRentalApp app = new CarRentalApp();
		double actual = app.getExpense(vehicle, 8, route).getExpense();
		assertEquals(31507.0, actual);
	}

	@Test
	void testStandardWithExceedingCapacity() {
		Car vehicle = new Car(FUEL.DIESEL, 4);
		vehicle.setAc(false);
		List<String> route = new LinkedList<String>();
		route.add("PUNE");
		route.add("MUMBAI");
		route.add("BANGALORE");
		route.add("PUNE");
		CarRentalApp app = new CarRentalApp();
		double actual = app.getExpense(vehicle, 6, route).getExpense();
		assertEquals(36008.0, actual);
	}
	
	@Test
	void testStandardWithAC() {
		Car vehicle = new Car(FUEL.DIESEL, 4);
		vehicle.setAc(true);
		List<String> route = new LinkedList<String>();
		route.add("PUNE");
		route.add("MUMBAI");
		route.add("BANGALORE");
		route.add("PUNE");
		CarRentalApp app = new CarRentalApp();
		double actual = app.getExpense(vehicle, 4, route).getExpense();
		assertEquals(36008.0, actual);
	}
	
	@Test
	void testStandardWithBUS() {
		Bus bus = new Bus(FUEL.DIESEL, 15);
		bus.setAc(true);
		List<String> route = new LinkedList<String>();
		route.add("PUNE");
		route.add("MUMBAI");
		route.add("BANGALORE");
		route.add("PUNE");
		CarRentalApp app = new CarRentalApp();
		double actual = app.getExpense(bus, 8, route).getExpense();
		assertEquals(35332.85, actual);
	}

	//NegativeTestCases
	
	@Test
	void testNullRoute() {
		SUV vehicle = new SUV(FUEL.DIESEL, 8);
		vehicle.setAc(false);
		List<String> route = null;
		CarRentalApp app = new CarRentalApp();
		ExpenseReport actual = app.getExpense(vehicle, 8, route);
		assertEquals("Route provided is not valid", actual.getResponseDescription());
	}
	@Test
	void testInvalidRoute() {
		SUV vehicle = new SUV(FUEL.DIESEL, 8);
		vehicle.setAc(false);
		List<String> route = new LinkedList<String>();
		route.add("PUNE");
		route.add("BANGALORE");
		route.add("MUMBAI");
		CarRentalApp app = new CarRentalApp();
		ExpenseReport actual = app.getExpense(vehicle, 8, route);
		assertEquals("Route provided is not valid", actual.getResponseDescription());
	}
	@Test
	void testShortRoute() {
		SUV vehicle = new SUV(FUEL.DIESEL, 8);
		vehicle.setAc(true);
		List<String> route = new LinkedList<String>();
		route.add("PUNE");
		CarRentalApp app = new CarRentalApp();
		ExpenseReport actual = app.getExpense(vehicle, 8, route);
		assertEquals("Route provided is not valid", actual.getResponseDescription());
	}
	@Test
	void testNullVehicle() {
		Vehicle vehicle = null;
		List<String> route = new LinkedList<String>();
		route.add("PUNE");
		route.add("MUMBAI");
		route.add("BANGALORE");
		route.add("PUNE");
		CarRentalApp app = new CarRentalApp();
		ExpenseReport actual = app.getExpense(vehicle, 8, route);
		assertEquals("Vehicle is not valid", actual.getResponseDescription());
	}

	@Test
	void testNullVehicleFuel() {
		SUV vehicle = new SUV(null, 8);
		List<String> route = new LinkedList<String>();
		route.add("PUNE");
		route.add("MUMBAI");
		route.add("BANGALORE");
		route.add("PUNE");
		CarRentalApp app = new CarRentalApp();
		ExpenseReport actual = app.getExpense(vehicle, 8, route);
		assertEquals("Vehicle is not valid", actual.getResponseDescription());
	}
	@Test
	void testNullVehicleCapacity() {
		Vehicle vehicle = new Car(FUEL.DIESEL, 0);
		List<String> route = new LinkedList<String>();
		route.add("PUNE");
		route.add("MUMBAI");
		route.add("BANGALORE");
		route.add("PUNE");
		CarRentalApp app = new CarRentalApp();
		ExpenseReport actual = app.getExpense(vehicle, 8, route);
		assertEquals("Vehicle is not valid", actual.getResponseDescription());
	}
	@Test
	void testNoPassengers() {
		SUV vehicle = new SUV(FUEL.DIESEL, 8);
		List<String> route = new LinkedList<String>();
		route.add("PUNE");
		route.add("MUMBAI");
		route.add("BANGALORE");
		route.add("PUNE");
		CarRentalApp app = new CarRentalApp();
		ExpenseReport actual = app.getExpense(vehicle, 0, route);
		assertEquals("Passengers cant be zero", actual.getResponseDescription());
	}
}
