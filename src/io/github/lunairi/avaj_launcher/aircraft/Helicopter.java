package io.github.lunairi.avaj_launcher.aircraft;

import io.github.lunairi.avaj_launcher.Coordinates;
import io.github.lunairi.avaj_launcher.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

	public Helicopter(String name, Coordinates coordinates) {
		super (name, coordinates);
	}

	@Override
	public void updateConditions() {
		// TODO Auto-generated method stub
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		// TODO Auto-generated method stub
	}

}
