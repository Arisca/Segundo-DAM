package Tema4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_Oracle
{
	public static void main (String [] args) throws ClassNotFoundException, SQLException
	{
        String url = "jdbc: oracle: thin: @ 94177240173: 1521: ORCL";
        String usuario = "scott";
        String password = "tiger";

        Class.forName ( "oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection (url, usuario, password);
        System.out.println ( "Conexión completada");
        con.close ();
    }
}
