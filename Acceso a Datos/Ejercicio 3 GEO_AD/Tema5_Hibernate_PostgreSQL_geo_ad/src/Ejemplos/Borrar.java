package Ejemplos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import clases.Comarca;
import clases.SessionFactoryUtil;

public class Borrar
{
    public static void main(String[] args) {

        Session sessio = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction t = sessio.beginTransaction();
        Comarca com = (Comarca) sessio.load(Comarca.class, "Columbretes");
        
        sessio.delete(com);

        t.commit();
        sessio.close();
    }

}
