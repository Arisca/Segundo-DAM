import java.io.File;
import java.io.IOException;

public class Contenido_Carpetas
{
	public static void main (String [] args) throws IOException
	{
		System.out.println("Vamos a hacer una visita al directorio actual: ");
		File f = new File (".");
		for (String e: f.list())
			System.out.println(e);
		
		System.out.println("");
		
		System.out.println("Ahora visitamos mi carpeta de trabajo: ");
		File f2 = new File ("D:/DAM");
		for (String DAM: f2.list())
			System.out.println(DAM);
	}	
}
