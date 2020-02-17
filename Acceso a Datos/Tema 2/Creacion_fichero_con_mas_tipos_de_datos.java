package Tema2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Creacion_fichero_con_mas_tipos_de_datos
{
	public static void main (String [] args) throws IOException
	{
		PrintStream f_out = new PrintStream (new FileOutputStream("fichero.txt"));
		
		float a = (float)5.25;
		String b = "Hola";
		f_out.print (b);
		f_out.println ("¿Qué tal?");
		f_out.println (a + 3);
		f_out.printf ("El número% d en hexadecimal es% x", 27,27);
		
		f_out.close();
	}
}
