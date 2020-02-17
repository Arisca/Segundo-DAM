package Ejercicios_del_Tema;

import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;

public class AccesoconIterate
{
	public static void main (String [] args)
	{
        Session sesion = SessioFactoryUtil.getSessionFactory (). openSession ();
        Query q = sesion.createQuery ( "from Comarca");
        Iterator <Comarca> it = q.iterate ();
        	while (it.hasNext ())
        	{
        		Comarca comarca = it.next ();
        		System.out.println (comarca.getNomC () + "-" + comarca.getProvincia ());
        }
    }
}
