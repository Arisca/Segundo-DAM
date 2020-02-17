package Ejercicios_del_Tema;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ConsultaCompleja3
{
	public static void main (String [] args)
	{
        Session sesion = SessioFactoryUtil.getSessionFactory (). openSession ();

        Query q = sesion.createQuery ( "select c.nomC, count (p.codM), avg (p.altura)"
                                        + "from Comarca c, Poblacion p"
                                        + "where c.nomC = p.comarca.nomC"
                                        + "group by c.nomC"
                                        + "order by c.nomC");
        List <Object []> lista = q.list ();
        for (Object [] todo: lista)
            System.out.println ( "Comarca:" + todo [0] + ". Núm. pueblos:" + todo [1] + ". Altura media:" + todo [2]) ;
    }
}
