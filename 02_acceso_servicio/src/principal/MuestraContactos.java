package principal;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MuestraContactos {

	public static void main(String[] args) {
		String dir = "http://10.1.1.100:8080/servicio_contactos/Contactos";
		try {
			// establecer comunicación
			URL url = new URL(dir);
			URLConnection con = url.openConnection();
			// lectura de datos
			InputStream is = con.getInputStream();
//			try (BufferedReader bf = new BufferedReader(new InputStreamReader(is));) {
//				bf.lines().forEach(s -> System.out.println(s));
//			}
			JSONParser parser=new JSONParser();
			JSONArray array=(JSONArray)parser.parse(new InputStreamReader(is));
			//recorremos e array JSON y mostramos los nombres de todos los contactos
			for(Object ob:array) {
				JSONObject data=(JSONObject)ob;
				System.out.println(data.get("nombre"));
			}
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
