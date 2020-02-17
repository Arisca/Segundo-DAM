package Ejemplos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import clases.Comarca;
import clases.SessionFactoryUtil;

public class Insertar
{
	
	public static void main(String[] args)
	{

        Session sessio = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction t = sessio.beginTransaction();
        Comarca com = new Comarca();

        com.setNomC((String) "Columbretes");
        com.setProvincia("Castelló");
        
        sessio.save(com);

        t.commit();
        sessio.close();
    }

}
