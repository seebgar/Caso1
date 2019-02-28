package caso1_sbeltran_jsgarcial1;

import java.util.LinkedList;

/**
 * En cuanto al buffer, es un sitio donde los clientes almacenan los mensajes para que sean 
 * recogidos por los servidores; este buffer debe tener una cierta capacidad limitada, y 
 * funcionar en esquema productor-consumidor.
 * 
 * An inadequate solution could result in a deadlock where both processes are waiting to be awakened.
 *
 */
public class Buffer {

	/**
	 * Atributos
	 */
	private LinkedList<Mensaje> buff;
	private int n;	
	private static int n_clientes;
	Object lleno;
	Object vacio;


	/**
	 * Constructor
	 */
	public Buffer(int n) {
		this.n = n;
		buff = new LinkedList<Mensaje>();
		lleno = new Object();
		vacio = new Object();
	}


	/**
	 * Metodos
	 */

	/**
	 * Almacena un mensaje enviado por el productor, si el buffer
	 * no esta lleno
	 * @param i Mensaje a enviar
	 */
	public void almacenar(Mensaje i) {
		synchronized (lleno) {

			while (buff.size() >= n) { // el Cliente espera mientras el Buffer esta lleno
				try {
					//System.out.println(">> Buffer LLeno, Cliente esperando <<");
					lleno.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

		synchronized (this) {
			buff.add(i); // el Cliente logra mandar un mensaje
		}

		synchronized (vacio) {
			vacio.notify(); // Notifica al Servidor que puede empezar a leer
		}
		
	}


	/**
	 * Retira un mensaje del buffer, si no esta vacio
	 * @return Mensaje
	 */
	public Mensaje retirar() {
		synchronized (vacio) {

			while (buff.size() == 0) { // el Servidor espera mientras en Buffer esta vacio
				try {
					//System.out.println(">> Buffer Vacio, Servidor esperando << ");
					vacio.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

		Mensaje i = null;
		synchronized (this) {
			if ( buff.size() > 0 )
				i = buff.remove(0); // se retira el primer mensaje que habia llegado
		}

		synchronized (lleno) {
			lleno.notify(); // el cliente es notificado para que siga enviando
		}

		return i;
	}


	/**
	 * Cada vez que un cliente termine de mandar sus
	 * mensajes, se le notifica al buffer
	 */
	public static void eliminiar_cliente() {
		Buffer.n_clientes--;
	}
	
	public static int get_nClientes() {
		return Buffer.n_clientes;
	}
	
	public static void set_nClientes(int x) {
		Buffer.n_clientes = x;
	}



}
