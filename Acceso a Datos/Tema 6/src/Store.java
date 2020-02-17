import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class Store 
{
	public static void main (String [] args)
	{
        ObjectContainer bd = Db4oEmbedded.openFile ( "Empleats.db4o");

        Empleado e = new Empleado ( "11111111", "Albert", 10, 45, 1000, null, null, null, null, null);
        
        e.setDireccion (new Direccion ( "C / Mayor, 7", "12001", "Castellón"));
        String [] corr = { "alu11111111a@ieselcaminas.org"};
        e.setCorreus_e (corr);
        Telefono [] tels = {new Telefono (true, "666.777.888"), new Telefono (false, "964.112.233")};
        e.setTelefonos (tels);

        bd.store (e);

        bd.close ();
    }
}
