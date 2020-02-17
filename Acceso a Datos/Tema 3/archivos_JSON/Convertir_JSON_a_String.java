package archivos_JSON;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.JsonArray;

public class Convertir_JSON_a_String
{

    public static void main (String [] args) throws IOException, JsonException
    {
        Reader r_json = new FileReader ( "bicicas.json");

        JsonArray estaciones = (JsonArray) ((JsonObject) ((JsonArray) Jsoner.deserialize (r_json)). get (0)). get ( "ocupacion");
        
        JsonArray destEstacions = new JsonArray ();
        
        for (Object este: estaciones) {
            JsonObject e = (JsonObject) este;
            Map destE = new LinkedHashMap ();
            destE.put ( "num", e.get ( "id"));
            destE.put ( "nombre", e.get ( "punto"));
            destE.put ( "sitios", e.get ( "puestos"));
            destE.put ( "ocupados", e.get ( "ocupados"));
            int libres = Integer.parseInt (e.get ( "puestos"). toString ()) - Integer.parseInt (e.get ( "ocupados"). toString ());
            destE.put ( "libres", libres);
            destEstacions.add (destE);
        }
        
        JsonObject Bicicas = new JsonObject ();
        Bicicas.put ( "Bicicas", destEstacions);
        
        Writer w_json = new FileWriter ( "bicicas2.json");
        w_json.write (Bicicas.toJson ());
        w_json.close ();
    }
}

