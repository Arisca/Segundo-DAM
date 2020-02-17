import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Vista_Rutas_XML
{
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException
	{
		Vista_Rutas_XML_Pantalla ventana = new Vista_Rutas_XML_Pantalla();
		ventana.iniciar();
	}
}
