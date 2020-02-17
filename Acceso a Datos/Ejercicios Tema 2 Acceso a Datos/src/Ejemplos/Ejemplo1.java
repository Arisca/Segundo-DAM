// Se crea el fichero f1.txt en el directorio del proyecto
// con el texto "Hola, ¿qué tal?"
// Lo que hace el programa es sacar por pantalla car'acter a caracter (en lineas diferentes)


package Ejemplos;

import java.io.FileInputStream;
import java.io.IOException;

public class Ejemplo1
{
	public static void main (String [] args) throws IOException
	{
		FileInputStream file_in = new FileInputStream("f1.txt");
		int c = file_in.read();
		
		while (c != -1)
		{
			System.out.println ((char) c);
			c = file_in.read ();
		}
		
		file_in.close ();
	}
}
