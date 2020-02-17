package Ejercicio;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class Rutas_XML
{
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException
	{
		Rutas_XML_Vista Mostrar = new Rutas_XML_Vista();
		Mostrar.iniciar();
	}
}
