package Ejercicios_del_Tema;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Delete
{
	public static void main (String [] args)
	{
        Session sesion = SessioFactoryUtil.getSessionFactory (). openSession ();
       
        Transaction tr = sesion.beginTransaction ();
        
        int filas = sesion.createQuery ( "delete Instituto where código like '12% '"). executeUpdate ();
        
        System.out.println ( "Se han borrado" + filas + "filas.");
        
        tr.rollback ();
   }
}

// Se pretende hacer un borado masivo (Observar el rollback final, el cual deshace lo anterior)
