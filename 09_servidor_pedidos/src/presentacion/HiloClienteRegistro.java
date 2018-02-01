package presentacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import modelo.GestionPedidos;

public class HiloClienteRegistro extends Thread {
	Socket sc;
	public HiloClienteRegistro(Socket sc) {
		this.sc=sc;
	}
	public void run() {
		GestionPedidos glibros=new GestionPedidos();		
		
		try{
			
			//recuperamos los datos para el pedido
			//que vienen en un JSON: {producto:valor,unidades:valor}
			JSONParser parser=new JSONParser();
			JSONObject ob=(JSONObject)parser.parse(new InputStreamReader(sc.getInputStream()));
			glibros.registrarPedido((String)ob.get("producto"),
								sc.getInetAddress().getHostAddress(), 
								Integer.parseInt(ob.get("unidades").toString()));
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
