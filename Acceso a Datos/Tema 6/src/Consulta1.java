import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Consulta1
{
	public static void main (String [] args)
	{
        ObjectContainer bd = Db4oEmbedded.openFile ( "Empleats.db4o");
        Empleado e = null;

        ObjectSet <Empleado> lista = bd.queryByExample (new Empleado ( "11111111"));

        if (lista.hasNext ()) {
            e = lista.next ();
            System.out.println ( "Nif:" + e.getNif () + ". Nombre:" + e.getNombre () + ". Población:" + e.getDireccion ().getPoblacion ());
            System.out.println ( "Primer correo:" + e.getCorreus_e () [0] + ". Primer teléfono:" + e. getTelefonos () [0].getNumero ());
        }
        bd.close ();
    }
}
