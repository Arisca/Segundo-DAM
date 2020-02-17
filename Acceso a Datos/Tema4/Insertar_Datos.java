package Tema4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insertar_Datos
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

            sentSQL = "INSERT INTO EMPLEADO VALUES (1, 'Andr�s', 10,32,1000.0)";
            st.executeUpdate (sentSQL);

            sentSQL = "INSERT INTO EMPLEADO VALUES (2, 'Bernat', 20,28,1200.0)";
            st.executeUpdate (sentSQL);

            sentSQL = "INSERT INTO EMPLEADO VALUES (3, 'Claudia', 10,26,1100.0)";
            st.executeUpdate (sentSQL);

            sentSQL = "INSERT INTO EMPLEADO VALUES (4, 'Dami�', 10,40,1500.0)";
            st.executeUpdate (sentSQL);

        } catch (SQLException ex) {
            System.out.println ( "Error" + ex.getMessage ());
        } catch (ClassNotFoundException ex) {
            System.out.println ( "No se encontr� el controlador JDBC (" + ex.getMessage () + ")");

        } finally {
            try {
                if (st != null &&! st.isClosed ()) {
                    st.close ();
                }
            } catch (SQLException ex) {
                System.out.println ( "No se pudo cerrar el Statement por alguna raz�n");


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

