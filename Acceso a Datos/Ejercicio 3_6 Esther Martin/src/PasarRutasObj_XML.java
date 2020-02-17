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

public class PasarRutasObj_XML
{
	public static void main(String[] args) throws IOException, ParserConfigurationException, ClassNotFoundException, TransformerException
	{
		ObjectInputStream file = new ObjectInputStream (new FileInputStream ("Rutas.obj"));
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element raiz = doc.createElement("Rutas");
		doc.appendChild (raiz);
		
		Ruta e;
		try
		{
			while (true)
			{
				e = (Ruta) file.readObject();
				Element Ruta = doc.createElement ("Ruta");
				
				Element hijo = doc.createElement ("Nombre");
				hijo.appendChild(doc.createTextNode(e.getNombre()));
				Ruta.appendChild(hijo);
				
				hijo = doc.createElement("Desnivel");
				hijo.appendChild(doc.createTextNode (Integer.toString(e.getDesnivel())));
				Ruta.appendChild(hijo);
				
				hijo = doc.createElement("Desnivel Acumulado");
				hijo.appendChild(doc.createTextNode(Integer.toString(e.getDesnivel_Acumulado())));
				Ruta.appendChild(hijo);
				
				hijo = doc.createElement("Puntos");
				
				for (int i = 0; i < e.length(); i++)
				{
					Element net = doc.createElement("Punto");
					net.setAttribute ("Número", Integer.toString(i+1));
					
					Element net2 = doc.createElement("Nombre");
					net2.appendChild(doc.createTextNode(e.getPuntoNombre(i)));
					net.appendChild(net2);
					
					net2 = doc.createElement("Latitud");
					net2.appendChild(doc.createTextNode(String.valueOf(e.getPuntoLatitud(i))));
					net.appendChild(net2);
					
					net2 = doc.createElement("Longitud");
					net2.appendChild(doc.createTextNode(String.valueOf(e.getPuntoLongitud(i))));
					net.appendChild(net2);
					
					hijo.appendChild(net);
				}
				Ruta.appendChild(hijo);
				raiz.appendChild(Ruta);
			}
		}
		catch (EOFException eof)
		{
			file.close();
		}
		Transformer transformar = TransformerFactory.newInstance().newTransformer();	
		DOMSource source = new DOMSource(doc);
		StreamResult resultado = new StreamResult (new FileOutputStream("Rutas.xml"));
		
		transformar.transform(source, resultado);
		
	}
}
