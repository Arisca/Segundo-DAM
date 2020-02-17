
public class Direccion
{
	private String calle;
    private String codipostal;
    private String poblacion;

    public Direccion (String c, String cp, String p)
    {
       setCarrer (c);
       setCodipostal (cp);
       setPoblacio (p);
    }

    public String getCarrer ()
    {
        return calle;
    }

    public void setCarrer (String calle)
    {
        this.calle = calle;
    }

    public String getCodipostal ()
    {
        return codipostal;
    }

    public void setCodipostal (String codipostal)
    {
        this.codipostal = codipostal;
    }

    public String getPoblacion ()
    {
        return poblacion;
    }

    public void setPoblacio (String poblacion)
    {
        this.poblacion = poblacion;
    }

}