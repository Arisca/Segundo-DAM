package Ejercicios_del_Tema;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class AccesoconForeach
{
	public static void main (String [] args)
	{
        Session sesion = SessioFactoryUtil.getSessionFactory (). openSession ();
        Query q = sesion.createQuery ( "from Comarca");

        for (Comarca comarca: (List <Comarca>) q.list ())
            System.out.println (comarca.getNomC () + "-" + comarca.getProvincia ());
    }
}
