package Tema2;

import java.io.FileOutputStream;
import java.io.IOException;

public class Creacion_fichero_con_contenido
{
	public static void main (String [] args) throws IOException
	{
		String texto = "Contenido para el archivo";
		FileOutputStream f_out = new FileOutputStream ("f3.txt");
		// FileOutputStream f_out = new FileOutputStream ("f3.txt, true"); -> Al ejecutarlo el contenido se añade al final, sin destruir lo que ya había
		for (int i = 0; i < texto.length(); i++)
		{
			f_out.write (texto.charAt (i));
		}
		f_out.close ();
	}
}
