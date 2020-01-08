package io.github.lunairi.avaj_launcher.aircraft;

import io.github.lunairi.avaj_launcher.Coordinates;

public class Aircraft {
	
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	
	private static long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		this.id = this.nextId();
	}

	private long nextId() {
		return (Aircraft.idCounter++ - 1);
	}
}
