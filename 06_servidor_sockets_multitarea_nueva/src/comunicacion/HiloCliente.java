package comunicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class HiloCliente implements Runnable {
	private Socket sc;
	public HiloCliente(Socket sc) {
		this.sc=sc;
	}
	@Override
	public void run() {
		try {
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
		finally {
			try {
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
