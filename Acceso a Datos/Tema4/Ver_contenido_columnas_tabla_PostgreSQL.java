package Tema4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Ver_contenido_columnas_tabla_PostgreSQL
{
	public static void main (String [] args) throws ClassNotFoundException, SQLException
	{
        String url = "jdbc: postgresql: //89.36.214.106: 5432 / geo_ad";
        String usuario = "geo_ad";
        String password = "geo_ad";

        Connection con = DriverManager.getConnection (url, usuario, password);
        
        Statement st = con.createStatement ();
        ResultSet rs = st.executeQuery ( "SELECT * FROM instituto");
        while (rs.next ()) {
 
            System.out.println (rs.getString (2));
        }
        st.close ();
   
        con.close ();
    }
}

