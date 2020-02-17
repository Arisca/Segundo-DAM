package Ejemplos;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;

import clases.Comarca;
import clases.Poblacio;
import clases.SessionFactoryUtil;

public class Consulta_Compleja_1
{

    public static void main(String[] args) {

        Session sessio = SessionFactoryUtil.getSessionFactory().openSession();
        Query q = sessio.createQuery("from Poblacio p, Comarca c where p.comarca.nomC=c.nomC order by p.nom");

        Iterator<?> it = q.iterate();
        while (it.hasNext()) {
            Object[] tot = (Object[]) it.next();
            Poblacio p = (Poblacio) tot[0];
            Comarca c = (Comarca) tot[1];
            System.out.println(p.getNom() + " (" + c.getNomC() + ". " + c.getProvincia() + ")");
        }
    }

}
