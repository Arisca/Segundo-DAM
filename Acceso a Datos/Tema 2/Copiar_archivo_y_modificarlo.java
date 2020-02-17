package Tema2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Copiar_archivo_y_modificarlo
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader f_ent = new BufferedReader (new FileReader ("archivo_entrada.txt"));
		PrintWriter f_eix = new PrintWriter (new FileWriter ("archivo_salida.txt"));
		String cad = f_ent.readLine();
		
		int i = 0;
		while (cad != null)
		{
			i ++;
			f_eix.println (i + ".-" + cad);
			cad = f_ent.readLine();
		}
		f_eix.close();
		f_ent.close();
	}
}
