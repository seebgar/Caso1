package caso1_sbeltran_jsgarcial1;

/**
 * Cada servidor, por su parte, estaÌ� continuamente intentando retirar 
 * mensajes del buffer; si no es posible, vuelve a intentarlo (espera activa). 
 * Sin embargo, el servidor debe ceder el procesador despueÌ�s de cada intento (meÌ�todo yield).
 *  Una vez retirado el mensaje, genera una respuesta, y procede a despertar 
 *  al cliente que se encuentra a la espera dormido en el mensaje.
 * 
 */
public class Servidor extends Thread {
	
	public Servidor() {
		
	}

	public static void retirarDeBuffer() {
		//TODO retirar mensaje del buffer
	}
	
	public static void despierta() {
		//TODO Despertar al cliente
	}
	
	public void run() {

	}
}
