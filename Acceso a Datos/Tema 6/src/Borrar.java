import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Borrar
{
	public static void main (String [] args)
	{
        ObjectContainer bd = Db4oEmbedded.openFile ( "Empleats.db4o");
        Empleado e = new Empleado ( "22222222b");

        ObjectSet <Empleado> lista = bd.queryByExample (e);
        if (lista.hasNext ()) {
            e = lista.next ();
            bd.delete (e);
        }
        bd.close ();
    }
}
