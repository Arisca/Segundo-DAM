package Tema2;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Transformar_archivo_con_decoradores
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader f_ent = new BufferedReader (new FileReader ("archivoatransformar.txt"));
		PrintWriter f_eix = new PrintWriter (new OutputStreamWriter (new FileOutputStream ("fileISO.txt"), "ISO-8859-1"));
		
		String cad = f_ent.readLine ();
		while (cad !=null)
		{
			f_eix.println (cad);
			cad = f_ent.readLine ();
		}
		f_eix.close();
		f_ent.close();		
	}
}
