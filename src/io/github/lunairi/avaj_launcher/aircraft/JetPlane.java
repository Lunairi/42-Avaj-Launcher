package io.github.lunairi.avaj_launcher.aircraft;

import java.util.HashMap;

import io.github.lunairi.avaj_launcher.Coordinates;
import io.github.lunairi.avaj_launcher.WeatherTower;

public class JetPlane extends Aircraft implements Flyable  {

	private WeatherTower tower;
	
	private HashMap<String, String> msg = new HashMap<String, String>() {
		private static final long serialVersionUID = -6757419032351273607L;
		{
			put("SUN", "I bet people can see my trails in this beautiful sky!");
			put("RAIN", "Rain? I can outspeed that anyday!");
			put("FOG", "Good thing I installed these fog lights!");
			put("SNOW", "I knew I should of installed those windshield wipers.");
			put("GROUNDED", "Altitude too low, landing as safely as I can.");
		}};
	
	public JetPlane(String name, Coordinates coordinates) {
		super (name, coordinates);
	}

	@Override
	public void updateConditions() {
		String update = this.updateCoordinates(tower.getWeather(this.coordinates), "JetPlane");
		System.out.println("JetPlane#" + this.name + "(" + this.id + "): " + msg.get(update));
		if (update == "GROUNDED") {
			System.out.println("JetPlane#" + this.name + "(" + this.id + "): landing.");
            this.tower.unregister(this);
            System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.tower = weatherTower;
		this.tower.register(this);
		System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
	}
}
