// En este caso se transforma el archivo f5 de UTF-8 a ISO-8859-1
// Creando un nuevo txt con el resultado (F5_ISO.txt)


package Ejemplos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ejemplo12
{
	public static void main (String [] args) throws IOException
	{
		InputStreamReader f_ent = new InputStreamReader(new FileInputStream("f5.txt"), "UTF-8");
		OutputStreamWriter f_eix = new OutputStreamWriter(new FileOutputStream("f5_ISO.txt"), "ISO-8859-1");
		
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
