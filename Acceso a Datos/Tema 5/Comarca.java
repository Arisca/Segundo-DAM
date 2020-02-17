package Ejercicios_del_Tema;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.metamodel.relational.Size;

public class Comarca implements java.io.Serializable
{

	private static final long serialVersionUID = 1L;
	private String nomC;
    private String provincia;
    private Set <Poblacion> poblaci�ni = new HashSet <Poblacion> (0);

    public Comarca (){}

    public Comarca (String nomC)
    {
        this.nomC = nomC;
    }

    public Comarca (String nomC, String provincia, Set <Poblacion> poblaci�ni)
    {
        this.nomC = nomC;
        this.provincia = provincia;
        this.Poblacion = poblaci�ni;
    }

    public String getNomC ()
    {
        return this.nomC;
    }

    public void setNomC (String nomC)
    {
        this.nomC = nomC;
    }

    public String getProvincia ()
    {
        return this.provincia;
    }

    public void setProvincia (String provincia)
    {
        this.provincia = provincia;
    }

    public Set <Poblacion> getPoblacion ()
    {
        return this.Poblacion;
    }

    public void setPoblacios (Set <Poblacion> poblaci�ni)
    {
        this.Poblacion = poblaci�ni;
    }

}