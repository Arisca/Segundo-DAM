package Ejemplos;


import org.hibernate.Session;

import clases.Comarca;
import clases.SessionFactoryUtil;

public class Acceso_con_UniqueResult
{
    public static void main(String[] args) {

        Session sessio = SessionFactoryUtil.getSessionFactory().openSession();

        Comarca d = (Comarca) sessio.createQuery("from Comarca where nomC='Alcalat�n'").uniqueResult();
        
        System.out.println(d.getNomC() + " - " + d.getProvincia()); 
    }
}
