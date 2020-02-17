package archivos_OBJ;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Generar_archivo_OBJ
{
	private static ObjectOutputStream f;

	public static void main (String [] args) throws IOException
	{
		f = new ObjectOutputStream (new FileOutputStream ("Datos.obj"));
		
		String [] nombres = {"Ana", "Luis", "Juan", "Marga"};
		int [] telefono = {615464676, 699877654, 650783419, 666958473};
		String [] email = {"Ana_Gonzalez@hotmail.com", "Bakalaka@gmail.com", "SuperJuan@hotmail.com", "Margarita_Flores@gmail.com"};
		double [] nota = {5.25, 8.5, 4.10, 6.00};
		
		Serializacion_datos d;
		
		for (int i = 0; i < 4; i++)
		{
			d = new Serializacion_datos (i + 1, nombres [i], telefono [i], email [i], nota [i]);
			f.writeObject(d);
		}
	}
}
