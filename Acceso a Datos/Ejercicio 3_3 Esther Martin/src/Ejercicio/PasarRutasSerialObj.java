package Ejercicio;


import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class PasarRutasSerialObj
{
	public static void main(String[] args) throws EOFException, IOException
	{
		DataInputStream fileData = new DataInputStream (new FileInputStream ("Rutes.dat"));
		ObjectOutputStream fileObject = new ObjectOutputStream (new FileOutputStream("Rutas.obj"));
		
		ArrayList <PuntGeo> Lista;
		
		Ruta Ru;
		while (fileData.available() > 0)
		{
			Lista = new ArrayList<PuntGeo>();
			Ru = new Ruta ();
			Ru.setNombre(fileData.readUTF());
			Ru.setDesnivel(fileData.readInt());
			Ru.setDesnivel_Acumulado(fileData.readInt());
			Lista.clear();
			Ru.setListadePuntos(Lista);
			
			int Puntos = fileData.readInt();
			for (int i = 0; i < Puntos; i ++)
			{
				Ru.addPunto(fileData.readUTF(), fileData.readDouble(), fileData.readDouble());
			}
			Ru.MostrarRuta();
			System.out.println ("\n");
			fileObject.writeObject(Ru);
		}
		fileObject.close();
		fileData.close();
	}
}
