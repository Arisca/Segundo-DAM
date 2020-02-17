package util.bd;
import java.io.Serializable;

public class PuntGeo implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private String Nombre = null;
	private Coordenadas Coordenadas = null;
	
	public PuntGeo (String Nombre, Coordenadas Coordenadas)
	{
		this.Nombre = Nombre;
		this.Coordenadas = Coordenadas;
	}
	
	public PuntGeo (String Nombre, double Latitud, double Longitud)
	{
		this.Nombre = Nombre;
		Coordenadas = new Coordenadas (Latitud, Longitud);
	}
	
	public String getNombre ()
	{
		return Nombre;
	}
	
	public void setNombre (String Nombre)
	{
		this.Nombre = Nombre;
	}
	
	public Coordenadas getCoordenadas()
	{
		return Coordenadas;
	}
	
	public double getLatitud ()
	{
		return Coordenadas.getLatitud();
	}
	
	public double getLongitud()
	{
		return Coordenadas.getLongitud();
	}
}
