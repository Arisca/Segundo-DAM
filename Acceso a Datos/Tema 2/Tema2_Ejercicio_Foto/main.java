package Tema2_Ejercicio_Foto;


import java.io.File;
import java.io.IOException;

public class main
{

	public static void main(String[] args) throws IOException {

		File foto = new File("Penyagolosa.bmp");
		
		Penyagolosa fichero = new Penyagolosa (foto);
		fichero.TransformaNegativo();
		fichero.TransformaOscuro();
		fichero.TransformaBlancoyNegro();	
	}

}

