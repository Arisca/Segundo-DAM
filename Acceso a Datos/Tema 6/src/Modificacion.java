import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;

public class Modificacion
{
	public static void main (String [] args)
	{
        EmbeddedConfiguration conf = Db4oEmbedded.newConfiguration ();
        conf.common (). objectClass (Empleado.class) .cascadeOnUpdate (true);

        ObjectContainer bd = Db4oEmbedded.openFile (conf, "Empleats.db4o");

        Empleado e = new Empleado ( "11111111");
        ObjectSet <Empleado> lista = bd.queryByExample (e);
        if (lista.hasNext ())
        {
            e = lista.next ();
            e.setSueldo (e.getSueldo () + 200);
            Direccion adr = e.getDireccion ();
            adr.setCarrer ( "Pl. Rei en Jaume, 15");
            adr.setCodipostal ( "12002");
            e.setDireccion (adr);
            bd.store (e);
        }
        bd.close ();
    }
}
