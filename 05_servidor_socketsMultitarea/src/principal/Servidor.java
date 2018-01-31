package principal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import comunicacion.HiloCliente;

public class Servidor {

	public static void main(String[] args) {
		try(ServerSocket serv=new ServerSocket(9000);) {
			
			//quedamos a la espera de una llamada
			while(true) {
				System.out.println("Esperando llamadas...");
				Socket sc=serv.accept();
				System.out.println("Llamada recibida...");
				new HiloCliente(sc).start();
			}
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
