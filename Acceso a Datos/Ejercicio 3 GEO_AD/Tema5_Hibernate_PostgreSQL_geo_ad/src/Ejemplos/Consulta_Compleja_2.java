package Ejemplos;

import org.hibernate.Query;
import org.hibernate.Session;

import clases.SessionFactoryUtil;

public class Consulta_Compleja_2
{

    public static void main(String[] args) {

        Session sessio = SessionFactoryUtil.getSessionFactory().openSession();
        Query q = sessio.createQuery("select avg(altura) from Poblacio");
        Double mitjana = (Double) q.uniqueResult();       
        System.out.println("Altura mitjana: " + mitjana);
    }
}
