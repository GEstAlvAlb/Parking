package Coches;

import static Coches.Constantes.*;

public class Main {

	private static Coche a_coches[];

	public static void main(String[] args) {

		a_coches = new Coche[NUM_COCHES];
		System.out.println("Lanzo los coches");
		
		for (int i = 0; i < NUM_COCHES; i++) {
			a_coches[i] = new Coche(i);
			a_coches[i].start();
		
		}
	}
}
