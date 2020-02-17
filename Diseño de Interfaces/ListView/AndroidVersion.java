package com.example.playjuegos;

public class AndroidVersion
{
    String nombre;
    String numero;
    int logo;

    public AndroidVersion (String nombre, String numero, int logo)
    {
        super ();
        this.nombre = nombre;
        this.numero = numero;
        this.logo = logo;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getLogo()
    {
        return logo;
    }

    public void setLogo(int logo)
    {
        this.logo = logo;
    }

    public String getNumero()
    {
        return numero;
    }

    public void setNumero(String numero)
    {
        this.numero = numero;
    }
}


