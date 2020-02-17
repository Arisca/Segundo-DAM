//Métodos para obtener el nombre o ruta
//getName () 	Vuelve el nombre del archivo o directorio 
//getPath () 	Vuelve la ruta (relativa) 
//getAbsolutePath () 	Vuelve la ruta absoluta 
//getCanonicalPath ()	Vuelve la ruta absoluta sin posibles redundancias
//
// En este ejemplo se intenta mostrar las redundancias, que get CanonicalPath() resuelte completamente.
// Para ilustrar el ejemplo se hace referencia a una rchivo de forma complicada.
// Suponemos que el directorio activo es /home/usuario/workspace/Tema1 y queremos hacer referencia
// a un archivo situado en un subdirectorio archivos


package Ejemplos;

import java.io.File;
import java.io.IOException;

public class Ejemplo3
{
	public static void main (String [] args) throws IOException
	{
		File f = new File ( "archivos /../ archivos / f1.txt");
		System.out.println ( "Nombre del archivo:" + f.getName ());
		System.out.println ( "Ruta del archivo:" + f.getPath ());
		System.out.println ( "Ruta absoluta del archivo:" + f.getAbsolutePath ());
		System.out.println ( "Ruta canónica del archivo:" + f.getCanonicalPath ());
	}
}
