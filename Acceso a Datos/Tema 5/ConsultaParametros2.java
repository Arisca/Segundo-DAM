package Ejercicios_del_Tema;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ConsultaParametros2
{
	public static void main (String [] args)
	{
        Session sesion = SessioFactoryUtil.getSessionFactory (). openSession ();
        Query q = sesion.createQuery ( "from Poblacion where altura> =: alto and comarca.nomC =: como"); // En este ejemplo se utiliza el nombre del parámetro
        q.setInteger ( "alto", 500);
        q.setString ( "como", "Alcalatén");
        
        for (Poblacion p: (List <Poblacion>)q.list ())
        {
            System.out.println (p.getNom () + "->" + p.getAltura ());
        }

    }
}
