package Tema4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Modificar_datos
{
	public static void main (String [] args) {
        Connection con = null;
        Statement st = null;
        String sentSQL = null;

        try {
            Class.forName ( "org.sqlite.JDBC");

            String url = "jdbc: sqlite: Empleats.sqlite";
            con = DriverManager.getConnection (url);

            st = con.createStatement ();

            sentSQL = "UPDATE EMPLEADO SET sueldo = sueldo * 01:05";
            st.executeUpdate (sentSQL);

            sentSQL = "UPDATE EMPLEADO SET depart = 20 WHERE num = 3";
            st.executeUpdate (sentSQL);

        } catch (SQLException ex) {
            System.out.println ( "Error" + ex.getMessage ());
        } catch (ClassNotFoundException ex) {
            System.out.println ( "No se encontró el controlador JDBC (" + ex.getMessage () + ")");

        } finally {
            try {
                if (st != null &&! st.isClosed ()) {
                    st.close ();
                }
            } catch (SQLException ex) {
                System.out.println ( "No se pudo cerrar el Statement por alguna razón");


                try {
					if (con != null &&! con.isClosed ()) {
					    con.close ();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
    }
}

