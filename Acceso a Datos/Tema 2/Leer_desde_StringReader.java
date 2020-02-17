package Tema2;

import java.io.IOException;
import java.io.StringReader;

public class Leer_desde_StringReader
{
	public static void main (String [] args) throws IOException
	{
		String ent = "Hola, este es un String normal y corriente";
		StringReader f_in = new StringReader (ent);
		int c = f_in.read();
		
		while ( c != -1)
		{
			System.out.println((char) c);
			c = f_in.read ();
		}
		f_in.close();
	}
}
