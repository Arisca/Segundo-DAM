package Ejercicios_del_Tema;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class Insert
{
	public static void main (String [] args)
	{
        Session sesion = SessioFactoryUtil.getSessionFactory (). openSession ();
        
        Transaction tr = sesion.beginTransaction ();
        
        int filas = sesion.createQuery ( "insert into Comarca (nomC, provincia)"
        		+ "Select n.nomC, n.provincia from NovesComarques n").executeUpdate();
        		 
        		System.out.println ( "Se han introducido" + filas + "filas.");
        
        tr.rollback ();
    }
}
