import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

public class NativeQueries
{
	public static void main (String [] args)
	{
        ObjectContainer bd = Db4oEmbedded.openFile (Db4oEmbedded.newConfiguration (), "Empleados.db4o");
        String [] pobl = { "Castellón", "Burriana"};

        ObjectSet <Empleado> lista = bd.query (new EmpleatsPerPoblacio (pobl));

        for (Empleado e: lista) {
            System.out.println (e.getNombre () + "(" + e.getDireccion (). getPoblacion () + ")");
        }
        bd.close ();
    }

    public static class EmpleatsPerPoblacio extends Predicate <Empleado>
    {
        String [] poblaciones;

        public EmpleatsPerPoblacio (String [] poblaciones)
        {
            this.poblaciones = poblaciones;
        }

        public boolean match (Empleado emp)
        {
            boolean devuelve = false;
            for (int i = 0;! devuelve && i < poblaciones.length; i ++)
            {
                if (emp.getDireccion (). getPoblacion (). equalsIgnoreCase (poblaciones [i]))
                    devuelve = true;
            }
            return devuelve;
        }
    }
}
