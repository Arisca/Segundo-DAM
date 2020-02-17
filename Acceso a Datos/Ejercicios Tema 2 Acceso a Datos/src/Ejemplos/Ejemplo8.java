// Igual que el ejemplo2 pero en este caso utilizando el argumento read
// Se deberian de leer bien todos los caracteres


package Ejemplos;

import java.io.FileReader;
import java.io.IOException;

public class Ejemplo8
{
	public static void main (String [] args) throws IOException
	{
		FileReader f_in = new FileReader ( "f2.txt");
        char [] buffer = new char [30];
        int n = f_in.read (buffer);
        while (n != -1)
        {
            for (int i = 0; i <n; i ++)
                System.out.print (buffer [i]);
            	System.out.println ("");
            	n = f_in.read (buffer);
        }
        f_in.close ();		
	}
}
