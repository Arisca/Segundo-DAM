package Ejercicio;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Rutas_XML_Vista extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	JComboBox<Object> combobox;
	JTextArea textarea = new JTextArea();
	Document doc;
	
	public void iniciar() throws SAXException, IOException, ParserConfigurationException
	{
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("Rutas.xml");
		
		this.setBounds(100,100,450,300);
		this.setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel (new FlowLayout());
		JPanel panel2 = new JPanel (new BorderLayout());
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		
		ArrayList <String> Listado_Rutas = new ArrayList<String>();
		Element raiz = doc.getDocumentElement();
		NodeList Lista = raiz.getElementsByTagName ("Ruta");
		
		for (int i = 0; i < Lista.getLength(); i++)
		{
			Element elemento = (Element) Lista.item(i);
			Listado_Rutas.add(i, elemento.getElementsByTagName("Nombre").item(0).getChildNodes().item(0).getNodeValue());
		}
		
		combobox = new JComboBox<Object>(Listado_Rutas.toArray());
		
		panel1.add(combobox);
		combobox.addActionListener (this);
		panel2.add(new JLabel("Listado de puntos de la Ruta : "), BorderLayout.NORTH);
		panel2.add(textarea, BorderLayout.CENTER);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed (ActionEvent e)
	{
		Document doc = null;
		try
		{
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("Rutas.xml");
		}
		catch (SAXException | IOException | ParserConfigurationException ex)
		{
			ex.printStackTrace();
		}
		
		if (e.getSource() == combobox)
		{
			String itemSeleccionado = (String) combobox.getSelectedItem();
			
			if ("Pujada a Penyagolosa".equals (itemSeleccionado))
				{
					textarea.setText("");
					Element raiz = (Element) doc.getElementsByTagName("Punto").item(0);
					NodeList Listado = raiz.getElementsByTagName("Puntos");
					
					for (int i = 0; i<Listado.getLength(); i++)
					{
						String mensaje = Listado.item(i).getFirstChild().getTextContent()+" ("+raiz.getElementsByTagName("latitud").item(i).getTextContent()+", "+Listado.item(i).getLastChild().getTextContent()+")\n";
						textarea.append(mensaje);
					}
				}
				else if ("La Magdalena".equals((itemSeleccionado)))
				{
					textarea.setText("");
					Element raiz = (Element) doc.getElementsByTagName("Punto").item(1);
					NodeList Listado = raiz.getElementsByTagName("Puntos");
					for (int i = 0; i < Listado.getLength(); i++)
					{
						String mensaje = Listado.item(i).getFirstChild().getTextContent()+" ("+raiz.getElementsByTagName("latitud").item(i).getTextContent()+", "+Listado.item(i).getLastChild().getTextContent()+")\n";
						textarea.append (mensaje);
					}
						
				}
			}
		}

	}

