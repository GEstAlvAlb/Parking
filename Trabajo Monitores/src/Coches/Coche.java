package Coches;

import java.util.Random;

public class Coche extends Thread {

	private int id;
	Random rand=new Random();

	Coche(int id) {
			this.setName("Coche " + (id + 1));
			this.id = id;
	}
	
	public void run() {

		System.out.println("soy "+ getName());
		
		try {
			Parking.parking(id,getName(),true);
			Thread.sleep(rand.nextInt(10000)+500);
			Parking.parking(id, getName(), false);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
		
}
