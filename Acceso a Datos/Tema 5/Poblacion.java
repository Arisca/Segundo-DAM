package Ejercicios_del_Tema;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Poblacion implements java.io.Serializable
{
    private int codM;
    private Comarca comarca;
    private String nombre;
    private Integer poblacion;
    private BigDecimal extension;
    private Short altura;
    private String longitud;
    private String latitud;
    private Character lengua;
    private Set <Instituto> institutos = new HashSet <Instituto> (0);

    public Poblacion () {}

    public Poblacion (int codM, String nombre) {
        this.codM = codM;
        this.nombre = nombre;
    }

    public Poblacion (int codM, Comarca comarca, String nombre, Integer poblacion, BigDecimal extension, Short altura,
            String longitud, String latitud, Character lengua, Set <Instituto> institutos) {
        this.codM = codM;
        this.comarca = comarca;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.extension = extension;
        this.altura = altura;
        this.longitud = longitud;
        this.latitud = latitud;
        this.lengua = lengua;
        this.institutos = institutos;
    }

    ...

    public Comarca getComarca ()
    {
        return this.comarca;
    }

    public void setComarca (Comarca comarca)
    {
        this.comarca = comarca;
    }

   // ... //

    public Set <Instituto> getInstituts ()
    {
        return this.institutos;
    }

    public void setInstituts (Set <Institutos> institutos)
    {
        this.institutos = institutos;
    }
}
