package Ejercicio3_voluntario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.awt.event.ActionEvent;

public class Ejercicio3 extends JFrame
{

	private static final long serialVersionUID = -851680165446149532L;
	
	private JPanel contentPane;
	private JMenu archivo;
	private JMenu ayuda;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem guardarcomo;
	private JMenuItem sobre;
	private JMenuItem salir;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Ejercicio3 frame = new Ejercicio3();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Ejercicio3() 
	{
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 28, 732, 424);
		contentPane.add(textArea);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
		contentPane.add(menuBar);
		menuBar.setVisible(true);
		archivo = new JMenu ("Archivo");
		archivo.setFont(new Font("Verdana", Font.PLAIN, 20));
		ayuda = new JMenu ("Ayuda");
		ayuda.setFont(new Font("Verdana", Font.PLAIN, 20));
		abrir = new JMenuItem ("Abrir");
		abrir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JFileChooser fc=new JFileChooser();
				fc.setMultiSelectionEnabled(true);
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
				fc.setFileFilter(filtro);
				int seleccion=fc.showOpenDialog(contentPane);
				if(seleccion==JFileChooser.APPROVE_OPTION)
				{
					File[] ficheros=fc.getSelectedFiles();
					for(int i=0;i<ficheros.length;i++)
					{
						try(FileReader fr=new FileReader(ficheros[i]))
						{
							String cadena="";
				            int valor=fr.read();
				            while(valor!=-1)
				            {
				                cadena=cadena+(char)valor;
				                valor=fr.read();
				            }
				            textArea.setText(cadena+"\n");
						}
						catch (IOException e1)
						{
							e1.printStackTrace();
						}
					}
				}
			}
		});
		guardar = new JMenuItem ("Guardar");
		guardar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JFileChooser fc=new JFileChooser();
				int seleccion=fc.showSaveDialog(contentPane);
				if(seleccion==JFileChooser.APPROVE_OPTION)
				{
					File fichero=fc.getSelectedFile();
					try(FileWriter fw=new FileWriter(fichero))
					{
						fw.write(textArea.getText());
					}
					catch (IOException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		});
		
		guardarcomo = new JMenuItem ("Guardar como...");
		guardarcomo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser fc=new JFileChooser();
				int seleccion=fc.showSaveDialog(contentPane);
				if(seleccion==JFileChooser.APPROVE_OPTION)
				{
					File fichero=fc.getSelectedFile();
					try(FileWriter fw=new FileWriter(fichero))
					{
						fw.write(textArea.getText());
					}
					catch (IOException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		});
		sobre = new JMenuItem ("Sobre el editor...");
		sobre.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				MostrarVentana();
			}
		});
		salir = new JMenuItem ("Salir");
		salir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int res= JOptionPane.showConfirmDialog(contentPane, "¿Desea salir?", "Salir",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if (res==JOptionPane.YES_OPTION) System.exit(0);
			}
		});
		archivo.add(abrir);
		archivo.add(guardar);
		archivo.add(guardarcomo);
		archivo.add(salir);
		ayuda.add(sobre);
		menuBar.setBounds(0, 0, 156, 28);
		menuBar.add(archivo);
		menuBar.add(ayuda);
		
	}

	private void MostrarVentana()
	{
		JFrame frame = new JFrame("Sobre el Editor de Texto");   
		JPanel panel=new JPanel();
		JLabel a = new JLabel("Editor de Texto creado por Esther Martin Calvo");
		JLabel b = new JLabel("Para la Asignatura de Acceso a Datos");
		JLabel c = new JLabel("Septiembre de 2019");
		
		panel.add(a);
		panel.add(b);
		panel.add(c);
		frame.getContentPane().add(panel);
		frame.setSize(500, 100);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(contentPane); 
		frame.setVisible(true);
	}
}
