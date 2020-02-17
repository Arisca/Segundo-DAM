import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import net.xqj.exist.ExistXQDataSource;

public class Conectarse
{
	public static void main (String [] args) throws XQException
	{
        XQDataSource s = new ExistXQDataSource ();
        s.setProperty ( "serverName", "localhost");
        s.setProperty ( "port", "8080");
        s.setProperty ( "user", "admin");
        s.setProperty ( "password", "ATWA");

        XQConnection conn = s.getConnection ();
        System.out.println ( "Conexión hecha");
        conn.close ();
    }
}
