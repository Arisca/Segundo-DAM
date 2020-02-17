package Ejercicios;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import clases.Comarca;
import clases.Poblacio;
import clases.SessionFactoryUtil;

public class Pantalla_Ver_Pueblos_Comarca extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
    JLabel etiqueta = new JLabel ( "Comarca:");
    JLabel et_ini = new JLabel ( "Introduce la comarca:");
    JTextField com = new JTextField (15);
    JButton consultar = new JButton ( "Consultar");
    JTextArea area = new JTextArea ();
    
    // al iniciar ponemos un contenedor para los elementos anteriores
    public void iniciar () {
        this.setBounds (100, 100, 450, 300);
        this.setLayout (new BorderLayout ());
        // contenedor para los elementos
        JPanel panell1 = new JPanel (new FlowLayout ());
        panell1.add (et_ini);
        panell1.add (com);
        panell1.add (consultar);
        getContentPane (). add (panell1, BorderLayout.NORTH);
        
        JPanel panell2 = new JPanel (new BorderLayout ());
        panell2.add (etiqueta, BorderLayout.NORTH);
        area.setForeground (Color.blue);
        JScrollPane scroll = new JScrollPane (area);
        panell2.add (scroll, BorderLayout.CENTER);
        getContentPane (). add (panell2, BorderLayout.CENTER);
                
        
        setVisible (true);
        consultar.addActionListener (this);
    }

    public void actionPerformed (ActionEvent e) {
        if (e.getSource () == consultar) {
            etiqueta.setText ( "Comarca:" + com.getText ());
            visualitzaCom (com.getText ());
        }
    }

    private void visualitzaCom (String comarca)
    {
    	SessionFactory sf = SessionFactoryUtil.getSessionFactory();
        Session sessio = sf.openSession();
        
        Comarca com = (Comarca) sessio.load(Comarca.class, comarca);
                       
        try {
        	area.setText("");
        area.append("La comarca "+ com.getNomC()+" tiene "+com.getPoblacios().size()+" Pueblos:\n\n");
        for (Poblacio p : com.getPoblacios())
            area.append(p.getNom()+ "\n");
        }catch(Exception e) {
			area.setText("");
			System.out.println(e);
			area.append("!!Esta comarca no existe¡¡");
        }

    }
}

