package Ejemplos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import clases.Poblacio;
import clases.SessionFactoryUtil;

public class Consulta_con_Parametros_1
{

    public static void main(String[] args) {

       Session sessio = SessionFactoryUtil.getSessionFactory().openSession();

       Query q = sessio.createQuery("from Poblacio where altura>=? and comarca.nomC=?");
       q.setInteger(0, 500);
       q.setString(1, "Alcalatén");
       
       for (Poblacio p : (List<Poblacio>) q.list()){
           System.out.println(p.getNom() + " --> " + p.getAltura());
       }
    }
}
