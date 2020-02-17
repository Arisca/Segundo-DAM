// Igual que el ejemplo1, pero utilizando ahora El FileInputStream por FileReader
// Seguramente ahora lea los caracteres bien

package Ejemplos;

import java.io.FileReader;
import java.io.IOException;

public class Ejemplo7
{
	public static void main (String [] args) throws IOException
	{
		FileReader f_in = new FileReader ("f1.txt");
		int c = f_in.read();
		
		while ( c != -1)
		{
			System.out.println ((char) c);
			c = f_in.read ();
		}
		f_in.close();
	}
}
