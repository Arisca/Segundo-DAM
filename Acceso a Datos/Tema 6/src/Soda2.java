import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Soda2
{
	public static void main (String [] args)
	{
		 
		ObjectContainer bd = Db4oEmbedded.openFile (Db4oEmbedded.newConfiguration (), "Empleados.db4o");
		 
		Query q = bd.query (); // nodo raíz.
		q.constrain (Empleado.class); // limitamos la búsqueda a los Empleados (puede haber guardarda más de una clase)
		Query nodo = q.descend ( "sueldo"); // llegamos a la altura del sueldo, que es donde ponemos restricciones
		nodo.constrain (1000) .greater (). and (nodo.constrain (1500) .smaller (). equal ());
		nodo.orderDescending ();
		 
		ObjectSet <Empleado> lista = q.execute ();
		 
		for (Empleado e: lista) {
		System.out.println (e.getNombre () + "(" + e.getSueldo () + ")");
		}
		bd.close ();
		}
}
