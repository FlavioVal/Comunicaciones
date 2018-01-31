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
		String dir = "http://apidev.accuweather.com/locations/v1/search?q=madrid,%20spain&apikey=hoArfRosT1215";
		try {
			// establecer comunicación
			URL url = new URL(dir);
			URLConnection con = url.openConnection();
			// lectura de datos
			InputStream is = con.getInputStream();
			JSONParser parser=new JSONParser();
			JSONArray array=(JSONArray)parser.parse(new InputStreamReader(is));
			//recorremos e array JSON y mostramos los nombres de todos los contactos
			
			JSONObject obPrincipal=(JSONObject)array.get(0);
			JSONObject ob2= (JSONObject)obPrincipal.get("GeoPosition");
			System.out.println("Latitude: "+ob2.get("Latitude")+"  Longitude: "+ob2.get("Longitude"));
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
