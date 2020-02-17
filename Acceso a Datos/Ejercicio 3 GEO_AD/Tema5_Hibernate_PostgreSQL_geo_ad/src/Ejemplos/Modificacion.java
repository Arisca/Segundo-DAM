package Ejemplos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import clases.Comarca;
import clases.SessionFactoryUtil;

public class Modificacion
{
	public static void main(String[] args) {

        Session sessio = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction t = sessio.beginTransaction();
        Comarca com = (Comarca) sessio.load(Comarca.class, "Camp de Morvedre");
        
        com.setProvincia("Castelló");
        sessio.update(com);

        t.rollback();
        sessio.close();
    }
}
