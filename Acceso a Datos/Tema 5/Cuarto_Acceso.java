package Ejercicios_del_Tema;

import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Cuarto_Acceso
{
	public static void main (String [] args)
	{
        SessionFactory sf = SessioFactoryUtil.getSessionFactory ();
        Session sesion = sf.openSession ();
        Comarca comarca = (Comarca) sesion.load (Comarca.class, "Alcalatén");
        System.out.print ( "Comarca" + comarca.getNomC () + ":");
        System.out.print (comarca.getProvincia ());
        System.out.println ( "(" + comarca.getPoblacion ().size() + "pueblos)");
        System.out.println ();
        System.out.println ( "Lista de pueblos");
        System.out.println ( "-----------------");
        
        for (Poblacion p: comarca.getPoblacion ())
            System.out.println (p.getNombre () + "(" + p.getPoblacion () + "habitantes)");

        sesion.close ();
    }
}

