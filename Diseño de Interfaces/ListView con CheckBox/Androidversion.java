package com.example.deportes;

public class Androidversion
{
    String nombre;
    int logo;

    public Androidversion (String nombre, int logo)
    {
        super();
        this.nombre = nombre;
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
}

