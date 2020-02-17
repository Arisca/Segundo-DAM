package Ejercicios;

import java.sql.SQLException;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import util.bd.GestionarRutasBD;
import util.bd.Ruta;

public class VistaRutaPostreSQL
{
	public static void main(String[] args) throws SQLException
	{
		ObjectContainer bd = Db4oEmbedded.openFile("Rutes.db4o");
		
		Ruta r = null;
		
		ObjectSet<Ruta> listado = bd.queryByExample(new Ruta());
		
		while (listado.hasNext()) {
			r = listado.next();
			System.out.println(r.getNombre() + ": " + r.getListadePuntos().size() + " punts. ");
		}

		bd.close();
	}
}
