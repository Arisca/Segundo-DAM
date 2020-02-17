import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Modificacion2
{
	public static void main (String [] args)
	{
        ObjectContainer bd = Db4oEmbedded.openFile ( "Empleats.db4o");

        Empleado e = new Empleado ( "11111111");
        ObjectSet <Empleado> lista = bd.queryByExample (e);
        if (lista.hasNext ()) {
            e = lista.next ();
            e.setSueldo (e.getSueldo () + 200);

            bd.close (); // Cerramos y volvemos a abrir la BD, para ver que hemos
                        // perdido la correspondencia de y con el objeto de la BD
            bd = Db4oEmbedded.openFile (Db4oEmbedded.newConfiguration (), "Empleados.db4o");

            bd.store (e);
        }
        bd.close ();
    }
}
