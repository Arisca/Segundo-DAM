import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PasarRutasSerialObj
{
	public static void main(String[] args) throws EOFException, IOException 
	{
		DataInputStream fileData = new DataInputStream (new FileInputStream ("Rutas.dat"));
		ObjectOutputStream fileObject = new ObjectOutputStream (new FileOutputStream ("Rutas.obj"));
		
		ArrayList <PuntGeo> Lista;
		Ruta ruta;
		
		while (fileData.available() > 0 )
		{
			Lista = new ArrayList <PuntGeo> ();
			ruta = new Ruta ();
			ruta.setNombre(fileData.readUTF());
			ruta.setDesnivel(fileData.readInt());
			ruta.setDesnivel_Acumulado(fileData.readInt());
			Lista.clear();
			ruta.setListadePuntos(Lista);
			
			int Puntos = fileData.readInt();
			for (int i = 0; i< Puntos; i ++)
			{
				ruta.addPunto(fileData.readUTF(), fileData.readDouble(), fileData.readDouble());
			}
			ruta.MostrarRuta();
			System.out.println ("\n");
			fileObject.writeObject(ruta);
		}
		fileObject.close();
		fileData.close();
	}
}
