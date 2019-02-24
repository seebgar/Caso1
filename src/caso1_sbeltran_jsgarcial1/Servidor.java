package caso1_sbeltran_jsgarcial1;

/**
 * Cada servidor, por su parte, esta continuamente intentando retirar 
 * mensajes del buffer; si no es posible, vuelve a intentarlo (espera activa). 
 * Sin embargo, el servidor debe ceder el procesador despues de cada intento (metodo yield).
 *  Una vez retirado el mensaje, genera una respuesta, y procede a despertar 
 *  al cliente que se encuentra a la espera dormido en el mensaje.
 * 
 */
public class Servidor extends Thread {
	
	/**
	 * Atributos
	 */
	private Buffer buffer;
	private static boolean exit = false;
	
	/**
	 * Constructor
	 */
	public Servidor( Buffer buffer) {
		this.buffer = buffer;
	}
	/**
	 * Metodo para parar los threads servidor
	 */
	public void stopThread(){
        exit = true;
    }

	/**
	 * Run
	 */	

	@SuppressWarnings("static-access")
	public void run() {
		
		while (buffer.get_nClientes() > 0 && !exit) { // TODO intento de = "los threads servidores deben terminar cuando no haya mas clientes"
			Mensaje mens = buffer.retirar(); // recibe un mensaje del Cliente 
			if ( mens != null ) {
				mens.setContenido(mens.getContenido()*-1000);
				synchronized (mens) {
					mens.notify(); // despierta al Cliente que duerme en el objeto Mensaje esperando por la respuesta
				}
			}	
			
			this.yield(); // cede el procesador luego de cada intento de recibir un mensaje
		}
		
	}
	
	
	
}
