package com.example.travel;

public class AndroidVersion
{
    int Imagen;
    String Nombre;

    public AndroidVersion (int Imagen, String Nombre)
    {
        super ();
        this.Imagen = Imagen;
        this.Nombre = Nombre;
    }

    public AndroidVersion(MainActivity mainActivity, int[] cards, String[] cardName) {
    }

    public int getImagen()
    {
        return Imagen;
    }

    public void setImagen(int imagen)
    {
        this.Imagen = imagen;
    }

    public String getNombre()
    {
        return Nombre;
    }

    public void setNombre(String nombre)
    {
        this.Nombre = nombre;
    }
}
