package Tema1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Navegar_Directorios_Mostrar_Opciones
{
	private static File f;
	private static Scanner teclado;
	private static int op;
	
	public static void main (String [] args) throws IOException
	{
		System.out.println(" ** Lista de los ficheros del directorio Padre ** ");
		System.out.println();
		f = File.listRoots() [0];
		File [] fichero = f.listFiles();
		
		if (fichero == null)
			System.out.println("No existen ficheros en el directorio especificado");
		else
		{
			int x = 0;
			System.out.println (x+ ".-  "+ File.listRoots()[0] + "   <Directorio Padre>");
			
			for (x = 0; x < fichero.length; x ++)
				if (fichero [x].isDirectory ())
				{
					System.out.println ((x+1) + ".- "+fichero[x]+ "  <Directorio>");
				}
				else
					System.out.println ((x+1)+".- "+fichero[x]+ "  <Archivo>  "+ fichero[x].length()+" bytes ");
		}
		
		teclado = new Scanner (System.in);
		op = -2;
				do
				{
					System.out.println();
					System.out.println ("Introducir el nombre del directorio que quieres ver (-1 si desea salir): ");
					op = teclado.nextInt();
					if (op == 0)
					{
						f = f.getParentFile();
						fichero = f.listFiles();
						int x=0;
						System.out.println (x+".- "+ f.getPath()+ "   <Directorio Padre>");
						for (x = 0; x < fichero.length; x++)
							if (fichero[x].isDirectory())
							{
								System.out.println ((x+1)+".- "+fichero[x]+ "   <Directorio>");
							}
							else
								System.out.println ((x+1)+".- "+fichero[x]+ "   <Archivo>   " + fichero[x].length()+" bytes");
					}
					
					else if (op != -1 && op > 0 && op <= fichero.length)
					{
						if (fichero [op-1].isDirectory())
						{
							f = fichero [op-1].getAbsoluteFile();
							fichero = f.listFiles();
							int x=0;
							System.out.println (x+".- "+ f.getPath()+ "   <Directorio Padre>");
							
							for (x=0; x<fichero.length; x++)
								if (fichero[x].isDirectory())
								{
									System.out.println ((x+1)+".- "+fichero[x]+ "  <Directorio>");
								}
								else
									System.out.println((x+1)+".- "+fichero[x]+"  <Archivo>  " + fichero[x].length()+" bytes ");
						}
						else
						{
							System.out.println ("Es un fichero. Elige un directorio: ");
						}
					}
				}
				while (op != -1);
				System.out.println ("** Has salido del programa **");
				teclado.close();
			}
		}