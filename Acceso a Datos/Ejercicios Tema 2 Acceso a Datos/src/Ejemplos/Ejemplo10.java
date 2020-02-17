// En este ejemplo se ve con detalle, el PrintStream, que permite basicamente 3 cosas:
// 1. Escribir datos de m�s de un tipo de datos. Por ejemplo  print (05:25) escribe un n�mero real, y  print ( "Hola") escribe todo un string.
// 2. Dar un determinado formato a la salida, con toda la funcionalidad a la que estamos acostumbrados con  printf
// 3. Escribir toda una l�nea con println , es decir, terminar un dato con el retorno de carro, para bajar de l�nea.
//
// Se creara el archivo f6.txt (si ya exist�a borrar� el contenido anterior)



package Ejemplos;

import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejemplo10
{
	public static void main (String [] args) throws IOException
	{
		PrintStream f_out = new PrintStream(new FileOutputStream("f6.txt"));
		
		float a = (float) 05.25;
		String b = "Hola";
		f_out.print(b);
		f_out.println ("�Qu� tal?");
		f_out.println (a + 3);
		f_out.printf("El n�mero % d en hexadecimal es % x", 27,27);
		
		f_out.close();
	}
}
