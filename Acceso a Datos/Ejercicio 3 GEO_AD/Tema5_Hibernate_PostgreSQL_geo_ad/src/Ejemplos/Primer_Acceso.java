package Ejemplos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import clases.Comarca;

public class Primer_Acceso
{
    public static void main (String [] args)
    {
        SessionFactory sf = new Configuration ().configure ().buildSessionFactory();
        Session sesion = sf.openSession ();
        Comarca com = (Comarca) sesion.load (Comarca.class, "Alt Maestrat");
        System.out.print ( "Comarca" + com.getNomC () + ":");
        System.out.print (com.getProvincia ());
        System.out.println ( "(" + com.getPoblacios().size () + "pueblos)");
        sesion.close ();
    }
}
