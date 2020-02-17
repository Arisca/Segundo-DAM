package Ejercicios_del_Tema;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Inserccion
{
	public static void main (String [] args)
	{
        Session sesion = SessioFactoryUtil.getSessionFactory (). openSession ();
        Transaction t = sesion.beginTransaction ();
        Comarca comarca = new Comarca ();

        comarca.setNomC ((String) "Columbretes");
        comarca.setProvincia ( "Castellón");
        
        sesion.save (comarca);

        t.commit ();
        sesion.close ();
    }
}
