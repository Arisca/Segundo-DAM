import java.io.Serializable;

public class PuntGeo<coordenadas> implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String Nombre = null;
	private Coordenadas coordenadas = null;

	public PuntGeo (String Nombre, Coordenadas coordenadas)
	{
		this.Nombre = Nombre;
		this.coordenadas = coordenadas;
	}
	
	public PuntGeo(String Nombre, double Latitud, double Longitud)
	{
		this.Nombre = Nombre;
		coordenadas = new Coordenadas (Latitud, Longitud);
	}

	public String getNombre()
	{
		return Nombre;
	}
	
	public void setNombre(String Nombre)
	{
		this.Nombre = Nombre;
	}

	public Coordenadas getCoordenadas ()
	{
		return coordenadas;
	}
	public double getLongitud()
	{
		return coordenadas.getLongitud();
	}

	public double getLatitud()
	{
		return coordenadas.Latitud();
	}

}
