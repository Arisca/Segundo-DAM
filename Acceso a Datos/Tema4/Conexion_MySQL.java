package Tema4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_MySQL
{
	public static void main (String [] args) throws ClassNotFoundException, SQLException
	{
        String url = "jdbc: mysql: // 89.36.214.106 : 3306 / factura";
        String usuario = "factura";
        String password = "factura";

        Class.forName ( "com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection (url, usuario, password);
        System.out.println ( "Conexión completada");
        con.close ();
    }
}