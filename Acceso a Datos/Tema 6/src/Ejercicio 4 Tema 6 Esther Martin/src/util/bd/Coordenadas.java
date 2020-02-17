package util.bd;
import java.io.Serializable;

public class Coordenadas implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	private double Latitud = 0.0;
	private double Longitud = 0.0;
	
	
	public Coordenadas (double Latitud, double Longitud)
	{
		this.Latitud = Latitud;
		this.Longitud = Longitud;
	}
	
	public double getLatitud()
	{
		return this.Latitud;
	}
	
	public void setLatitud (double Latitud)
	{
		this.Latitud = Latitud;
	}
	
	public double getLongitud()
	{
		return this.Longitud;
	}
	
	public void setLongitud (double Longitud)
	{
		this.Longitud = Longitud;
	}
}
