package io.github.lunairi.avaj_launcher.aircraft;

import java.util.HashMap;
import io.github.lunairi.avaj_launcher.Coordinates;
import io.github.lunairi.avaj_launcher.WeatherTower;

public class Balloon extends Aircraft implements Flyable  {

	private WeatherTower tower;
	private HashMap<String, String> msg = new HashMap<String, String>() {
		private static final long serialVersionUID = 6356290756913881892L;
	{
		put("SUN", "AHHH I CAN FEEL THE SKIN PEELING FROM MY FLESH!!!");
		put("RAIN", "Who knew this inflatable rubber could act like an umbrella.");
		put("FOG", "I'd love a fog repeller but it'd probably not a good idea in a balloon.");
		put("SNOW", "I bet I looked like ice cream from below being covered in snow.");
		put("GROUNDED", "Crash landing! I hope this balloon can cushion the crash!");
	}};
	
	public Balloon(String name, Coordinates coordinates) {
		super (name, coordinates);
	}

	@Override
	public void updateConditions() {
		String update = this.updateCoordinates(tower.getWeather(this.coordinates), "Balloon");
		System.out.println("Balloon#" + this.name + "(" + this.id + "): " + msg.get(update));
		if (update == "GROUNDED") {
			System.out.println("Balloon#" + this.name + "(" + this.id + "): landing.");
			System.out.println("Current coordinates: Longtitude: [" + this.coordinates.getLongitude() 
				+ "] Latitude: [" + this.coordinates.getLatitude()
				+ "] Height: [" + this.coordinates.getHeight() + "]");
            this.tower.unregister(this);
            System.out.println("Tower says: Balloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.tower = weatherTower;
		this.tower.register(this);
		System.out.println("Tower says: Balloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
	}
}
