package Ejercicio_Pe�agolosa;

import java.io.File;
import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {

		File foto = new File("Penyagolosa.bmp");
		
		Pe�agolosa fichero = new Pe�agolosa (foto);
		fichero.TransformaNegativo();
		fichero.TransformaOscuro();
		fichero.TransformaBlancoyNegro();	
	}

}