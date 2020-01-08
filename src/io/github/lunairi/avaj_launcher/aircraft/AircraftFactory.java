package io.github.lunairi.avaj_launcher.aircraft;

import io.github.lunairi.avaj_launcher.Coordinates;

public class AircraftFactory {

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
		throws AircraftException {
		
		if ((longitude < 0) || (latitude < 0) || (height < 0)) {
			throw new AircraftException("Error: Cannot have negative coordinates for aircrafts");
		}
		
		if (height > 100) {
			height = 100;
		}
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		
		if (type.toLowerCase().equals("helicopter")) {
			return new Helicopter(name, coordinates);
		}
		else if (type.toLowerCase().equals("jetplane")) {
			return new JetPlane(name, coordinates);
		}
		else if (type.toLowerCase().equals("balloon") || type.toLowerCase().equals("baloon") ) {
			return new Balloon(name, coordinates);
		}
		
		return null;
	}
}
