package Tema2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copiar_contenido_de_archivos
{
	public static void main (String [] args) throws IOException
	{
		FileInputStream f_in = new FileInputStream ("primerarchivo.txt");
		FileOutputStream f_out = new FileOutputStream ("archivocopia.txt");
		
		byte [] buffer = new byte [30]; // Se está leyendo de 30 en 30 bytes
		int num = f_in.read (buffer);
		while (num != -1)
		{
			f_out.write (buffer);
			num = f_in.read (buffer);
		}
		f_in.close();
		f_out.close();
	}
}
