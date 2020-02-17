package Tema4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultar_datos
{
	public static void main (String [] args)
	{
        Connection con = null;
        Statement st = null;
        String sentenciaSQL = null;
        ResultSet rs = null;

        try {
            Class.forName ( "org.sqlite.JDBC");

            String url = "jdbc: sqlite: Empleats.sqlite";
            con = DriverManager.getConnection (url);

            st = con.createStatement ();

            sentenciaSQL = "SELECT * FROM EMPLEADO WHERE sueldo> 1.100";
            rs = st.executeQuery (sentenciaSQL);

            System.out.println ( " N�m.  TNom  tDep  tEdat  Tsou");
            System.out.println ( "-----------------------------------------") ;

            while (rs.next ()) {
                System.out.print (rs.getInt (1) + "/ t");
                System.out.print (rs.getString (2) + "/ t");
                System.out.print (rs.getInt (3) + "/ t");
                System.out.print (rs.getInt (4) + "/ t");
                System.out.println (rs.getDouble (5));
            }

        } catch (SQLException ex) {
            System.out.println ( "Error" + ex.getMessage ());
        } catch (ClassNotFoundException ex) {
            System.out.println ( "No se encontr� el controlador JDBC (" + ex.getMessage () + ")");

        } finally {
            try {
                if (rs != null &&! rs.isClosed ()) {
                    rs.close ();
                }
            } catch (SQLException ex) {
                System.out.println ( "No se pudo cerrar el ResultSet por alguna raz�n");
            }
            try {
                if (st != null &&! st.isClosed ()) {
                    st.close ();
                }
            } catch (SQLException ex) {
                System.out.println ( "No se pudo cerrar el Statement por alguna raz�n");


                try {
					if (con != null &&! con.isClosed ()) {
					    try {
							con.close ();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
    }
}

