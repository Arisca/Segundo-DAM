package Ejercicios_del_Tema;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Borrado
{
	public static void main (String [] args)
	{
        Session sesion = SessioFactoryUtil.getSessionFactory (). openSession ();
        Transaction t = sesion.beginTransaction ();
        Comarca comarca = (Comarca) sesion.load (Comarca.class, "Columbretes");
        
        sesion.delete (comarca);

        t.commit ();
        sesion.close ();
    }
}
