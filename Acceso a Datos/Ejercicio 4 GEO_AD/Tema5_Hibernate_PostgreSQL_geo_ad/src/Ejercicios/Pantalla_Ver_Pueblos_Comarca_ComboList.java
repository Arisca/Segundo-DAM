package Ejercicios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import clases.Comarca;
import clases.Institut;
import clases.Poblacio;
import clases.SessionFactoryUtil;

public class Pantalla_Ver_Pueblos_Comarca_ComboList extends JFrame implements ActionListener, ListSelectionListener 
{
	private static final long serialVersionUID = 1L;
    JLabel etiqueta = new JLabel ( "Comarca:");
    JLabel et_ini = new JLabel ( "Introduce la comarca:");
    JComboBox com = new JComboBox ();
    DefaultListModel listModel = new DefaultListModel ();
    JList area = new JList (listModel);
    JTextField pie = new JTextField ();
    
    // al iniciar ponemos un contenedor para los elementos anteriores
    public void iniciar () {
        this.setBounds (100, 100, 450, 300);
        this.setLayout (new BorderLayout ());
        // contenedor para los elementos
        JPanel panell1 = new JPanel (new FlowLayout ());
        panell1.add (et_ini);
        panell1.add (com);
        getContentPane (). add (panell1, BorderLayout.NORTH);
        
        JPanel panell2 = new JPanel (new BorderLayout ());
        panell2.add (etiqueta, BorderLayout.NORTH);
        area.setForeground (Color.blue);
        JScrollPane scroll = new JScrollPane (area);
        panell2.add (scroll, BorderLayout.CENTER);
        getContentPane (). add (panell2, BorderLayout.CENTER);
        getContentPane (). add (pie, BorderLayout.SOUTH);

        agafarComarques ();

        setVisible (true);
        
        com.addActionListener (this);
        area.addListSelectionListener (this);
    }

    public void actionPerformed (ActionEvent e) {
        if (e.getSource () == com) {
            etiqueta.setText ( "Lista de pueblos de la comarca:" + com.getSelectedItem ());
            visualitzaCom (com.getSelectedItem (). toString ());
        }
    }
    
    @Override
    public void valueChanged (ListSelectionEvent e) {
        JList l = (JList) e.getSource ();
        if (l.getSelectedIndex () >= 0) {
            visualitzaInstituts (l.getSelectedValue (). toString ());
        }
    }

    private void visualitzaCom (String comarca) {

    	SessionFactory sf = SessionFactoryUtil.getSessionFactory();
        Session sesion = sf.openSession();
        
        Comarca com = (Comarca) sesion.load(Comarca.class, comarca);


		for (Poblacio p : com.getPoblacios())
			listModel.addElement(p.getNom());
    }
    
    private void agafarComarques ()
    {
    	ArrayList<String> lista_comarcas = new ArrayList<String>();
    	
    	SessionFactory sf = SessionFactoryUtil.getSessionFactory();
        Session sessio = sf.openSession();
        
        Query q = sessio.createQuery("from Comarca order by nomC");

        List<Comarca> llista = q.list();

        Iterator<Comarca> it = llista.iterator();
        while (it.hasNext()) {
            Comarca com = it.next();
            lista_comarcas.add(com.getNomC());
        }
        com = new JComboBox(lista_comarcas.toArray());

    }
    
    private void visualitzaInstituts (String pueblo)
    {
    	SessionFactory sf = SessionFactoryUtil.getSessionFactory();
        Session sesion = sf.openSession();
        
        Query q = sesion.createQuery("from Poblacio where nom='"+pueblo.replaceAll("'", "''")+"'");

        Poblacio p= (Poblacio) q.uniqueResult();
        pie.setText(pueblo + " Tiene "+p.getInstituts().size()+" Institutos.");   
    }
}
