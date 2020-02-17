package Tema1;

import java.io.File;
import java.io.IOException;

public class Mostrar_contenido_subdirectorio
{
	public static void main (String [] args) throws IOException
	{
		File f = new File ("archivos/../archivos/f1.txt");
		System.out.println ("Nombre del archivo : " +f.getName());
		System.out.println("Ruta del archivo : " +f.getPath());
		System.out.println("Ruta absoluta del archivo : " +f.getAbsolutePath());
		System.out.println("Ruta canónica del archivo : " +f.getCanonicalPath());
	}
}
