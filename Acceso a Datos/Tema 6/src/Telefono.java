
public class Telefono
{
	private boolean movil;
    private String numero;

    public Telefono () {}

    public Telefono (boolean m, String num)
    {
        setMobil (m);
        setNumero (num);
    }

    public boolean isMovil()
    {
        return movil;
    }

    public void setMobil (boolean móvil)
    {
        this.movil = móvil;
    }

    public String getNumero ()
    {
        return numero;
    }

    public void setNumero (String numero)
    {
        this.numero = numero;
    }

}
