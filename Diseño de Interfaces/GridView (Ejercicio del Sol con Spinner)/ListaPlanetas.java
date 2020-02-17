package com.example.elsol;

class ListaPlanetas
{
    private String planetas;
    private String diametro;
    private String distancia;
    private String densidad;

    public ListaPlanetas (String planetas, String diametro, String distancia, String densidad)
    {
        this.planetas = planetas;
        this.diametro = diametro;
        this.distancia = distancia;
        this.densidad = densidad;
    }

    public String getPlanetas()
    {
        return this.planetas;
    }

    public void setPlanetas(String planetas)
    {
        this.planetas = planetas;
    }

    public String getDiametro()
    {
        return this.diametro;
    }

    public void setDiametro(String diametro)
    {
        this.diametro = diametro;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia)
    {
        this.distancia = distancia;
    }

    public String getDensidad()
    {
        return densidad;
    }

    public void setDensidad(String densidad)
    {
        this.densidad = densidad;
    }
}
