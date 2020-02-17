package Ejercicios_del_Tema;

import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;

public class ConsultaCompleja1
{
	public static void main (String [] args)
	{
        Session sesion = SessioFactoryUtil.getSessionFactory (). openSession ();
        Query q = sesion.createQuery ( "from Poblacion p, Comarca c where p.comarca.nomC = c.nomC order by p.nom");

        Iterator it = q.iterate ();
        while (it.hasNext ()) {
            Object [] todo = (Object []) it.next ();
            Poblacion p = (Poblacion) todo [0];
            Comarca c = (Comarca) todo [1];
            System.out.println (p.getNom () + "(" + c.getNomC () + "." + c.getProvincia () + ")");
        }
    }
}
