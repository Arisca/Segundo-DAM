package Ejercicios_del_Tema;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class AccesoconList
{
	public static void main (String [] args)
	{
        Session sesion = SessioFactoryUtil.getSessionFactory (). openSession ();
        Query q = sesion.createQuery ( "from Comarca");
        
        List <Comarca> lista = q.list();
        	Iterator <Comarca> it = lista.iterator ();
        	while (it.hasNext ())
        	{
        		Comarca comarca = it.next ();
        		System.out.println (comarca.getNomC () + "-" + comarca.getProvincia ());
        	}
    }
}
