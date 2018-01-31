package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		try {
			ServerSocket serv=new ServerSocket(9000);
			//quedamos a la espera de una llamada
			System.out.println("Esperando llamadas...");
			Socket sc=serv.accept();
			System.out.println("Llamada recibida...");
			//crear canales entrada/salida
			InputStream is=sc.getInputStream();
			OutputStream os=sc.getOutputStream();
			try(PrintStream salida=new PrintStream(os);BufferedReader bf=new BufferedReader(new InputStreamReader(is));){
				String s=bf.readLine();//leemos el dato enviado desde el cliente
				salida.println("Bienvenido a el servidor "+s);
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
