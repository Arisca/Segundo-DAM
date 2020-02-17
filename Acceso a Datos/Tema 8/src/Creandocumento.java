import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import net.xqj.exist.ExistXQDataSource;

public class Creandocumento
{
	public static void main(String[] args) throws XQException
	{
		File f = new File("notes.xml");
		 
		XQDataSource s = new ExistXQDataSource();
		   s.setProperty("serverName", "localhost");
		   s.setProperty("port", "8080");
		   s.setProperty("user", "admin");
		   s.setProperty("password", "ATWA");
		 
		   XQConnection conn = s.getConnection();
		   String sent =	"for $classe in /classe " +
				   			"return <notes> <modul nom=\"{$classe/assignatura/text()}\">" + 
				   			"{for $alumne in $classe//alumne " +
				   			"order by $alumne/cognoms " +
				   			"return <alumne nota=\"{$alumne/nota/text()}\">" +
				   			"{concat($alumne/nom/text(), \" \", $alumne/cognoms)}"+
				   			"</alumne>} </modul> </notes> ";
		   
		   XQPreparedExpression cons = conn.prepareExpression(sent);
		  
		   XQResultSequence rs = cons.executeQuery();
		   		try
		   		{
				   BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				   bw.write("<?xml version='1.0' ?>" + " ");
				   while(rs.next())
				   {
					   String linia = rs.getItemAsString(null);
					   System.out.println(linia);
					   bw.write(linia + " ");
				   }
				   bw.close();
		   		}
		   		catch (IOException e)
		    	{
			   		e.printStackTrace();
		    	}
		   conn.close();
		}
}
