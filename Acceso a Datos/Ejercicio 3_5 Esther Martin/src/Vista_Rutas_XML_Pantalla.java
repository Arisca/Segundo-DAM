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

public class Vista_Rutas_XML_Pantalla extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	
	JComboBox combo;
	JTextArea area = new JTextArea();
	Document doc;

	public void iniciar() throws SAXException, IOException, ParserConfigurationException
	{
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("Rutas.xml");
		
		this.setBounds(100, 100, 450, 300);
        this.setLayout(new BorderLayout());
        
        JPanel panel1 = new JPanel(new FlowLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.CENTER);
        
        ArrayList<String> Lista_Rutas = new ArrayList<String>();
        Element raiz = doc.getDocumentElement();
        NodeList Lista = raiz.getElementsByTagName("Ruta");
        
        for (int i=0; i<Lista.getLength();i++)
        {
        	Element el = (Element) Lista.item(i);
        	Lista_Rutas.add(i, el.getElementsByTagName("Nombre").item(0).getChildNodes().item(0).getNodeValue());
        }
       
        panel1.add(combo);
        combo = new JComboBox(Lista_Rutas.toArray());
        panel2.add(new JLabel("Lista de puntos de la ruta : "), BorderLayout.NORTH);
        panel2.add(area,BorderLayout.CENTER);
        
        this.setVisible(true);
        combo.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Document doc = null;
		try
		{
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("Rutas.xml");
		}
		catch (SAXException | IOException | ParserConfigurationException e1)
		{
			e1.printStackTrace();
		}
		
		if (e.getSource() == combo)
		{
			String itemSeleccionado = (String)combo.getSelectedItem();
			
			if ("Subida a Penyagolosa".equals(itemSeleccionado))
				{
					area.setText("");
					Element raiz = (Element) doc.getElementsByTagName("Puntos").item(0);
					NodeList Lista = raiz.getElementsByTagName("Punto");
				
					for(int i=0;i<Lista.getLength();i++)
					{
						String mensaje= Lista.item(i).getFirstChild().getTextContent()+" ("+raiz.getElementsByTagName("Latitud").item(i).getTextContent()+", "+ Lista.item(i).getLastChild().getTextContent()+")\n";
						area.append(mensaje);
					}
				}
			else if ("La Magdalena".equals(itemSeleccionado))
			{
				area.setText("");
				Element raiz = (Element) doc.getElementsByTagName("Puntos").item(1);
				NodeList Lista = raiz.getElementsByTagName("Punto");
				
				for(int i=0;i<Lista.getLength();i++)
				{
					String mensaje=Lista.item(i).getFirstChild().getTextContent()+" ("+raiz.getElementsByTagName("Latitud").item(i).getTextContent()+", "+Lista.item(i).getLastChild().getTextContent()+")\n";
	            	area.append(mensaje);
				}
			}
		}
	}
}

