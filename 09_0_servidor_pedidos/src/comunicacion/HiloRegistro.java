package comunicacion;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import modelo.GestionPedido;

public class HiloRegistro implements Runnable {
	private Socket sc;
	public HiloRegistro(Socket sc) {
		this.sc=sc;
	}
	
	@Override
	public void run() {
		InputStream is=sc.getInputStream();
		try(BufferedReader bf=new BufferedReader(new InputStreamReader(is));){
			String cad=bf.readLine();
			//recogemos Datos Producto
			GestionPedido gp=new GestionPedido();
			gp.registraProducto(producto, unidades);
			
			
		}
		
	}

}
