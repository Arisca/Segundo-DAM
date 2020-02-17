package Tema2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Transformar_UTF8_enISO88591
{
	public static void main (String [] args) throws IOException
	{
		InputStreamReader f_ent = new InputStreamReader (new FileInputStream ("fileUTF.txt"), "UTF-8");
		OutputStreamWriter f_eix = new OutputStreamWriter (new FileOutputStream ( "fileISO.txt"), "ISO-8859-1");
		
		int caro = f_ent.read();
		while (caro != -1)
		{
			f_eix.write(caro);
			caro = f_ent.read();
		}
		f_eix.close();
		f_ent.close();
		
	}
}
