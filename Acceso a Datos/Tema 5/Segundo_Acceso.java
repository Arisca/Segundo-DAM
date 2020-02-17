package Ejercicios_del_Tema;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Segundo_Acceso
{
	public static void main (String [] args)
	{		 
        SessionFactory sf = SessioFactoryUtil.getSessionFactory ();
        Session sesion = sf.openSession ();
        Comarca comarca = (Comarca) sesion.load (Comarca.class, "Alt Maestrat");
        System.out.print ( "Comarca" + comarca.getNomC () + ":");
        System.out.print (comarca.getProvincia ());
        System.out.println ( "(" + comarca.getPoblacios (). Size () + "pueblos)");
        sesion.close ();
    }
}