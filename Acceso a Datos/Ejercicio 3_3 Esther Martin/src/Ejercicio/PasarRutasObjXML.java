// Hacer una clase llamada PassarRutesObjXML (con main) que pase el archivo Rutes.obj a un archivo XML llamado Rutes.xml 
// Los puntos suspensivos indican que hay más de un punto en cada ruta, y que hay más de una ruta
//

package Ejercicio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.EOFException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PasarRutasObjXML
{
	public static void main(String[] args) throws IOException, ParserConfigurationException, ClassNotFoundException, TransformerException
	{
		ObjectInputStream file = new ObjectInputStream (new FileInputStream("Rutas.obj"));
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element raiz = doc.createElement ("Rutas");
		doc.appendChild(raiz);
		
		Ruta R;
		try
		{
			while (true)
			{
				R = (Ruta) file.readObject();
				Element ruta = doc.createElement ("Ruta");
				
				Element hijo = doc.createElement("Nombre");
				hijo.appendChild(doc.createTextNode(R.getNombre()));
				ruta.appendChild(hijo);
				
				hijo = doc.createElement("Desnivel");
				hijo.appendChild(doc.createTextNode(Integer.toString(R.getDesnivel())));
				ruta.appendChild(hijo);
				
				hijo = doc.createElement ("Desnivel_Acumulado");
				hijo.appendChild(doc.createTextNode(Integer.toString(R.getDesnivel_Acumulado())));
				ruta.appendChild(hijo);
				
				hijo = doc.createElement ("Puntos");
				for (int i = 0; i < R.length(); i ++)
				{
					Element net = doc.createElement("Punto");
					net.setAttribute ("Número", Integer.toString(i+1));
					
					Element net2 = doc.createElement("Nombre");
					net2.appendChild(doc.createTextNode(R.getPuntoNombre(i)));
					net.appendChild(net2);
					
					net2 = doc.createElement("Latitud");
					net2.appendChild(doc.createTextNode(String.valueOf(R.getPuntoLatitud(i))));
					net.appendChild(net2);
					
					net2 = doc.createElement("Longitud");
					net2.appendChild(doc.createTextNode(String.valueOf(R.getPuntoLongitud(i))));
					net.appendChild(net2);
					
					hijo.appendChild(net);
				}
				ruta.appendChild(hijo);
				raiz.appendChild(ruta);
			}
		}
		catch (EOFException eof)
		{
			file.close();
		}
		Transformer transformar = TransformerFactory.newInstance().newTransformer();
			
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new FileOutputStream("Rutas.xml"));
			
		transformar.transform(source, result);
		}
	}

