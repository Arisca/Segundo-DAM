import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence; 
import net.xqj.exist.ExistXQDataSource;
import org.w3c.dom.Element;

public class Obtencion3
{
	public static void main(String[] args) throws XQException
	{
		XQDataSource s = new ExistXQDataSource();
		   s.setProperty("serverName", "localhost");
		   s.setProperty("port", "8080");
		   s.setProperty("user", "admin");
		   s.setProperty("password", "ATWA");
		 
		   XQConnection conn = s.getConnection();
		   String sent ="for $alumne in //alumne order by $alumne/cognoms return $alumne";
		   
		   XQPreparedExpression cons = conn.prepareExpression(sent);
		  
		   XQResultSequence rs = cons.executeQuery();
		   while(rs.next())
		   {
			   Element el = (Element) rs.getObject();
			   System.out.print(el.getElementsByTagName("nom").item(0).getFirstChild().getNodeValue() + " ");
			   System.out.print(el.getElementsByTagName("cognoms").item(0).getFirstChild().getNodeValue() + ": ");
			   System.out.println(el.getElementsByTagName("nota").item(0).getFirstChild().getNodeValue());
		   }
		   conn.close();
		}
}
