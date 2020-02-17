package archivos_DAT;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Generando_archivo_DAT
{
	public static void main (String [] args) throws IOException
	{
		DataOutputStream f = new DataOutputStream (new FileOutputStream ("Datos.dat"));
		
		String [] nombres = {"Ana", "Luis", "Juan", "Marga"};
		int [] telefono = {615464676, 699877654, 650783419, 666958473};
		String [] email = {"Ana_Gonzalez@hotmail.com", "Bakalaka@gmail.com", "SuperJuan@hotmail.com", "Margarita_Flores@gmail.com"};
		double [] nota = {5.25, 8.5, 4.10, 6.00};
		
		for (int i = 0; i < 4; i++)
		{
			f.writeUTF (nombres[i]);
			f.writeInt (telefono [i]);
			f.writeUTF (email [i]);
			f.writeDouble(nota [i]);
		}
		f.close();
	}
}

