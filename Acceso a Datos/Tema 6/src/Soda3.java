import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Soda3
{
	public static void main (String [] args) {
		 
		ObjectContainer bd = Db4oEmbedded.openFile (Db4oEmbedded.newConfiguration (), "Empleados.db4o");
		 
		Query q = bd.query ();      
		q.constrain (Empleado.class);
		 
		Query nodo = q.descend ( "departamento");
		nodo.constrain (10);
		 
		nodo = q.descend ( "direccion"). descend ( "población");
		nodo.constrain ( "Castellón");
		 
		ObjectSet <Empleado> lista = q.execute ();
		 
		for (Empleado e: lista)
		{
			System.out.println ( "Nombre:" + e.getNombre () + ". Población:" + e.getDireccion ().getPoblacion () + ". Departamento:" + e.getDepartamento ());
		}
		bd.close ();
	}
}
