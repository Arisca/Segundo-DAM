import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQResultSequence;
import net.xqj.exist.ExistXQDataSource;

public class Obtencion
{
	 public static void main(String[] args) throws XQException
	 {
	        XQDataSource s = new ExistXQDataSource();
	        s.setProperty("serverName", "localhost");
	        s.setProperty("port", "8080");
	        s.setProperty("user", "admin");
	        s.setProperty("password", "ATWA");

	        XQConnection conn = s.getConnection();
	        String sent = "//alumne/cognoms/text()";

	        XQResultSequence rs = conn.createExpression().executeQuery(sent);

	        while (rs.next())
	            System.out.println(rs.getItemAsString(null));
	        conn.close();
	    }
}
