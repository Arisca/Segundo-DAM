import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Accediendo_carpetas
{
	public static void main (String [] args) throws IOException
	{
		System.out.println("Visitando mi carpeta de estudio: ");
		File f = new File ("D:/DAM");
		File [] fichero = f.listFiles();
		if (fichero == null)
			System.out.println("No existe nada en su interior");
		else
		{
			int x = 1;
			System.out.println(x + ".- " +f.list()[1] + " <Directorio principal>" + fichero[x].length()+" bytes ");
			
			for (x = 1; x < fichero.length; x++)
			{
				if (fichero [x].isDirectory())
				{
					System.out.println ((x+1) + ".- "+f.list()[x]+ "  <Directorio>" + fichero[x].length()+" bytes ");
				}
				else
					System.out.println ((x+1)+".- "+f.list()[x]+ "  <Archivo>  "+ fichero[x].length()+" bytes ");
			}
		}
		Scanner teclado = new Scanner (System.in);
		int op = -2;
		do
		{
			System.out.println();
			System.out.println("Elige la carpeta que quieres inspeccionar (-1 para salir)");
			op = teclado.nextInt();
			if (op == -1)
			{
				f = f.getParentFile();
				fichero = f.listFiles();
				int x = 1;
				System.out.println(x+".- "+ f.getPath()+ "   <Directorio principal>" + fichero[x].length()+" bytes ");
				for (x = 1; x < fichero.length; x++)
					if (fichero [x].isDirectory())
					{
						System.out.println(x+".- "+ f.getPath()+ "   <Directorio principal>" + fichero[x].length()+" bytes ");
					}
					else
						System.out.println ((x+1)+".- "+fichero[x]+ "   <Archivo>   " + fichero[x].length()+" bytes");
			}
			else if (op != -1 && op > 1 && op <= fichero.length)
			{
				if (fichero [op-1].isDirectory())
				{
					f = fichero [op-1].getAbsoluteFile();
					fichero = f.listFiles();
					int x=1;
					System.out.println(x+".- "+ f.getPath()+ "   <Directorio principal>" + fichero[x].length()+" bytes");
					
					for (x = 0; x < fichero.length; x++)
						if (fichero [x].isDirectory())
						{
							System.out.println((x+1)+".- "+fichero[x]+ "  <Directorio>" + fichero[x].length()+" bytes");
						}
						else
							System.out.println((x+1)+".- "+fichero[x]+"  <Archivo>  " + fichero[x].length()+" bytes ");
				}
				else
				{
					System.out.println("Es un fichero. Elige un directorio: ");
				}
			}
		}
		while (op != -1);
		System.out.println(" Has salido del programa ");
		teclado.close();	
	}
}
