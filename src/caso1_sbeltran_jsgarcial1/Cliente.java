package caso1_sbeltran_jsgarcial1;

/**
 * El funcionamiento es el siguiente: un cliente genera un mensaje, e 
 * intenta depositarlo en el buffer; si no es posible, se duerme en el 
 * buffer (espera pasiva). Una vez depositado el mensaje, el cliente debe 
 * quedar a la espera de la respuesta del servidor; esta vez la espera se 
 * realiza dormido sobre el objeto mensaje (espera pasiva).
 * 
 */
public class Cliente extends Thread {

}
