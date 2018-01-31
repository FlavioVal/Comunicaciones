package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {

		// Datos del servidor
//		String ip = "10.1.1.21";
		String ip = "10.1.1.100";
		int puerto = 9000;
		try {
			// conexion
			Socket sc = new Socket(ip, puerto);
			// crear canales entrada/salida
			InputStream is = sc.getInputStream();
			OutputStream os = sc.getOutputStream();
			try(PrintStream salida = new PrintStream(os);BufferedReader bf = new BufferedReader(new InputStreamReader(is));) {
				// envio de datos
				salida.println("***profe***");
				// leo respuesta
				String cad = bf.readLine();
				System.out.println(cad);
			}
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		}	
	}

 /* java.net.ConnectException: Connection refused: connect
    .....
	at principal.Cliente.main(Cliente.java:21)
 */

}
