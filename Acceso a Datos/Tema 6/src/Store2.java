import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class Store2
{
	public static void main (String [] args)
	{
        ObjectContainer bd = Db4oEmbedded.openFile ( "Empleats.db4o");
        Empleado e = new Empleado ( "22222222b", "Berta", 10,35,1700, null, null, null, null, null);
        Empleado f = new Empleado ( "33333333c", "Claudia", 20,37,1500, null, null, null, null, null);
        
        e.setDireccion (new Direccion ( "C / Enmedio, 7", "12001", "Castellón"));
        String [] correo = { "e.setCorreus_e (corr)" };
        Telefono [] tels = {new Telefono (true, "666555444"), new Telefono (false, "964223344")};
        e.setTelefonos (tels);
        
        e.setDireccion (new Direccion ( "C / de Arriba, 7", null, "Burriana"));
        String [] corr2 = { "alu33333333c@ieselcaminas.org"};
        f.setCorreus_e (corr2);
        
        bd.store (e);
        bd.store (f);
        
        bd.close ();
    }
}
