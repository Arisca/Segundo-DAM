package Ejercicio2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Ejercicio2 extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Ejercicio2 frame = new Ejercicio2();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Ejercicio2()
	{		
		setTitle("Ejercicio 2 de M\u00AA Esther Martin Calvo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField.setBounds(196, 30, 325, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Fichero :");
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 18));
		lblNewLabel.setBounds(109, 31, 93, 27);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 219, 641, 178);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton botonabrir = new JButton("Abrir");
		botonabrir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String texto = textField.getText();
				File archivo = new File (texto);
				FileReader fichero_in = null;
				try
				{
					if (archivo.exists())
					{
						String j = "";
						fichero_in = new FileReader(archivo);
						int n = fichero_in.read();
						while (n != -1) {
							
							j = j + Character.toString((char)n);
							n = fichero_in.read();
						}
						textArea.setText(j);
						fichero_in.close();
					}
					else
					{
						 JOptionPane.showMessageDialog(rootPane, "¡ERROR! El archivo " + archivo + " no existe");						 
					}
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}	
			}
		});
		botonabrir.setFont(new Font("Malgun Gothic", Font.PLAIN, 18));
		botonabrir.setBounds(196, 127, 136, 36);
		contentPane.add(botonabrir);
		
		JButton botonguardar = new JButton("Guardar");
		botonguardar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String texto = textField.getText();
				File archivo = new File (texto);
				FileWriter fichero_out = null;
				try
				{
					texto = texto.replaceAll(" ", "");
					if (texto.length() == 0)
					{
						JOptionPane.showMessageDialog(rootPane, "¡ERROR! No se ha indicado ningún fichero");
					}
					else
					{
						fichero_out = new FileWriter (archivo);
						fichero_out.write(textArea.getText());
						fichero_out.close();
						JOptionPane.showMessageDialog(contentPane, "Fichero creado con éxito");
					}
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		botonguardar.setFont(new Font("Malgun Gothic", Font.PLAIN, 18));
		botonguardar.setBounds(385, 127, 136, 36);
		contentPane.add(botonguardar);
		
	}
}
