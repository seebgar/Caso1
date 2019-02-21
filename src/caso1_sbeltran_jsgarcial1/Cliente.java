package caso1_sbeltran_jsgarcial1;

/**
 * Cada cliente hace un cierto numero de consultas y termina.
 * 
 * Para cada mensaje, el thread cliente debe generar un objeto de tipo Mensaje
 * e inicializarlo, despues lo envia.
 * 
 * Cuando termina el cliente le debe avisar al buffer que se retira.
 * 
 * El funcionamiento es el siguiente: un cliente genera un mensaje, e 
 * intenta depositarlo en el buffer; si no es posible, se duerme en el 
 * buffer (espera pasiva). Una vez depositado el mensaje, el cliente debe 
 * quedar a la espera de la respuesta del servidor; esta vez la espera se 
 * realiza dormido sobre el objeto mensaje (espera pasiva).
 * 
 */
public class Cliente extends Thread {

	/**
	 * Atributos
	 */

	private int mensajes;

	private Mensaje[] msgs;

	private Buffer buffer;


	/**
	 * Constructor
	 */

	public Cliente( int cantidad_mensajes, Buffer buff ) {
		this.mensajes = cantidad_mensajes;
		this.buffer = buff;
		this.msgs = new Mensaje[this.mensajes];

		for (int i = 0; i < msgs.length; i++) 
			this.msgs[i] = new Mensaje(i, this);
	}


	/**
	 * Run
	 */

	@Override
	public void run() {
		int N = 0;
		while ( mensajes > 0 ) {
			Mensaje enviando = msgs[N];
			// TODO almacenar en BUFFER
			mensajes--;
			N++;
		}

	}


	/**
	 * Metodos
	 */


	public int getMensajes() {
		return mensajes;
	}

	public void setMensajes(int mensajes) {
		this.mensajes = mensajes;
	}

	public Mensaje[] getMsgs() {
		return msgs;
	}

	public void setMsgs(Mensaje[] msgs) {
		this.msgs = msgs;
	}

	public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}



}
