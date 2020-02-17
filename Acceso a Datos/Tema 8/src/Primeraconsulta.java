import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import net.xqj.exist.ExistXQDataSource;

public class Primeraconsulta
{
	public static void main (String [] args) throws XQException
	{
        XQDataSource s = new ExistXQDataSource ();
        s.setProperty ( "serverName", "localhost");
        s.setProperty ( "port", "8080");
        s.setProperty ( "user", "admin");
        s.setProperty ( "password", "ATWA");
        
        XQConnection conn = s.getConnection();
        System.out.println("Connexió feta");
        String sent ="for $alumne in doc(\"/db/Tema8/classe.xml\")//alumne order by $alumne/cognoms return $alumne";
        
        XQPreparedExpression cons = conn.prepareExpression(sent);
        XQResultSequence rs = cons.executeQuery();
        
        while(rs.next())
            System.out.println(rs.getItemAsString(null));     
        conn.close();
		}
}
