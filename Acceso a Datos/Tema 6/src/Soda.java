import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Soda
{
	public static void main (String [] args)
	{
		ObjectContainer bd = Db4oEmbedded.openFile (Db4oEmbedded.newConfiguration (), "Empleados.db4o");
		Query q = bd.query (); // nodo ra�z.
		q.constrain (Empleado.class); // limitamos la b�squeda a los Empleados (puede haber guardarda m�s de una clase)
		 
		Query nodo = q.descend ( "nif"); // llegamos a la altura del nif, que es donde ponemos la restricci�n
		nodo.constrain ( "11111111");
		 
		ObjectSet <Empleado> lista = q.execute ();
		 
		for (Empleado e: lista) {
		    System.out.println ( "Nif:" + e.getNif () + ". Nombre:" + e.getNombre () + "(" + e.getSueldo () + ")");
		}
		bd.close ();
		}
}
