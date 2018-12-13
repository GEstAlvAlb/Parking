package Coches;
import static Coches.Constantes.*;

public class Parking {

	static int []a_parking;
	

	public Parking() {
		for (int i=0;i<PLAZAS;i++) {
			a_parking[i]=-1;
		}
	}

	synchronized static int parking(int id, String nombre, boolean aparcar) throws InterruptedException {
		if (aparcar) {
			boolean encontrado=false;
			int pos=0;
			while (pos<=PLAZAS || encontrado==true) {
				if(a_parking[pos]==-1) {
					encontrado=true;
					System.out.println(pos);
				}
				
				pos++;
				
			}
			
			System.out.println("soy " + nombre + " y estot parcando en "+pos);
			Thread.sleep(500);

			return pos;
		} else {
			System.out.println("soy " + nombre + " y estoy saliendo");
			Thread.sleep(500);

			return -1;
		}
	}
}
