// Programa para sacar la lista de archivos y directorios del directorio actual
// Para hacer referencia al directorio actual se utilizará ".", que sirve para todos los Sistemas
// Por defecto, el directorio activo es el directorio del proyecto
// Para obtener la lista de elementos (archivos y directorios) se utiliza el método list() de la clase File

package Ejemplos;

import java.io.File;

public class Ejemplo1
{
	public static void main (String [] args)
	{
		File f = new File ( ".");
		System.out.println ( "Lista de archivos y directorios del directorio actual");
		System.out.println ( "------------------------------------------- -------- ");
			
		for (String e: f.list ())
			System.out.println (e);
		}
	}
