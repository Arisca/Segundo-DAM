import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQConstants;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import javax.xml.xquery.XQStaticContext;
import net.xqj.exist.ExistXQDataSource;

public class Cuartaconsulta
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
		   
		   XQStaticContext cntxt = conn.getStaticContext();
		   cntxt.setScrollability( XQConstants.SCROLLTYPE_SCROLLABLE);
		   conn.setStaticContext(cntxt);
		   XQPreparedExpression cons = conn.prepareExpression(sent);
		  
		   XQResultSequence rs = cons.executeQuery();
		   rs.afterLast();
		   while(rs.previous())
		       System.out.println(rs.getItemAsString(null));
		   conn.close();
		}
}
