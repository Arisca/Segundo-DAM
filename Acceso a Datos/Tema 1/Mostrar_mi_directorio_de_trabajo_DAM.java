package Tema1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Mostrar_mi_directorio_de_trabajo_DAM
{
	private static File f;
	private static Scanner teclado;
	private static int op;
	
	public static void main (String [] args) throws IOException
	{
		// Mostrar solo el contenido de la carpeta en cuestion
		System.out.println("Este es el contenido de mi carpeta de Trabajo de Segundo de DAM :");
		System.out.println("");
		f = new File ("D:/DAM");	
		for (String e: f.list ())
			System.out.println(e);
		
		// Menu con opciones para entrar en el directorio en concreto especificado detalles
			System.out.println("-----------------------------------------------");
			System.out.println("Mostrando el contenido con detalle :");
			System.out.println();
			File [] fichero = f.listFiles();
			if (fichero == null)
				System.out.println("No existe contenido en su interior");
			else
			{
				int x = 1;
				System.out.println(x + ".- " +File.listRoots()[1] + " <Directorio principal>" + fichero[x].length()+" bytes ");
				
				for (x = 1; x < fichero.length; x++)
				{
					if (fichero [x].isDirectory())
					{
						System.out.println ((x+1) + ".- "+fichero[x]+ "  <Directorio>" + fichero[x].length()+" bytes ");
					}
					else
						System.out.println ((x+1)+".- "+fichero[x]+ "  <Archivo>  "+ fichero[x].length()+" bytes ");
				}
			}
			teclado = new Scanner (System.in);
			op = -2;
			do
			{
				System.out.println();
				System.out.println("Elige la carpeta que quieres inspeccionar (-1 para salir)");
				op = teclado.nextInt();
				if (op == 1)
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
							
							
						
					
					
				
	


								
						
					
						
				
			
				
			
		
		
	

