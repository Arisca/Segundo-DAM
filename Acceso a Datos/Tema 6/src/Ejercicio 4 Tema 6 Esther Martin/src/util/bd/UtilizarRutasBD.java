package util.bd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtilizarRutasBD
{
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		GestionarRutasBD grutas = null;
		try {
			grutas = new GestionarRutasBD();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String [] nombres = { "Les Useres", "Las Torrocelles", "Loma Bernat", "Xodos (Molino)", "El Marinet", "San Juan"};
		double [] latitudes = {40.158126, 40.196046, 40.219210, 40.248003, 40.250977, 40.251221};
		double [] longitudes = {-0.166962, -0.227611, -0.263560, -0.296690, -0.316947, -0.354052};
		
		Ruta r = new Ruta ();
		r.setNombre ("Peregrinos de Les Useres");
		r.setDesnivel (896);
		r.setDesnivel_Acumulado (234);
		
		 for (int i = 0; i <6; i ++)
		 { 
	         r.addPunto (nombres [i], latitudes [i], longitudes [i]); 
	     }
		 
		 try {
			grutas.insertar(r);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 grutas.buscar(2).MostrarRuta(); 

		 ArrayList<util.bd.Ruta> lista = null;
		try {
			lista = grutas.listado();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	        for (int i = 0; i <lista.size (); i ++)
	        { 
	            lista.get (i).MostrarRuta (); 
	        }
	        
	     grutas.borrar(3);
	     grutas.close();
	}

}
