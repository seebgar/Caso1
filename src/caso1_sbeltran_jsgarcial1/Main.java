package caso1_sbeltran_jsgarcial1;

import java.io.*;

public class Main {
	
	public static void main(String[] args) {
		
		int clients = 0, messages = 0, servers = 0, buffer_size = 0;
		
		/**
		 * File Input Reader
		 */
		String txt = "docs/input.txt";
		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader(new File(txt)))) {
			br.readLine();
			while ( (line = br.readLine()) != null ) {
				String[ ] contenido = line.split("::");
				
				clients = Integer.parseInt(contenido[1]); // cantidad de clientes
				line = br.readLine();
				contenido = line.split("::");
				messages = Integer.parseInt(contenido[1]); // cantidad de mensajes
				line = br.readLine();
				contenido = line.split("::");
				servers = Integer.parseInt(contenido[1]); // cantidad de servidores
				line = br.readLine();
				contenido = line.split("::");
				buffer_size = Integer.parseInt(contenido[1]); // tamano del buffer
				
			}
		} catch (Exception e) {
			System.out.println(" -- Exception Reading File : "  +  txt + " --\n" + e.getMessage() + "\n \n");
		} 


		System.out.println(clients + " - " + messages + " - " + servers + " - " + buffer_size);
		
	}

}
