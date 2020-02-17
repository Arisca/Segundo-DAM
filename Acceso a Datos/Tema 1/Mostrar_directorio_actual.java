package Tema1;

import java.io.File;

public class Mostrar_directorio_actual
{
	public static void main (String [] ars)
	{
		File f = new File (".");
		System.out.println("Lista de archivos y directorios del directorio actual");
		System.out.println("------------------------------------------------------");
		for (String e : f.list ())
			System.out.println(e);				
	}
}
