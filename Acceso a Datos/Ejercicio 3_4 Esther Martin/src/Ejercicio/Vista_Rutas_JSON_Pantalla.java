package Ejercicio;


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
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.github.cliftonlabs.json_simple.JsonException;


public class Vista_Rutas_JSON_Pantalla extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	
	JComboBox combobox;
	JTextArea textarea = new JTextArea ();
	
	JsonObject raiz;
	JsonArray rutas;
	
	public void iniciar() throws FileNotFoundException, IOException, JsonException
	{
		raiz = (JsonObject) Jsoner.deserialize (new FileReader("Rutas.json"));
		rutas = (JsonArray) raiz.get("Rutas");
		
		this.setBounds(100, 100, 450, 300);
        this.setLayout(new BorderLayout());
        
        JPanel panell1 = new JPanel(new FlowLayout());
        JPanel panell2 = new JPanel(new BorderLayout());
        this.add(panell1,BorderLayout.NORTH);
        this.add(panell2,BorderLayout.CENTER);
        
        ArrayList<String> Lista_de_rutas = new ArrayList <String>();
        
        for (Object ob : rutas)
        {
        	JsonObject nombre = (JsonObject) ob;
        	Lista_de_rutas.add((String) nombre.get("Nombre"));
        }
        
        combobox = new JComboBox (Lista_de_rutas.toArray());
        
        panell1.add(combobox);
        
        panell2.add(new JLabel("Listado de puntos de ruta: "),BorderLayout.NORTH);
        panell2.add(textarea,BorderLayout.CENTER);
        
        this.setVisible(true);
        combobox.addActionListener(this);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == combobox)
		{
			textarea.setText("");
        	JsonObject ruta = (JsonObject) rutas.get(combobox.getSelectedIndex());
        	JsonArray puntos = (JsonArray) ruta.get("Puntos");
        	for(Object a : puntos)
        	{
        		JsonObject punt = (JsonObject) a;
        		String mensaje = punt.get("Nombre")+" ("+punt.get("Latitud")+", "+punt.get("Longitud")+")\n";
        		textarea.append( mensaje);
        	}
		}
	}
}
