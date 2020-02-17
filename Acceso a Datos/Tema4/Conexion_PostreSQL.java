package Tema4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_PostreSQL
{
	public static void main (String [] args) throws ClassNotFoundException, SQLException
	{
        String url = "jdbc: postgresql: //89.36.214.106: 5432 / geo_ad";
        String usuario = "geo_ad";
        String password = "geo_ad";

        Class.forName ( "org.postgresql.Driver");

        Connection con = DriverManager.getConnection (url, usuario, password);
        System.out.println ( "Conexión completada");
        con.close ();
    }
}

