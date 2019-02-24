package caso1_sbeltran_jsgarcial1;

/**
 * Representan una consulta que hace el cliente y es donde el servidor deja la respuesta.
 * 
 * Los mensajes son objetos con la consulta que hace el cliente, y donde el servidor 
 * deja la respuesta.
 * 
 * Pra probar el programa, las consultas pueden consistir en numeros generados en
 * secuencia, o al azar, y la respuesta es este numero incrementado.
 * 
 */
public class Mensaje {

	/**
	 * Atributos
	 */
	private int contenido;
	private Cliente cliente;
	
	
	/**
	 * Constructor
	 */
	public Mensaje( int contenido, Cliente _cliente ) {
		this.cliente = _cliente;
		this.contenido = contenido;
	}
	
	/**
	 * Metodos
	 */
	
	public int getContenido() {
		return contenido;
	}

	public void setContenido(int contenido) {
		this.contenido = contenido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
