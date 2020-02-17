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

public class Vista_Rutas_XML_Pantalla extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	JComboBox<Object> combobox;
	JTextArea textarea = new JTextArea();
	Document doc;
	
	public void iniciar() throws SAXException, IOException, ParserConfigurationException
	{
		doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("Rutas.xml");
		
		this.setBounds(100, 100, 450, 300);
        this.setLayout(new BorderLayout());
        
        JPanel panel1 = new JPanel(new FlowLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.CENTER);
        
        ArrayList<String> Lista_de_rutas = new ArrayList<String>();
        Element raiz = doc.getDocumentElement();
        NodeList Lista = raiz.getElementsByTagName("ruta");
        	for (int i = 0; i < Lista.getLength(); i++)
        	{
        		Element elemento = (Element) Lista.item(i);
        		Lista_de_rutas.add(i, elemento.getElementsByTagName("Nombre").item(0).getChildNodes().item(0).getNodeValue());
        	}
        	
        combobox = new JComboBox<Object> (Lista_de_rutas.toArray());
        
        panel1.add(combobox);
        panel2.add(new JLabel("Listado de puntos de Ruta:"),BorderLayout.NORTH);
        panel2.add(textarea,BorderLayout.CENTER);
        
        this.setVisible(true);
        combobox.addActionListener(this);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
	}
	
	public void actionPerformed(ActionEvent e)
	{
    	textarea.setText("");
    	Element raiz = (Element) doc.getElementsByTagName("Puntos").item(combobox.getSelectedIndex());
    	NodeList Lista = raiz.getElementsByTagName("Punto");
    	for(int i=0;i<Lista.getLength();i++)
    	{
    		String mensaje=Lista.item(i).getFirstChild().getTextContent()+" ("+raiz.getElementsByTagName("Latitud").item(i).getTextContent()+", "+Lista.item(i).getLastChild().getTextContent()+")\n";
    		textarea.append(mensaje);
    	}
	}
}

