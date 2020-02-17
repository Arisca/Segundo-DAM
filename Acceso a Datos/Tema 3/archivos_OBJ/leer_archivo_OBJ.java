package archivos_OBJ;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class leer_archivo_OBJ
{
	public static void main (String [] args) throws IOException, ClassNotFoundException
	{
		ObjectInputStream f = new ObjectInputStream (new FileInputStream ( "Datos.obj"));
		
		Serializacion_datos d;
		try
		{
			while (true)
			{
				d = (Serializacion_datos) f.readObject ();
					System.out.println( "Nombre : " + d.getNombres());
					System.out.println( "Teléfono : " + d.getTelefono());
					System.out.println( "Email : " + d.getEmail());
					System.out.println( "Nota : " + d.getNota());
					System.out.println("------------------------------");
			}
			
		}
		catch (EOFException EOF) { f.close();}	
	}
}

