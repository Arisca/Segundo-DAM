package Ejemplos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import clases.SessionFactoryUtil;

public class Consulta_Compleja_3
{
    public static void main(String[] args) {


        Session sessio = SessionFactoryUtil.getSessionFactory().openSession();

        Query q = sessio.createQuery("select c.nomC,count(p.codM),avg(p.altura) "
                                        + "from Comarca c , Poblacio p "
                                        + "where c.nomC=p.comarca.nomC "
                                        + "group by c.nomC "
                                        + "order by c.nomC");
        List<Object[]> llista = q.list();
        for (Object[] tot : llista)
            System.out.println("Comarca: " + tot[0] + ". Núm. pobles: " + tot[1] + ". Altura mitjana: " + tot[2]);
    }
}
