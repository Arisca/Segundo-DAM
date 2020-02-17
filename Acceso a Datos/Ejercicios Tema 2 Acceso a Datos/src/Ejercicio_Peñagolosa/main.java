package Ejercicio_Peñagolosa;

import java.io.File;
import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {

		File foto = new File("Penyagolosa.bmp");
		
		Peñagolosa fichero = new Peñagolosa (foto);
		fichero.TransformaNegativo();
		fichero.TransformaOscuro();
		fichero.TransformaBlancoyNegro();	
	}

}