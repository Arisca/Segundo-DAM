// Utilizando el archivo "Rutes.dat"
// Hacer una clase ejecutable (con main) que coja los datos del fichero y los saque por la pantalla

package Ejercicios;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ejercicio_3_1
{
	private static DataInputStream file;

	public static void main(String[] args) throws IOException
	{
		file = new DataInputStream (new FileInputStream ("Rutes.dat"));
		
		while (file.available () > 0)
		{
			System.out.println ("Ruta: " + file.readUTF());
			System.out.println("Desnivel: " + file.readInt());
			System.out.println("Desnivel acumulado: " + file.readInt());
			
			int puntos = file.readInt();
			System.out.println ("Tiene " + puntos + "puntos ");
			
			for (int i = 0; i < puntos; i++)
			{
				System.out.println ("Puntos " + (i + 1) + " : " + file.readUTF() + " (" + file.readDouble() + " , " + file.readDouble () + ")");
			}
			System.out.println ("");
		}
	}
}
