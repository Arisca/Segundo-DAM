package Tema4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Creacion_Tabla
{
	public static void main (String [] args) throws SQLException
	{
        Connection con = null;
        Statement st = null;
        String sentSQL = null;

        try {
            Class.forName ( "org.sqlite.JDBC");

            String url = "jdbc: sqlite: Empleats.sqlite";
            con = DriverManager.getConnection (url);

            st = con.createStatement ();

            sentSQL = "CREATE TABLE EMPLEADO (" +
                    "num INTEGER CONSTRAINT cp_emp PRIMARY KEY," +
                    "depart INTEGER," +
                    "edad INTEGER," +
                    "sueldo REAL" +
                ")";

            st.executeUpdate (sentSQL);
            st.close ();

        } catch (SQLException ex) {
            System.out.println ( "Error" + ex.getMessage ());
        } catch (ClassNotFoundException ex) {
            System.out.println ( "No se encontró el controlador JDBC (" + ex.getMessage () + ")");
        }finally {
            try {
                if (st != null &&! st.isClosed ()) {
                    st.close ();


                System.out.println ( "No se pudo cerrar el Statement por alguna razón");
            }
            try {
                if (con != null &&! con.isClosed ()) {
                    con.close ();
                }
            } catch (SQLException ex2) {
                System.out.println ( "No se pudo cerrar el Connection por alguna razón");
            }
        }finally {}
           
        }
	}
}


