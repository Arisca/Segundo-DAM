// Versión del ejemplo12 pero sin especificar la codificacion del archivo de entrada
// Se utilizan los decoradores BufferedReader y PrintWriter para poder ir cómodamente linea a linea

package Ejemplos;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import  java.io.PrintWriter;

public class Ejemplo13
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader f_ent = new BufferedReader (new FileReader ( "f5.txt"));
		PrintWriter f_eix = new PrintWriter (new OutputStreamWriter (new FileOutputStream ( "f5_ISO.txt"), "ISO-8859-1"));
		 
		String cad = f_ent.readLine ();
		while (cad != null)
		{
			f_eix.println (cad);
			cad = f_ent.readLine ();
		}
		f_eix.close ();
		f_ent.close ();
	}
}
