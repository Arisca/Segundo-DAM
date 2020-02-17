package Ejemplos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import clases.Comarca;
import clases.SessionFactoryUtil;

public class Acceso_con_ListForEach
{
    public static void main(String[] args) {

        Session sessio = SessionFactoryUtil.getSessionFactory().openSession();

        Query q = sessio.createQuery("from Comarca");

        for (Comarca com : (List<Comarca>) q.list())
            System.out.println(com.getNomC() + " - " + com.getProvincia());
    }
}
