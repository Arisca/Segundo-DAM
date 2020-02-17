import java.io.Serializable;

public class Coordenadas implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Double Latitud = 0.0;
	private Double Longitud = 0.0;

	public Coordenadas(double Latitud, double Longitud)
	{
		this.Latitud = Latitud;
		this.Longitud = Longitud;
	}

	public double getLongitud()
	{
		return this.Longitud;
	}
	
	public void setLongitud (double Longitud)
	{
		this.Longitud = Longitud;
	}

	public double Latitud()
	{
		return this.Latitud;
	}
	
	public void setLatitud (double Latitud)
	{
		this.Latitud = Latitud;
	}

}
