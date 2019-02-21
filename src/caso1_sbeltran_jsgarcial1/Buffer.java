package caso1_sbeltran_jsgarcial1;

import java.util.ArrayList;

/**
 * En cuanto al buffer, es un sitio donde los clientes almacenan los mensajes para que sean 
 * recogidos por los servidores; este buffer debe tener una cierta capacidad limitada, y 
 * funcionar en esquema productor-consumidor.
 *
 */
public class Buffer {
	
	/**
	 * Atributos
	 */
	
	
	private ArrayList<Integer> buff;
	private int n;
	
	Object lleno;
	Object vacio;
	
	
	
	/**
	 * Constructor
	 */
	
	
	public Buffer(int n) {
		this.n = n;
		buff = new ArrayList<Integer>();
		lleno = new Object();
		vacio = new Object();
	}
	
	
	
	/**
	 * Metodos
	 */
	
	
	public void almacenar(Integer i) {
		synchronized (lleno) {
			while (buff.size() == n) {
				try {
					System.out.println("Buffer lleno");
					lleno.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized (this) {
			buff.add(i);
		}
		synchronized (vacio) {
			vacio.notify();
		}
	}
	
	
	
	public Integer retirar() {
		synchronized (vacio) {
			while (buff.size() == 0) {
				try {
					System.out.println("Buffer vacio");
					vacio.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Integer i;

		synchronized (this) {
			i = buff.remove(0);
		}
		synchronized (lleno) {
			lleno.notify();
		}
		return i;
	}

}
