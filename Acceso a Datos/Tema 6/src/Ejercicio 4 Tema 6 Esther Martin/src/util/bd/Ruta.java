package util.bd;

import java.io.Serializable;
import java.util.ArrayList;

public class Ruta implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private String Nombre = null;
	private ArrayList<PuntGeo> ListadePuntos;
	private int Desnivel = 0;
	private int Desnivel_Acumulado=0;
	
	public Ruta()
	{
		this.ListadePuntos = new ArrayList<PuntGeo>();
	}
	
	public Ruta (String Nombre, ArrayList<PuntGeo> ListadePuntos, int Desnivel, int Desnivel_Acumulado)
	{
		super ();
		this.Nombre = Nombre;
		this.ListadePuntos = ListadePuntos;
		this.Desnivel = Desnivel;
		this.Desnivel_Acumulado = Desnivel_Acumulado;
	}
	
	public String getNombre ()
	{
		return Nombre;
	}
	
	public void setNombre (String Nombre)
	{
		this.Nombre = Nombre;
	}
	
	public ArrayList<PuntGeo> getListadePuntos()
	{
		return ListadePuntos;
	}
	
	public void setListadePuntos (ArrayList<PuntGeo> ListadePuntos)
	{
		this.ListadePuntos = ListadePuntos;
	}
	
	public int getDesnivel()
	{
		return Desnivel;
	}
	
	public void setDesnivel(int Desnivel)
	{
		this.Desnivel = Desnivel;
	}
	
	public int getDesnivel_Acumulado()
	{
		return Desnivel_Acumulado;
	}
	
	public void setDesnivel_Acumulado(int Desnivel_Acumulado)
	{
		this.Desnivel_Acumulado = Desnivel_Acumulado;
	}
	
	public void addPunto (PuntGeo Punto)
	{
		this.ListadePuntos.add(Punto);
	}
	
	public void addPunto (String Nombre, double Latitud, double Longitud)
	{
		PuntGeo Punto = new PuntGeo (Nombre, Latitud, Longitud);
		this.ListadePuntos.add(Punto);
	}
	
	public PuntGeo getPunto (int i)
	{
		return ListadePuntos.get(i);
	}
	
	public String getPuntoNombre (int i)
	{
		return ListadePuntos.get(i).getNombre();
	}
	
	public double getPuntoLatitud (int i)
	{
		return ListadePuntos.get(i).getLatitud();
	}
	
	public double getPuntLongitud (int i)
	{
		return ListadePuntos.get(i).getLatitud();
	}
	
	public double getPuntoLongitud (int i)
	{
		return ListadePuntos.get(i).getLongitud();
	}
	
	public int length()
	{
		return this.ListadePuntos.size();
	}
	
	public void MostrarRuta ()
	{
		System.out.println("Ruta: "+getNombre());
		System.out.println("Desnivel: "+getDesnivel());
		System.out.println("Desnivel Acumulado: "+getDesnivel_Acumulado());
		System.out.println("Número de puntos: "+length());
		System.out.println("----------------------------------------");
		for(int i=0;i<length();i++)
		{
			System.out.println("Punto "+(i+1)+": "+this.getPuntoNombre(i)+" ("+this.getPuntoLatitud(i)+this.getPuntoLongitud(i)+").");
		}
	}
}
