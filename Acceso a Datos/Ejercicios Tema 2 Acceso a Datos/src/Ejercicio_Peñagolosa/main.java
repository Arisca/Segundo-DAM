package Ejercicio_Peņagolosa;

import java.io.File;
import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {

		File foto = new File("Penyagolosa.bmp");
		
		Peņagolosa fichero = new Peņagolosa (foto);
		fichero.TransformaNegativo();
		fichero.TransformaOscuro();
		fichero.TransformaBlancoyNegro();	
	}

}