package Ejemplos;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import clases.Comarca;
import clases.Poblacio;
import clases.SessionFactoryUtil;

public class Cuarto_Acceso
{

	public static void main(String[] args) {

        SessionFactory sf = SessionFactoryUtil.getSessionFactory();
        Session sessio = sf.openSession();
        Comarca com = (Comarca) sessio.load(Comarca.class, "Alcalatén");
        System.out.print("Comarca " + com.getNomC() + ": ");
        System.out.print(com.getProvincia());
        System.out.println(" (" + com.getPoblacios().size() + " pobles)");
        System.out.println();
        System.out.println("Llista de pobles");
        System.out.println("-----------------");
        
        for (Poblacio p : com.getPoblacios())
            System.out.println(p.getNom()+ " (" + p.getPoblacio() + " habitants)");

        sessio.close();
    }
}

