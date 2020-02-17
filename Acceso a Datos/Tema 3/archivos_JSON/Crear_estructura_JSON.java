package archivos_JSON;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.JsonArray;

public class Crear_estructura_JSON
{
	public static void main (String [] args) throws IOException
	{
        String [] nombres = { "Andreu", "Bernat", "Claudia", "Damià"};
        int [] departamentos = {10,20,10,10};
        int [] edades = {32,28,26,40};
        double [] sueldos = {1000.0,1200.0,1100.0,1500.0};
        
        JsonObject raiz = new JsonObject ();
        JsonObject empresa = new JsonObject ();
        raiz.put ( "empresa", empresa);
        JsonArray empleados = new JsonArray ();
        
        
        for (int i = 0; i <4; i ++) {
            JsonObject emp = new JsonObject ();
            emp.put ( "num", i + 1);
            emp.put ( "nombre", nombres [i]);
            emp.put ( "departamento", departamentos [i]);
            emp.put ( "edad", edades [i]);
            emp.put ( "sueldo", sueldos [i]);
            empleados.add(empresa);
        }
        
        FileWriter f = new FileWriter ( "Empleados.json");
        f.write (raiz.toJson ());
        f.close ();
    }
}

