package Tema2;

import java.io.FileWriter;
import java.io.IOException;

public class Creacion_fichero_con_contenido_caracteres_especiales
{
	public static void main (String [] args) throws IOException
	{
		String texto = "Contenido para el archivo. Ahora ya sin miedo a caracteres especiales: ç, à, uno, ...";
		FileWriter f_out = new FileWriter ("ficherocontenidoespecial.txt");
		
		for (int i = 0; i < texto.length(); i++)
		{
			f_out.write(texto.charAt (i));
		}
		f_out.close();
	}
}
