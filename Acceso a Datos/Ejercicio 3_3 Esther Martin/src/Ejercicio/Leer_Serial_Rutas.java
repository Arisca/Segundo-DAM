package Ejercicio;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Leer_Serial_Rutas
{
	private static DataInputStream file;

	public static void main(String[] args) throws IOException
	{
		file = new DataInputStream( new FileInputStream ("Rutes.dat"));
		while (file.available() > 0)
		{
			System.out.println("Nombre :" + file.readUTF());
			System.out.println("Denivel : " + file.readInt());
			System.out.println("Desnivel Acumulado :" + file.readInt());
			int Puntos = file.readInt();
			System.out.println("N�mero de puntos : "  + Puntos );
			
			for(int i = 0; i < Puntos; i++)
			{
				System.out.println("Punto n�mero : " + (i+1) + "Nombre : " + file.readUTF() + "( " + file.readDouble() + file.readDouble() + ") ");
			}
			System.out.println("");
		}
	}
}
