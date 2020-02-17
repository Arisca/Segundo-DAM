package Ejercicios_del_Tema;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Primer_Acceso
{
	public static void main (String [] args)
	{
        SessionFactory sf = new Configuration (). configure (). buildSessionFactory ();
        Session sesion = sf.openSession ();
        Comarca comarca = sesion.load(Comarca.class, "Alt Maestrat");
        System.out.print ( "Comarca" + comarca.getNomC () + ":");
        System.out.print (comarca.getProvincia ());
        System.out.println ( "(" + comarca.getPoblacios (). Size () + "pueblos)");
        sesion.close ();
    }
}