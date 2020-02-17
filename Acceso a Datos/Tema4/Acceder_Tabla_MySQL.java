package Tema4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Acceder_Tabla_MySQL
{
	public static void main (String [] args) throws ClassNotFoundException, SQLException
	{
        String url = "jdbc: mysql: //89.36.214.106: 3306 / factura";
        String usuario = "factura";
        String password = "factura";

        Connection con = DriverManager.getConnection (url, usuario, password);
        
        Statement st = con.createStatement ();
        ResultSet rs = st.executeQuery ( "SELECT * FROM pueblo");
        while (rs.next ()) {
            System.out.print (rs.getInt (1)  );
            System.out.println (rs.getString (2));
        }
        st.close ();
        
        con.close ();
    }
}
