package Ejercicios_del_Tema;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Update
{
	public static void main (String [] args)
	{
        Session sesion = SessioFactoryUtil.getSessionFactory (). openSession ();
        Transaction t = sesion.beginTransaction ();
        Comarca comarca = (Comarca) sesion.load(Comarca.class, "Campo de Morvedre");
        
        comarca.setProvincia ( "Castellón");
        sesion.update (comarca);

        t.rollback ();
        sesion.close ();
    }
}
