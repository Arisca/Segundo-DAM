package Ejemplos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import clases.SessionFactoryUtil;


public class Modificacion_masiva
{
	   public static void main(String[] args) {

	        Session sessio = SessionFactoryUtil.getSessionFactory().openSession();	     
	        Transaction tr = sessio.beginTransaction();	        
	        int files = sessio.createQuery("update Poblacio set poblacio = poblacio *1.05 where poblacio < 200").executeUpdate();	        
	        System.out.println("S'han modificat " + files + " files.");	        
	        tr.rollback();
	    }

}
