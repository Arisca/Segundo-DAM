// En este ejemplo se copia el contenido de f2.txt en el fichero f4.txt
// En lugar de ir byte a byte, se ira de 30 en 30 con un buffer de 30 posiciones
// Se podria cometer el error de escribir siempre los 30 caracteres
// Para hacerlo de forma correcta, nos aprovecharemos de que read (buffer) devuelve el numero de bytes realmente leídos
// para escribir exactamente este numero se sustituira la linea:
// f_out.write(buffer);
// por:
// f_out.write (buffer, 0, num);
// De esa forma se copiara el texto de f4 identico a f2

package Ejemplos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejemplo6
{
	public static void main (String [] args) throws IOException
	{
		FileInputStream f_in = new FileInputStream("f2.txt");
		FileOutputStream f_out = new FileOutputStream ("f4.txt");
		
		byte [] buffer = new byte [30];
		int num = f_in.read (buffer);
		
		while (num != -1)
		{
			f_out.write(buffer);
			num = f_in.read (buffer);
		}
		f_in.close ();
		f_out.close ();
	}
}
	
