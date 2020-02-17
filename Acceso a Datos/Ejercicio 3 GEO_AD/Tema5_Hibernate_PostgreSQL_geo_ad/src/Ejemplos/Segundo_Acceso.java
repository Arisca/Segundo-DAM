package Ejemplos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import clases.Comarca;
import clases.SessionFactoryUtil;

public class Segundo_Acceso
{
	public static void main(String[] args) {
		 
        SessionFactory sf = SessionFactoryUtil.getSessionFactory();
        Session sessio = sf.openSession();
        Comarca com = (Comarca) sessio.load(Comarca.class, "Alt Maestrat");
        System.out.print("Comarca " + com.getNomC() + ": ");
        System.out.print(com.getProvincia());
        System.out.println(" (" + com.getPoblacios().size() + " pobles)");
        sessio.close();
    }
}

