// Se realiza un programa que permite navegar por los directorios de la unidad principal del sistema de archivos:.
//
// Debe empezar por la raíz (/ en Linux; c: \ en Windows). Recuerde que el método estático File.listRoots () [0] nos da la raíz.
// Debe indicar el directorio que está mostrando.
// Debe poner como primera opción ir al directorio padre (opción 0).
// Debe poner un número delante de cada archivo o subdirectorio que se está mostrando. Obsérvese que este número comienza con 1 (el 0 es para el padre). Si se ha guardado en // un array la lista de archivos y directorios del directorio actual, recuerde que el primer elemento es el 0 (pero vosotros el mostraréis con un 1 delante).
// En caso de ser un archivo debe decir el tamaño. En caso de ser un subdirectorio, debe indicarse con <directorio>
// Posteriormente debe dejar introducir un número. Las opciones serán:
// -1 para terminar 0 ir al directorio padre.
// Si se ha elegido el 0 (para ir al padre) se debe controlar que existe el padre (en el caso de la raíz, no tiene). Si no lo tiene, no hay que hacer nada.
// Cualquier otro número debe servir para cambiar a este directorio como el directorio activo. Si era un archivo, no tiene que hacer nada (en la imagen, no debe poder ir al // 19, ya que es un archivo).
// Se debe controlar que hay permiso de lectura sobre un directorio, antes de cambiar a él, sino dará error (en la imagen, por ejemplo, seguramente no se podrá cambiar el // directorio root , ya que no tendremos permiso de lectura sobre él ). Esta comprobación debe hacerse antes de cambiar el directorio elegido.
// Y hay que controlar que el número introducido está en el rango correcto (en la imagen, de -1 hasta 27)



package Ejercicios;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1
{
	private static File f;
	private static Scanner teclado;
	private static int op;

	public static void main (String [] args) throws IOException
	{
		System.out.println(" ** Lista de los ficheros del directorio Padre ** ");
		System.out.println();
		f = File.listRoots () [0];
		File [] fichero = f.listFiles();
		
		if (fichero == null)
			System.out.println ("No existen ficheros en el directorio especificado");
		else
		{
			int x=0;
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
	

