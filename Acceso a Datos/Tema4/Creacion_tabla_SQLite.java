package Tema4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Creacion_tabla_SQLite
{
	public static void main (String [] args) throws ClassNotFoundException, SQLException
	{
        String url = "jdbc: sqlite: proveta.sqlite";
       
        Class.forName ( "org.sqlite.JDBC");

        Connection con = DriverManager.getConnection (url);
        
        Statement st = con.createStatement ();
        st.executeUpdate ( "CREATE TABLE T1 (c1 TEXTO)");
        st.close ();
        
        con.close ();
    }
}
