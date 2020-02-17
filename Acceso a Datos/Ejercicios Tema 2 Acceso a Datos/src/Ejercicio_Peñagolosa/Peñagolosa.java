// Este primer ejercicios es para tratamiento de bytes, ya que se tratará de modificar una imagen.
// Para poder probarlo puede utilizar la imagen Penyagolosa.bmp 
// y el debe copiar en el directorio raíz del proyecto Tema2 para un funcionamiento más cómodo.
//
// No se pretende construir un editor de imágenes.
// Tan sólo pretendemos tomar la información del archivo byte a byte, reslitzar alguna transformación en los bytes y guardarla en otro archivo.
//
// El formato de un archivo bmp , aproximadamente es el siguiente:
// En los 54 primeros bytes se guarda información diversa, como el tamaño de la imagen, paleta de colores, ...
// A partir de ahí se guarda cada punto de la imagen como 3 bytes ,
// uno para el rojo (R), uno para el verde (G) ii uno para el azul (B), yendo de izquierda a derecha y de arriba bajo.
 
package Ejercicio_Peñagolosa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

	public class Peñagolosa
	{
		private File foto;
	
		public Peñagolosa (File file_entrada)
		{
			String nombre_archivo = file_entrada.getName();
		
			if (file_entrada.exists())
			{
				if (nombre_archivo.endsWith(".bmp"))
				{
					System.out.println ("CORRECTO!!; " + file_entrada + " Es un archivo BMP");
					this.foto = file_entrada;
					System.out.println (foto.getAbsolutePath());
				}
				else
				{
					System.out.println ("LO SIENTO!! El archivo " + file_entrada + " existe pero NO es un archivo BMP");
				}
			}
			else
			{
				System.out.println ("LO SIENTO!! pero el archivo "+ file_entrada +" no existe");
			}
		}

		public void TransformaNegativo() throws IOException
		{
			File foto = this.foto;
			FileInputStream foto_in = new FileInputStream(foto);
			FileOutputStream foto_out = new FileOutputStream(foto.getName()+ "_negativo.bmp");
			int numero = foto_in.read();
			int contador = 0;
			while (numero != -1)
			{
				if (contador <= 53)
				{
					foto_out.write(numero);
					contador ++;
				}
				else
				{
					foto_out.write(255-numero);
				}
				numero = foto_in.read();
			}
			foto_in.close();
			foto_out.close();
}

		public void TransformaOscuro () throws IOException
		{
			File foto = this.foto;
			FileInputStream foto_in = new FileInputStream (foto);
			FileOutputStream foto_out = new FileOutputStream (foto.getName() + "_oscuro.bmp");
			int numero = foto_in.read();
			int contador = 0;
			while (numero != -1)
			{
				if (contador <= 53)
				{
					foto_out.write(numero);
					contador ++;
				}
				else
				{
					foto_out.write(numero/2);
				}
				numero = foto_in.read();
			}
			foto_in.close();
			foto_out.close();
		}
		
		public void TransformaBlancoyNegro () throws IOException
		{
			File foto = this.foto;
			FileInputStream foto_in = new FileInputStream (foto);
			FileOutputStream foto_out = new FileOutputStream (foto.getName() + "_blancoynegro.bmp");
			int numero = foto_in.read();
			int contador = 0;
			while (numero != -1)
			{
				if (contador <= 53)
				{
					foto_out.write(numero);
					contador ++;
				}
				else
				{
					int R = numero;
	    	    		numero = foto_in.read();
	    	    	int G = numero;
	    	    		numero = foto_in.read();
	    	    	int B = numero;
	    	        	foto_out.write((R+G+B)/3);
	    	        	foto_out.write((R+G+B)/3);
	    	        	foto_out.write((R+G+B)/3);		
				}
				numero = foto_in.read();
			}
			foto_in.close();
			foto_out.close();
		}
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
}
