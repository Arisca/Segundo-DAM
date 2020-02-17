
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

public class Vista_Rutas_JSON_Ventana
{
	JComboBox combo;
    JTextArea area = new JTextArea();
    
    JsonObject raiz;
    JsonArray rutas;
    
    public void iniciar() throws FileNotFoundException, IOException, JsonException
    {
    	raiz = (JsonObject) Jsoner.deserialize(new FileReader("Rutas.json"));
    	rutas = (JsonArray) raiz.get("rutas");
    	
    	this.setBounds(100, 100, 450, 300);
        this.setLayout(new BorderLayout());
        
        JPanel panel1 = new JPanel(new FlowLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.CENTER);
        
        ArrayList<String> Lista_Rutas = new ArrayList<String>();
        
        for(Object e : rutas)
        {
    		JsonObject Nombre = (JsonObject) e;
        	Lista_Rutas.add((String) Nombre.get("Nombre"));
    	}
        
        combo = new JComboBox(Lista_Rutas.toArray());
        
        panel1.add(combo);
        
        panel2.add(new JLabel("LLista de punts de la ruta:"),BorderLayout.NORTH);
        panel2.add(area,BorderLayout.CENTER);
        
        this.setVisible(true);
        combo.addActionListener(this);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == combo)
        {
        	area.setText("");
        	JsonObject ruta = (JsonObject) rutas.get(combo.getSelectedIndex());
        	JsonArray puntos = (JsonArray) ruta.get("Puntos");
        	for(Object a : puntos)
        	{
        		JsonObject punto = (JsonObject) a;
        		String mensaje = punto.get("nom")+" ("+punto.get("Latitud")+", "+punto.get("Longitud")+")\n";
        		area.append( mensaje);
        	}
        
        }
    }
}

