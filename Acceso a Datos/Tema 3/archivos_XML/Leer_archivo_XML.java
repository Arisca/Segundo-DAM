package archivos_XML;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Leer_archivo_XML
{
	public static void main (String [] args) throws SAXException, IOException, ParserConfigurationException
	{
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse ("Rutas.xml");
		
		System.out.println (doc.getNodeName ());
		
		NodeList ruta = doc.getElementsByTagName("ruta");
		
		System.out.println (doc.getNodeValue ());
		
		
		
		for (int i = 0; i < ruta.getLength(); i++)
		{
			Element e = (Element) ruta.item(i);
			System.out.println("Nombre de la Ruta : " + e.getElementsByTagName("Nombre").item(0).getTextContent());
			System.out.println("\t Desnivel : " +e.getElementsByTagName("Desnivel").item(0).getTextContent ());
			
			NodeList puntos = e.getElementsByTagName("Puntos");
			for (int j = 0; j < puntos.getLength(); j++)
			{
				System.out.println("\t \t Puntos : " +puntos.item(j).getTextContent() +" ;");
			}
		}
	}

}

	
