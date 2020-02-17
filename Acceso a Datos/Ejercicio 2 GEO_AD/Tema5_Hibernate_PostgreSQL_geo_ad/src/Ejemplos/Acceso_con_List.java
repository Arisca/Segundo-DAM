package Ejemplos;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import clases.Comarca;
import clases.SessionFactoryUtil;

public class Acceso_con_List
{
    public static void main(String[] args) {

        Session sessio = SessionFactoryUtil.getSessionFactory().openSession();

        Query q = sessio.createQuery("from Comarca");

        List<Comarca> llista = q.list();

        Iterator<Comarca> it = llista.iterator();
        while (it.hasNext()) {
            Comarca com = it.next();
            System.out.println(com.getNomC() + " - " + com.getProvincia());
        }
    }
}
