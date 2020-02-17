package Ejemplos;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;

import clases.Comarca;
import clases.SessionFactoryUtil;

public class Acceso_con_Iterate
{
    public static void main(String[] args) {

        Session sessio = SessionFactoryUtil.getSessionFactory().openSession();

        Query q = sessio.createQuery("from Comarca");

        Iterator<Comarca> it = q.iterate();

        while (it.hasNext()) {
            Comarca com = it.next();
            System.out.println(com.getNomC() + " - " + com.getProvincia());
        }
    }
}