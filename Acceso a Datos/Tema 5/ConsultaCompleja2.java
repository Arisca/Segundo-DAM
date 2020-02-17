package Ejercicios_del_Tema;

import org.hibernate.Query;
import org.hibernate.Session;

public class ConsultaCompleja2
{
	public static void main (String [] args)
	{
        Session sesion = SessioFactoryUtil.getSessionFactory (). openSession ();

        Query q = sesion.createQuery ( "select avg (altura) from Poblacion");

        Double media = (Double) q.uniqueResult ();
        
        System.out.println ( "Altura media:" + media);

    }
}
