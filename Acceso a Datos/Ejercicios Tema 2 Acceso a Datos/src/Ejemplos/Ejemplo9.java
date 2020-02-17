// En este ejemplo creamos el archivo f5 y comprobamos que el resultado es la creaccion del mismo


package Ejemplos;

import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo9
{
	public static void main (String [] args) throws IOException
	{
		String texto = "Contenido para el archivo. Ahora ya sin miedo a caracteres especiales: ç, à, uno, ...";
		FileWriter f_out = new FileWriter ("f5.txt");
		for (int i = 0; i < texto.length(); i ++)
		{
			f_out.write(texto.charAt(i));
		}
		f_out.close();
	}
}
