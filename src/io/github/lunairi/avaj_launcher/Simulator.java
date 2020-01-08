package io.github.lunairi.avaj_launcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {
	
	private static int simulationCycle;
	private static File file;
	private static BufferedReader br;
	private static String currentLine;
	
	public static void main(String[] args) {
		if (args.length < 1) { 
			return;
		}
		
		file = new File(args[0]);
		try {
			br = new BufferedReader(new FileReader(file));
			simulationCycle = Integer.parseInt(br.readLine());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return;
		} catch (NumberFormatException | IOException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		try {
			while ((currentLine = br.readLine()) != null) {

			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return;
		}
	}
}
