package util.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionarRutasBD
{
	Connection con;
	String sentSQL = null;

	public GestionarRutasBD() throws SQLException
	{
		con = DriverManager.getConnection ("jdbc:sqlite:Rutas.sqlite");
		
		Statement st = con.createStatement();
		
		sentSQL = 	"CREATE TABLE RUTAS ("											+
				"Num_ruta				INTEGER CONSTRAINT cp_rut PRIMARY KEY,"	+
				"Nombre_				ruta TEXT, "							+
				"Desnivel 				INTEGER, "								+
				"Desnivel_Acumulado 	INTEGER "								+
				")";
	
	st.executeUpdate (sentSQL);
	
	sentSQL = 	"CREATE TABLE PUNTOS ("								+
				"Num_ruta				INTEGER,"					+
				"Num_punto				INTEGER,"					+
				"Nombre_punto			TEXT,"						+
				"Latitud				REAL,"						+
				"Longitud				REAL,"						+
				"CONSTRAINT ce_numr FOREIGN KEY (Num_ruta) 	REFERENCES rutas(Num_ruta)," +
				"CONSTRAINT cp_numr_nump PRIMARY KEY (Num_ruta, Num_punto)"	+
				")";
	
	st.executeUpdate (sentSQL);
	}
	
	public void close ()
	{
		try
		{
			con.close();
		}
		catch (SQLException ex)
		{
        System.out.println("No se ha podido cerrar el CONNECTION por alguna razón");
		}
	}
		
	public void insertar(Ruta r) throws SQLException
	{
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT MAX(Num_ruta) FROM RUTAS");
		int x = rs.getInt(1);
		rs.close();
		
		sentSQL = "INSERT INTO RUTAS VALUES ("+(x+1) +",'" +
					r.getNombre()+"', " +
					r.getDesnivel()+", " +
					r.getDesnivel_Acumulado()+")";
		
		st.executeUpdate(sentSQL);
		
		 for(int i=0;i<r.length();i++)
		 {
			 sentSQL = "INSERT INTO PUNTOS VALUES ("+(x+1)+", " + (i+1)+",'" +
					 r.getPunto(i)+"', " +
					 r.getPuntoLatitud(i)+", " +
					 r.getPuntoLongitud(i)+")";
	            		
	            st.executeUpdate(sentSQL);
		 }
		 st.close();
         rs.close();
	}
    public Ruta buscar(int i)
         {
     		util.bd.Ruta r=new util.bd.Ruta();
     		try
     		{
     		Statement st = con.createStatement();
     		ResultSet rs = st.executeQuery("SELECT Num_ruta FROM RUTAS WHERE num_r="+i);
     		
     		if (rs.getInt(1)==i)
     		{
     			ResultSet rs1= st.executeQuery(	"SELECT * FROM RUTAS WHERE Num_ruta="+i);
     											r.setNombre(rs1.getString(2));
     											r.setDesnivel(rs1.getInt(3));
     											r.setDesnivel_Acumulado(rs1.getInt(4));
     		
     		rs1.close();
     		ResultSet rs2 = st.executeQuery("SELECT * FROM PUNTOS WHERE Num_ruta="+i);
     		
     		while (rs2.next())
     			r.addPunto(rs2.getString(3), rs2.getDouble(4), rs2.getDouble(5));
     		
     		rs2.close();
     		st.close();
     		
     		return r;
     		}
     	}
     	catch (SQLException e)
     		{
     		System.out.println("ERROR, la ruta no existe");
     		} 	
     			r.setNombre("error");	
     			return r;
         }
    
    public ArrayList<util.bd.Ruta> listado() throws SQLException
    { 	
		ArrayList<util.bd.Ruta> lista = new ArrayList<util.bd.Ruta>();

		Statement st = con.createStatement();
		ResultSet rs3 = st.executeQuery(	"SELECT MAX(Num_ruta) FROM RUTAS");
		
		int x = rs3.getInt(1);
		
		for (int i = 1; i <= x; i++)
		{
			util.bd.Ruta r = buscar(i);
			lista.add(r);
		}
			
		return lista;
	
	}

	public void borrar(int i)
	{
		try
		{
			Statement st = con.createStatement();
			String sentSQL = "DELETE FROM RUTAS WHERE Num_ruta= " + i;
			st.executeUpdate(sentSQL);
			sentSQL = "DELETE FROM PUNTOS WHERE Num_ruta= " + i;
			st.executeQuery(sentSQL);
			
			st.close();
		}
		catch (SQLException e)
		{
			System.out.println("ERROR, No se puede borrar o no existe la ruta");
		}
		
	}
}

