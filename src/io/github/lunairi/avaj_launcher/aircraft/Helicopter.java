package io.github.lunairi.avaj_launcher.aircraft;

import java.util.HashMap;

import io.github.lunairi.avaj_launcher.Coordinates;
import io.github.lunairi.avaj_launcher.WeatherTower;

public class Helicopter extends Aircraft implements Flyable  {

	private WeatherTower tower;
	
	private HashMap<String, String> msg = new HashMap<String, String>() {
		private static final long serialVersionUID = -2120918688074962936L;
		{
			put("SUN", "These rays being messed up by the rotars is annoying on the eyes.");
			put("RAIN", "Wow, who knew water hitting rotars could be so pretty?");
			put("FOG", "Good thing my rotars act like a fog repeller.");
			put("SNOW", "I'm making it snow with my rotars, lets go!");
			put("GROUNDED", "There's no landing pad here but I have to ground now!");
		}};
	
	public Helicopter(String name, Coordinates coordinates) {
		super (name, coordinates);
	}

	@Override
	public void updateConditions() {
		String update = this.updateCoordinates(tower.getWeather(this.coordinates), "Balloon");
		System.out.println("Helicopter#" + this.name + "(" + this.id + "): " + msg.get(update));
		if (update == "GROUNDED") {
			System.out.println("Helicopter#" + this.name + "(" + this.id + "): landing.");
            this.tower.unregister(this);
            System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.tower = weatherTower;
		this.tower.register(this);
		System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
	}
}
