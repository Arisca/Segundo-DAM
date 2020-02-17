package Tema4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_SQLite
{
	public static void main (String [] args) throws ClassNotFoundException, SQLException
	{
        String url = "jdbc: sqlite: proveta.sqlite";
       
        Class.forName ( "org.sqlite.JDBC");

        Connection con = DriverManager.getConnection (url);
        System.out.println ( "Conexión completada");
        con.close ();
    }
}

