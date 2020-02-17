package clases;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
 
public class SessionFactoryUtil {
 
    private static SessionFactory SF;
 
    public static SessionFactory getSessionFactory () {
        if (SF == null) {
            Configuration conf = new Configuration (). configure ();
            conf.setProperty ( "hibernate.temp.use_jdbc_metadata_defaults", "false");
            ServiceRegistryBuilder riego = new ServiceRegistryBuilder ();
            riego.applySettings (conf.getProperties ());
            ServiceRegistry serviceRegistry = riego.buildServiceRegistry ();
             
            SF = conf.buildSessionFactory (serviceRegistry);           
        }
         
        return SF;
    }
}

