package Coches;

import static Coches.Constantes.*;

public class Parking {

	int[] a_parking;
	String nombre;
	int id;
	int pos = 0;

	public Parking() {
		a_parking = new int[PLAZAS];
		for (int i = 0; i < PLAZAS; i++) {
			a_parking[i] = LIBRE;
		}
	}

	synchronized void parking(Coche coche, boolean aparcar) throws InterruptedException {
		nombre=coche.getName();
		id=coche.getIdCoche();
		
		if (aparcar) {
			int plazaLibre;

			while ((plazaLibre = buscarPlaza(id, nombre)) == LIBRE) {
				System.out.println("estoy esperando"+ id);
				wait();
			}
			System.out.println("plaza libre "+plazaLibre);
			a_parking[plazaLibre] = id;
			System.out.println("soy " + nombre + " y estot aparcando en " + plazaLibre);
			Thread.sleep(500);
			
			coche.setPosiconOcupada(plazaLibre);
			
		} else {
			System.out.println("soy " + nombre + " y estoy saliendo");
			int plaza= coche.getPosiconOcupada();
			coche.setPosiconOcupada(0);
			a_parking[plaza]=LIBRE;
			
			Thread.sleep(500);
			
			notifyAll();
			//return LIBRE;
		}
	}

	private int buscarPlaza(int id, String nombre) throws InterruptedException {
		
		pos = 0;
		while (pos < PLAZAS) {

			if (a_parking[pos] < 0) {
				return pos;
				
			} 
			pos = pos + 1;

		}
		return LIBRE;
		
	}
}
