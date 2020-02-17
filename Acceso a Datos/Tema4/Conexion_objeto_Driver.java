package Tema4;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion_objeto_Driver
{
	public static void main (String [] args) throws ClassNotFoundException, SQLException
	{
        String url = "jdbc: postgresql: //89.36.214.106: 5432 / geo_ad";
        String usuario = "geo_ad";
        String password = "geo_ad";

        Driver driver = DriverManager.getDriver (url);

        Properties properties = new Properties ();
        properties.setProperty ( "user", usuario);
        properties.setProperty ( "password", password);

        Driver con = driver;
        System.out.println ( "Conexión completada a través de Driver");
        ((Connection) con).close ();
    }
}

