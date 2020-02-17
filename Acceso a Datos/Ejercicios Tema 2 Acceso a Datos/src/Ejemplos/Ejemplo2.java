// En este ejemplo en lugar de tener la entrada desde un archivo, se recoge desde un ByteARrayInputStream
// Se inicializa diferente, pero el tratamiento es id�ntico
// En este caso los caracteres especiales saldr�an mal, ya que el InputStream ser�a el m�s adecuado

package Ejemplos;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Ejemplo2
{
	public static void main (String [] args) throws IOException
	{
		String entrada_1 = "Este es un byte array";
		byte [] entrada = entrada_1.getBytes ();
		ByteArrayInputStream bytearray_in = new ByteArrayInputStream(entrada);
		int c = bytearray_in.read();
		
		while (c != -1)
		{
			System.out.println ((char) c);
			c = bytearray_in.read ();
		}
		bytearray_in.close();
	}
}
