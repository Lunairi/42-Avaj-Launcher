package io.github.lunairi.avaj_launcher;

import java.util.ArrayList;
import java.util.List;

import io.github.lunairi.avaj_launcher.aircraft.Flyable;

public class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();
	
	public void register(Flyable flyable) {
		observers.add(flyable);
	}
	
	public void unregister(Flyable flyable) {
		System.out.println();
		observers.remove(flyable);
	}
	
	protected void conditionsChanged() {
		observers.forEach((condition) -> {
			condition.updateConditions();
		});
	}
}