package Tema4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Acceder_Columnas_Oracle
{
	public static void main (String [] args) throws ClassNotFoundException, SQLException
	{
        String url = "jdbc: oracle: thin: @ 94177240173: 1521: ORCL";
        String usuario = "scott";
        String password = "tiger";

        Connection con = DriverManager.getConnection (url, usuario, password);
        
        Statement st = con.createStatement ();
        ResultSet rs = st.executeQuery ( "SELECT * FROM emp");
        while (rs.next ()) {
            System.out.print (rs.getInt (1) + "/ t");
            System.out.println (rs.getString (2));
        }
        st.close ();
        
        con.close ();
    }
}
