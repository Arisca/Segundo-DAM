import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

public class NativeQueries2
{
	 public static void main (String [] args)
	 {
	        ObjectContainer bd = Db4oEmbedded.openFile (Db4oEmbedded.newConfiguration (), "Empleados.db4o");
	        final int max = 1500;
	        final int min = 1000;
	        ObjectSet <Empleado> lista = bd.query (new Predicate <Empleado> ()
	        {
	            public boolean match (Empleado emp) {
	                if (emp.getSueldo () <= max && emp.getSueldo () >= min)
	                    return true ;
	                else
	                    return false;
	            }
	        });

	        for (Empleado e: lista) {
	            System.out.println (e.getNombre () + "(" + e.getSueldo () + ")");
	        }
	        bd.close ();
	    }
}
