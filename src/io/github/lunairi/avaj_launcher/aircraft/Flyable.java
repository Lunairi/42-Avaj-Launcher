package io.github.lunairi.avaj_launcher.aircraft;

import io.github.lunairi.avaj_launcher.WeatherTower;

public interface Flyable {
	
	void updateConditions();
    void registerTower(WeatherTower weatherTower);
    
}
