import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Leer_Rutas_Serial
{
	public static void main(String[] args) throws IOException 
	{
		DataInputStream file = new DataInputStream(new FileInputStream("Rutas.dat"));
		
		while (file.available()>0) 
		{
			System.out.println("Ruta : " + file.readUTF());
			System.out.println("Denivel : " + file.readInt());
			System.out.println("Desnivel Acumulado : " + file.readInt());
			int punts = file.readInt();
			System.out.println("Tiene " + punts + " Puntos");
			for(int i=0;i<punts;i++) {
				System.out.println("Punto " + (i+1) + ": " + file.readUTF() + " (" + file.readDouble() + ", " + file.readDouble() + ")");
				}
			System.out.println("");
		}
	}

}