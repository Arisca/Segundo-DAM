package Ejercicios_del_Tema;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Update2
{
	public static void main (String [] args)
	{
        Session sesion = SessioFactoryUtil.getSessionFactory (). openSession ();
        
        Transaction tr = sesion.beginTransaction ();
        
        int filas = sesion.createQuery ( "update Poblacion septiembre poblacion = poblacion * 01:05 where población <200"). executeUpdate ();
        
        System.out.println ( "Se han modificado" + filas + "filas.");
        
        tr.rollback ();
    }
}

// Se pretende una modificacion masiva (Observar el rollback final)
