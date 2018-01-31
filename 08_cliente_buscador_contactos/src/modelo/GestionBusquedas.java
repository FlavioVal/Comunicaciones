package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import beans.Contacto;

public class GestionBusquedas {
	public List<Contacto> buscarContactos(String cad){
		String ip="10.1.1.100";
		int puerto=9000;
		List<Contacto> contactos=null;
		try {
			Socket sc=new Socket(ip,puerto);
			InputStream is=sc.getInputStream();
			OutputStream os=sc.getOutputStream();
			
			try(PrintStream salida=new PrintStream(os);BufferedReader bf=new BufferedReader(new InputStreamReader(is));){
				salida.println(cad);
				String respJSON=bf.readLine();
				contactos=transformarEnLista(respJSON);
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return contactos;
	}
	private List<Contacto> transformarEnLista(String json){
		ArrayList<Contacto> contactos=new ArrayList<>();
		JSONParser parser=new JSONParser();
		try {
			JSONArray array=(JSONArray)parser.parse(json);
			//recorremos el array JSON y mostramos los nombres de todos
			//los contactos
			//for(Object ob:array) {
			array.forEach(ob->{
				JSONObject data=(JSONObject)ob;
				Contacto c=new Contacto(data.get("nombre").toString(), 
						data.get("email").toString(), 
						Integer.parseInt(data.get("telefono").toString()));
				contactos.add(c);
			});
				
			//}
		}
		catch(ParseException ex) {
			ex.printStackTrace();
		}
		
		return contactos;
	}
}
