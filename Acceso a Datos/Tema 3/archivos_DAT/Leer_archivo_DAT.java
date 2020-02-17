package archivos_DAT;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Leer_archivo_DAT
{
	public static void main (String [] args) throws IOException
	{
		DataInputStream f = new DataInputStream (new FileInputStream ("Datos.dat"));
		
		while(f.available () >0)
		{
			System.out.println ( "Nombres: " + f.readUTF ());
			System.out.println ( "Telefono: " + f.readInt ());
			System.out.println ( "Email: " + f.readUTF ());
			System.out.println ( "Nota: " + f.readDouble ());
			System.out.println ();
		}
			f.close ();
	}
}

