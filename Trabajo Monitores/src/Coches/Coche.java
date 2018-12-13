package Coches;

import java.util.Random;

public class Coche extends Thread {
	
	private int idCoche;
	Random rand=new Random();
	Parking parking;
	private int posiconOcupada;

	Coche(int id,Parking parking) {
			this.setName("Coche " + (id + 1));
			this.parking=parking;
			this.idCoche = id;
	}
	
	public void run() {

		System.out.println("soy "+ getName());
		
		try {
			parking.parking(this,true);
			Thread.sleep(rand.nextInt(500)+500);
			parking.parking(this, false);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

	

	public int getIdCoche() {
		return idCoche;
	}

	public void setIdCoche(int id) {
		this.idCoche = id;
	}

	public int getPosiconOcupada() {
		return posiconOcupada;
	}

	public void setPosiconOcupada(int posiconOcupada) {
		this.posiconOcupada = posiconOcupada;
	}
	
		
}
