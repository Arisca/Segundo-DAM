package Ejercicios_del_Tema;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ConsultaParametros1
{
	public static void main (String [] args)
	{
	      Session sesion = SessioFactoryUtil.getSessionFactory (). openSession ();

	       Query q = sesion.createQuery ( "from Poblacion where altura> =? And comarca.nomC =?"); // En esta versi�n se se�alan los par�metros con  ? al estilo de  JDBC 
	       q.setInteger (0, 500);
	       q.setString (1, "Alcalat�n");
	       
	       for (Poblacion p:(List <Poblacion>)q.list())
	       {
	           System.out.println (p.getNombre () + "->" + p.getAltura ());
	       }
	}
}
