// Ahora utiliamos el buffer como argumento de read. Se crea el archivo f2.txt
// Se recuerda que se esta leyendo un archivo txt desde un InputStream, cosa nada conveniente
// ya que algunos caracteres no saldrán bien. Se arregla con los flujos orientados a carácter


package Ejemplos;

import java.io.FileInputStream;
import java.io.IOException;

public class Ejemplo4
{
	public static void main (String [] args) throws IOException
	{
		FileInputStream f_in = new FileInputStream("f2.txt");
		byte [] buffer = new byte [30];
		int n = f_in.read(buffer);
		
		while (n != -1)
		{
			for (int i = 0; i < n; i ++)
				System.out.print ((char) buffer [i]);
				System.out.println ("");
				n = f_in.read (buffer);
		}
		f_in.close();
	}
}
