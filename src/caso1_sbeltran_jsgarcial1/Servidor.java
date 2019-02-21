package caso1_sbeltran_jsgarcial1;

/**
 * Cada servidor, por su parte, está continuamente intentando retirar 
 * mensajes del buffer; si no es posible, vuelve a intentarlo (espera activa). 
 * Sin embargo, el servidor debe ceder el procesador después de cada intento (método yield).
 *  Una vez retirado el mensaje, genera una respuesta, y procede a despertar 
 *  al cliente que se encuentra a la espera dormido en el mensaje.
 * 
 */
public class Servidor extends Thread {

}
