package archivos_JSON;

import java.io.FileReader;
import java.io.IOException;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.JsonArray;

public class Leer_archivo_JSON
{
	public static void main (String [] args) throws IOException, JsonException
	{
        JsonArray raiz = (JsonArray) Jsoner.deserialize (new FileReader ( "bicicas.json"));
        JsonObject obj = (JsonObject) raiz.get (0);
        JsonArray estaciones = (JsonArray) obj.get ( "ocupacion");

        for (int i = 0; i <estaciones.size (); i ++) {
            JsonObject e = (JsonObject) estaciones.get (i);
            System.out.println (e.get ( "id") + ".-" + e.get ( "punto") + "(" + e.get ( "ocupados") + "/" + e.get ( "puestos") + ")");
        }
    }
}