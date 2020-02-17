package Ejercicio;


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

public class PasarRutasObjJSON
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		ObjectInputStream fileObject = new ObjectInputStream (new FileInputStream ("Rutas.obj"));
		Ruta R;
		JsonObject raiz = new JsonObject ();
		JsonArray rutas = new JsonArray ();
		raiz.put ("rutas", rutas);
		
		try
		{
			while (true)
			{
				R = (Ruta) fileObject.readObject();
				Map <String, Serializable> rut = new LinkedHashMap <String, Serializable> ();
				rut.put("Nombre", R.getNombre());
				rut.put("Desnivel", R.getDesnivel());
				rut.put("Desnivel Acumulado", R.getDesnivel_Acumulado());
				JsonArray puntos = new JsonArray ();
				rut.put("Puntos", puntos);
				rutas.add(rut);
				
				for (int j = 0; j < R.length(); j ++)
				{
					Map <String, Serializable> punto = new LinkedHashMap <String, Serializable> ();
					punto.put("Número", (j+1));
					punto.put("Nombre", R.getPuntoNombre (j));
					punto.put("Latitud", R.getPuntoLatitud(j));
					punto.put("Longitud", R.getPuntoLongitud(j));
					puntos.add(punto);	
				}
			}
		}
		catch (EOFException eof)
		{
			FileWriter fileJSON = new FileWriter("Rutas.json");
			fileJSON.write(raiz.toJson());
			fileObject.close();
			fileJSON.close();
		}
	}
}
