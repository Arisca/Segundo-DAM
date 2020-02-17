package Ejemplos;


import org.hibernate.Session;
import org.hibernate.Transaction;

import clases.SessionFactoryUtil;

public class Borrar_masivo
{

    public static void main(String[] args) {

         Session sessio = SessionFactoryUtil.getSessionFactory().openSession();        
         Transaction tr = sessio.beginTransaction();         
         int files = sessio.createQuery("delete Institut where codi like '12%'").executeUpdate();        
         System.out.println("S'han esborrat " + files + " files.");
         
         tr.rollback();
    }
}

