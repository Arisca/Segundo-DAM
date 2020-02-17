package Tema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mostrar_directorio_concreto_mas_detalles
{
	public static void main (String [] args) throws IOException
	{
		System.out.println("Introduce un directorio : ");
		String ent = new BufferedReader (new InputStreamReader (System.in))
                .readLine ();
		File f = new File (ent);
		if (f.exists ())
		{
			if (f.isDirectory ())
			{
				ListaDirectorio (f);
			}
			else
				System.out.println("No es un directorio");
		}
		else
			System.out.println("No hay una carpeta");
	}
	
	private static void ListaDirectorio (File f) throws IOException
	{
		System.out.println("Lista de archivos y directorios del directorio : " + f.getCanonicalPath ());
		System.out.println("--------------------------------------------------------------------------");
		for (File e: f.listFiles())
		{
			if (e.isFile())
				System.out.println(e.getName() + "" + e.length());
			if (e.isDirectory ())
			{
				System.out.println(e.getName () + "<Directorio>");
			}
		}
	}
}
