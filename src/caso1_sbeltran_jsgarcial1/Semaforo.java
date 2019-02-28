package caso1_sbeltran_jsgarcial1;

public class Semaforo {
	
	private int contador;
	
	public Semaforo( ) {
		contador = 0;
	}
	
	public synchronized void p() throws InterruptedException {
		contador--;
		if (contador<0) {
			wait();
		}
	}
	
	public synchronized void v(){
		contador++;
		if (contador >= 0) {
			notifyAll();
		}
	}
	
}

