package Tema2;

import java.io.FileInputStream;
import java.io.IOException;

public class Leer_fichero_con_buffer_como_argumento_read
{
	public static void main (String [] args) throws IOException
	{
		FileInputStream f_in = new FileInputStream ("f2.txt");
		byte [] buffer = new byte [30];
		int n = f_in.read(buffer);
		
		while ( n!= -1)
		{
			for (int i = 0; i <n; i++)
			{
				System.out.println((char) buffer [i]);
				System.out.println("");
				n = f_in.read (buffer);
			}
			f_in.close();
		}
	}
}
