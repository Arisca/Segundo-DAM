// Si se quiere sacar el contenido de un directorio concreto, se pondría en el momento de definir el File.
// Otra modificación seria pedir por teclado el directorio del cual queremos mostrar el contenido

package Ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejemplo2
{
	public static void main (String [] args) throws IOException
	{
		System.out.println ( "Introduce un directorio:");
		String ent = new BufferedReader (new InputStreamReader (System.in)). readLine ();
		File f = new File (ent);
		System.out.println ( "Lista de archivos y directorios del directorio" + ent);
		System.out.println ( "------------------------------------------- -------- ");
		
		for (String e: f.list ())
		System.out.println (e);
	}
}

