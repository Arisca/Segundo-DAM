package Ejercicios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import clases.Comarca;
import clases.Poblacio;
import clases.SessionFactoryUtil;

public class Pantalla_Mantenimiento_Comarcas extends JFrame implements ActionListener
{
	JLabel etino = new JLabel ( "Mantenimiento de COMARCAS");
    JLabel etNom = new JLabel ( "Nombre comarca");
    JLabel etProv = new JLabel ( "Nombre provincia");
    
    JTextField nomComarca = new JTextField ();
    JTextField nomProvincia = new JTextField ();
    
    JButton primer = new JButton ( "<<");
    JButton anterior = new JButton ( "<");
    JButton siguiente = new JButton ( ">");
    JButton ultimo = new JButton ( ">>");
    
    JPanel pDalt = new JPanel (new FlowLayout ());
    JPanel pCentre = new JPanel (new GridLayout (8,0));
    JPanel pDades = new JPanel (new GridLayout (2,2));
    JPanel pBotonsMov = new JPanel (new FlowLayout ());
    
    Session s = SessionFactoryUtil.getSessionFactory().openSession ();
    
    ArrayList <Comarca> llistaComarques = new ArrayList <Comarca> ();
    int indActual = 0;
   
    public void iniciar () {
        this.setBounds (100, 100, 350, 400);
        this.setLayout (new BorderLayout ());
        
        this.getContentPane (). add (pCentre, BorderLayout.CENTER);
        this.getContentPane (). add (new JPanel (new FlowLayout ()), BorderLayout.WEST);
        this.getContentPane (). add (new JPanel (new FlowLayout ()), BorderLayout.EAST);
        
        pDalt.add (etino);        
        pCentre.add (pDalt);
                
        pDades.add (etNom);
        pDades.add (nomComarca);
        pDades.add (etProv);
        pDades.add (nomProvincia);
        pCentre.add (pDades);
        
        nomComarca.setEditable (false);
        nomProvincia.setEditable (false);

        pCentre.add (new JPanel (new FlowLayout ()));

        pBotonsMov.add (primer);
        pBotonsMov.add (anterior);
        pBotonsMov.add (siguiente);
        pBotonsMov.add (ultimo);
        pCentre.add (pBotonsMov);
        
        pCentre.add (new JPanel (new FlowLayout ()));

        llistaComarques = agafarComarques ();
        visComarca (indActual);

        this.setVisible (true);
        this.setDefaultCloseOperation (EXIT_ON_CLOSE);
        
        primer.addActionListener (this);
        anterior.addActionListener (this);
        siguiente.addActionListener (this);
        ultimo.addActionListener (this);

    }

    private void visComarca (int index)
    {
    	nomComarca.setText(llistaComarques.get(index).getNomC());   
    	SessionFactory sf = SessionFactoryUtil.getSessionFactory();
        Session sessio = sf.openSession();
        
        Query q = sessio.createQuery("from Comarca where nomC='"+llistaComarques.get(index).getNomC().replaceAll("'", "''")+"'");
    	
        Comarca p= (Comarca) q.uniqueResult();
        
        nomProvincia.setText("");
        nomProvincia.setText(p.getProvincia());
    }

    private ArrayList<Comarca> agafarComarques ()
    {
        ArrayList <Comarca> lista = new ArrayList<Comarca>() ;
        SessionFactory sf = SessionFactoryUtil.getSessionFactory();
        Session sessio = sf.openSession();
        

        Query q = sessio.createQuery("from Comarca order by nomC");

        List<Comarca> llis = q.list();

        Iterator<Comarca> it = llis.iterator();
        while (it.hasNext())
        {
            Comarca comarca = it.next();
            Comarca c = new Comarca(comarca.getNomC());
            lista.add(c);
        }
		return lista;
    }

    public void actionPerformed (ActionEvent e)
    {
        if (e.getSource () == primer)
        {
        	indActual=0;
        	visComarca(indActual);
        }

        if (e.getSource () == anterior)
        {
        	if (indActual==0)
        	{
        		indActual=0;
        		visComarca(indActual);
        	}
        	else
        	{
	        	indActual--;
	        	visComarca(indActual);
        	}
        }
        
        if (e.getSource () == siguiente)
        {
        	if (indActual >= llistaComarques.size()-1)
        	{
        		indActual=llistaComarques.size()-1;
        		visComarca(indActual);
        	}
        	else
        	{
        	indActual++;
        	visComarca(indActual);
        	}
        }

        if (e.getSource () == ultimo)
        {
        	indActual=llistaComarques.size()-1;
        	visComarca(indActual);
        }               
    }
}
