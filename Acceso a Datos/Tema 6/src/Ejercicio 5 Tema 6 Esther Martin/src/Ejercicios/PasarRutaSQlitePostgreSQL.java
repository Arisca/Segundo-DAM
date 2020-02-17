package Ejercicios;

import java.sql.SQLException;
import util.bd.GestionarRutasBD;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class PasarRutaSQlitePostgreSQL 
{
	public static void main(String[] args) throws SQLException
	{
		ObjectContainer bd = Db4oEmbedded.openFile("Rutas.db4o");
		GestionarRutasBD gRutes = new GestionarRutasBD();
		
		bd.store(gRutes.listado());
		
		bd.close();
	}
}
