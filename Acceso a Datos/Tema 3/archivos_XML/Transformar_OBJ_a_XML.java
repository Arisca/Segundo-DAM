package archivos_XML;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
 
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Transformar_OBJ_a_XML
{
	public static void main (String [] args) throws IOException, ClassNotFoundException, ParserConfigurationException, TransformerException
	{
		ObjectInputStream f = new ObjectInputStream (new FileInputStream ( "Empleados.obj"));
		 
		Document doc = DocumentBuilderFactory.newInstance(). newDocumentBuilder(). newDocument();
		Element raiz = doc.createElement ( "empleados");
		doc.appendChild (raiz);
		 
		Datos_Serializados e;
		try
		{
			while (true)
			{
				e = (Datos_Serializados) f.readObject ();
				Datos_Serializados emp = (Datos_Serializados) doc.createElement ( "empleado");
				((Element) emp).setAttribute ( "numero", Integer.toString (e.getNum ()));
		 
				Datos_Serializados hijo = (Datos_Serializados) doc.createElement ( "nombre");
				((Node) hijo).appendChild (doc.createTextNode (e.getNombre ()));
				((Node) emp).appendChild ((Node) hijo);
		 
				hijo = (Datos_Serializados) doc.createElement ( "departamento");
				((Node) hijo).appendChild (doc.createTextNode (Integer.toString (e.getDepartamento ())));
				((Node) emp).appendChild ((Node) hijo);
		 
				hijo = (Datos_Serializados) doc.createElement ( "edad");
				((Node) hijo).appendChild (doc.createTextNode (Integer.toString (e.getEdad ())));
				((Node) emp).appendChild ((Node) hijo);
		 
				hijo = (Datos_Serializados) doc.createElement ( "sueldo");
				((Node) hijo).appendChild (doc.createTextNode (Double.toString (e.getSueldo ())));
				((Node) emp).appendChild ((Node) hijo);
		 
				raiz.appendChild ((Node) emp);
			}
		}
		catch (EOFException EOF){f.close ();}
		
		Transformer trans = TransformerFactory.newInstance (). newTransformer ();
		 
		DOMSource source = new DOMSource (doc);
		StreamResult result = new StreamResult (new FileOutputStream ( "Empleats.xml"));
		 
		trans.transform (source, result);
		}
}
