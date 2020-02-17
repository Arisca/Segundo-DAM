import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class QuerybyExample
{
	public static void main (String [] args)
	{
        ObjectContainer bd = Db4oEmbedded.openFile (Db4oEmbedded.newConfiguration (), "Empleados.db4o");

        Empleado f = new Empleado ();
        f.setDepartamento (10);
        f.setDireccion (new Direccion (null, null, "Castellón"));

        ObjectSet <Empleado> lista = bd.queryByExample (f);
        for (Empleado e: lista)
        {
            System.out.println ( "Nif:" + e.getNif () + ". Nombre:" + e.getNombre () + ". Departamento:" + e.getDepartamento ()
                    + ". Población:" + e.getDireccion (). getPoblacion ());
        }
        bd.close ();
    }
}
