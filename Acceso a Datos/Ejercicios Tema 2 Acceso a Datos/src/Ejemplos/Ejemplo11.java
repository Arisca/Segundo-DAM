// En este ejemplo se crea el archivo f7_ent con:
// Primera
// Segunda
// Tercera
// Se utiliza un BufferedReader para leer lineas y el PrintWrite para escribirlas
// Con el fin de modificar el archivo anterior y crear uno nuevo (f7_eix)
// que contenga:
// 1.- Primera
// 2.- Segunda
// 3.- Tercera


package Ejemplos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejemplo11
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader f_ent = new BufferedReader (new FileReader("f7_ent.txt"));
		PrintWriter f_eix = new PrintWriter (new FileWriter ("f7_eix.txt"));
		String cad = f_ent.readLine();
		
		int i = 0;
		
		while (cad != null)
		{
			i ++;
			f_eix.println (i + ".-" + cad);
			cad = f_ent.readLine ();
		}
		f_eix.close();
		f_ent.close();
	}
}
