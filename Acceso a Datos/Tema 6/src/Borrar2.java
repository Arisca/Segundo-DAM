import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;

public class Borrar2
{
	public static void main (String [] args)
	{
        EmbeddedConfiguration conf = Db4oEmbedded.newConfiguration ();
        conf.common (). objectClass (Empleado.class) .cascadeOnDelete (true);

        ObjectContainer bd = Db4oEmbedded.openFile (conf, "Empleats.db4o");

        Empleado e = new Empleado ( "33333333c");
        ObjectSet <Empleado> lista = bd.queryByExample (e);
        if (lista.hasNext ())
        {
            e = lista.next ();
            bd.delete (e);
        }
        bd.close ();
    }
}
