import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

// Hacer una clase llamada PassarRutesObjJSON (con main) que pase el archivo Rutes.obj a un fichero JSON Rutes.json 

public class PasarRutasObj_JSON
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		ObjectInputStream fileObject = new ObjectInputStream (new FileInputStream ("Rutes.obj"));
		Ruta e;
		JsonObject raiz = new JsonObject();
		JsonArray Rutas = new JsonArray();
		raiz.put("Rutas", Rutas);
		
		try
		{
			while (true)
			{
				e = (Ruta) fileObject.readObject();
				Map <String, Serializable> ruta = new LinkedHashMap <String, Serializable>();
				ruta.put("Nombre", e.getNombre());
				ruta.put("Desnivel", e.getDesnivel());
				ruta.put("Desnivel_Acumulado", e.getDesnivel_Acumulado());
				JsonArray Puntos = new JsonArray();
				ruta.put("Puntos", Puntos);
				Rutas.add(ruta);
				
				for (int j = 0; j < e.length(); j ++)
				{
					Map<String, Comparable> punto = new LinkedHashMap <String, Comparable>();
					punto.put("Número", (j+1));
					punto.put("Nombre", e.getPuntoNombre(j));
					punto.put("Latitud", e.getPuntoLatitud(j));
					punto.put("Longitud", e.getPuntoLongitud(j));
					Puntos.add(punto);
				}
			}
		}
		catch (EOFException eof)
		{
			FileWriter fjson = new FileWriter ("Rutas.json");
			fjson.write(raiz.toJson());
			fileObject.close();
			fjson.close();
		}
	}
}
