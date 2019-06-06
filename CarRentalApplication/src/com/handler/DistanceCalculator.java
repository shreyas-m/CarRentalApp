package com.handler;

public class DistanceCalculator {

	public static double getDistance(String source, String next) {
		
		//DB , FILE or HHTP service call to pull the data.
		//Below is the sample data for testing.
		
		if(source.equalsIgnoreCase("PUNE") && next.equalsIgnoreCase("MUMBAI") || 
				next.equalsIgnoreCase("PUNE") && source.equalsIgnoreCase("MUMBAI")) {
			return 200;
		}
		if(source.equalsIgnoreCase("PUNE") && next.equalsIgnoreCase("BANGALORE") || 
				next.equalsIgnoreCase("PUNE") && source.equalsIgnoreCase("BANGALORE")) {
			return 1000;
		}
		if(source.equalsIgnoreCase("PUNE") && next.equalsIgnoreCase("CHENNAI") || 
				next.equalsIgnoreCase("PUNE") && source.equalsIgnoreCase("CHENNAI")) {
			return 1200;
		}
		if(source.equalsIgnoreCase("PUNE") && next.equalsIgnoreCase("DELHI") || 
				next.equalsIgnoreCase("PUNE") && source.equalsIgnoreCase("DELHI")) {
			return 2000;
		}
		if(source.equalsIgnoreCase("MUMBAI") && next.equalsIgnoreCase("BANGALORE") || 
				next.equalsIgnoreCase("MUMBAI") && source.equalsIgnoreCase("BANGALORE")) {
			return 1050.5;
		}
		if(source.equalsIgnoreCase("MUMBAI") && next.equalsIgnoreCase("CHENNAI") || 
				next.equalsIgnoreCase("MUMBAI") && source.equalsIgnoreCase("CHENNAI")) {
			return 1234.5;
		}
		if(source.equalsIgnoreCase("MUMBAI") && next.equalsIgnoreCase("DELHI") || 
				next.equalsIgnoreCase("MUMBAI") && source.equalsIgnoreCase("DELHI")) {
			return 2050;
		}
		if(source.equalsIgnoreCase("BANGALORE") && next.equalsIgnoreCase("CHENNAI") || 
				next.equalsIgnoreCase("BANGALORE") && source.equalsIgnoreCase("CHENNAI")) {
			return 200;
		}
		if(source.equalsIgnoreCase("BANGALORE") && next.equalsIgnoreCase("DELHI") || 
				next.equalsIgnoreCase("BANGALORE") && source.equalsIgnoreCase("DELHI")) {
			return 2000;
		}
		if(source.equalsIgnoreCase("CHENNAI") && next.equalsIgnoreCase("DELHI") || 
				next.equalsIgnoreCase("CHENNAI") && source.equalsIgnoreCase("DELHI")) {
			return 2000;
		}
		return 0;
	}
	
	

}
