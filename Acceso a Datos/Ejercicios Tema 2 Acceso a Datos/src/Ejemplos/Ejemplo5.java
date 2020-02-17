// En este caso se trabaja sobre un archivo inexistente
// Se puede comprobar que el resultado será la creación del mismo
// Es muy importante cerrarlo para que se guarde
// Si se sustituye el contructor poniendo:
// FileOutputStream f_out = new FileOutputStream ( "f3.txt", true);
// Se añade al final más contenido, sin destruir el que ya habia


package Ejemplos;

import java.io.FileOutputStream;
import java.io.IOException;

public class Ejemplo5
{
	public static void main (String [] args) throws IOException
	{
		String text ="Contenido para el archivo";
		FileOutputStream f_out = new FileOutputStream("f3.txt");
		for (int i=0; i < text.length (); i ++)
		{
			f_out.write(text.charAt (i));
		}
		f_out.close ();
		}
}
