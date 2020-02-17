// Métodos para obtener los hijos o el padre
// list ()	Vuelve un array de Strings con los nombres de todos los elementos contenidos en el File 
// listfiles ()	Vuelve un array de Filas con todos los elementos contenidos en el File
// getParent () 	Vuelve el nombre (string) del padre (si no existe por ser la raíz, volverá nulo) 
// getParentFile ()	Vuelve el padre como un File (si no existe por ser la raíz, volverá nulo) 
//
// Métodos para ver la existencia y características
// exists () 	Vuelve true si el archivo o directorio existe 
// isDirectory () 	Vuelve true si es un directorio 
// isFile () 	Vuelve true si es un archivo 
// length () 	Vuelve el tamaño del archivo en bytes 
// lastModified () 	Vuelve la fecha de modificación del archivo o directorio
// setLastModified ()	Actualiza la fecha de modificación del archivo o directorio
//
// Primero nos aseguramos de que el directorio existe y es un directorio
// Después se mejora volviendo el tamaño de cada archivo en un archivo, y especificando que es un directorio, si lo es
// Nos convendra listfiles () para poder mirar si es un archivo o directorio, el tamaño, ...
// También se ha aprovechado para crear un método estático listado (File), que mostrará el contenido del directorio
// donde apunta el File y así estructurarse un poco mejor



package Ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejemplo4
{
	public static void main (String [] args) throws IOException
	{
        System.out.println ( "Introduce un directorio:");
        String ent = new BufferedReader (new InputStreamReader (System.in)).readLine ();
        File f = new File (ent);
        if (f.exists ())
        {
            if (f.isDirectory ())
            {
                llistaDirectori (f);
            }
            else
                System.out.println ( "No es un directorio");
        }
        else
            System.out.println ( "No hay una carpeta");
    }
    
    private static void llistaDirectori (File f) throws IOException
    {
        System.out.println ( "Lista de archivos y directorios del directorio" + f.getCanonicalPath ());
        System.out.println ( "------------------------------------------- -------- ");
        
        for (File e: f.listFiles ())
        {
            if (e.isFile ())
                System.out.println (e.getName () + "" + e.length ());
            if (e.isDirectory ())
                System.out.println (e.getName () + "<Directorio>");
        }
        
    }
}
