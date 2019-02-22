package caso1_sbeltran_jsgarcial1;

public class Semaforo{
	private int contador;
	
	
	public Semaforo(int name) {
		contador = 0;
	}
	public synchronized void p() throws InterruptedException{
		contador--;
		System.out.println("contador : " +contador);
		if (contador<0) {
			wait();
		}
	}
	public synchronized void v(){
		contador++;
		System.out.println("contador : " +contador);

		if (contador >= 0) {
			notifyAll();
		}
	}
	
	
	
	
	
	
}

