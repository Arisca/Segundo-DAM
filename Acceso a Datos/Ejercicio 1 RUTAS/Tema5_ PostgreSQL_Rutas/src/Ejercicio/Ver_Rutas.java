package Ejercicio;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Datos.Punt;
import Datos.PuntId;
import Datos.Ruta;
import Datos.SessionFactoryUtil;

public class Ver_Rutas
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
        Session sessio = sf.openSession();
        
        Query q = sessio.createQuery("from Ruta order by nomR");

        
        List<Ruta> llista = q.list();


        Iterator<Ruta> it = llista.iterator();

        while (it.hasNext()) {
            Ruta rut = it.next();
            System.out.println(rut.getNomR() + " - " + rut.getPunts().size());
        }
	}
}
