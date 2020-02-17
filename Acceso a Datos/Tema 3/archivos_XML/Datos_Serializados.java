package archivos_XML;

import java.io.Serializable;

public class Datos_Serializados implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int num = 0;
	private String nombre = null;
	private int departamento = 0;
	private int edad = 0;
	private double sueldo = 0.0;

	public Datos_Serializados () {}

	public Datos_Serializados (int num, String nombre, int dep, int edad, double sueldo)
	{
		this.num = num;
		this.nombre = nombre;
		this.departamento = dep;
		this.edad = edad;
		this.sueldo = sueldo;
	}

	public int getNum() {return num;}

	public String getNombre() {	return nombre;}

	public int getDepartamento() {return departamento;}
	
	public int getEdad() {return edad;}
	
	public double getSueldo() {	return sueldo;}

	public static long getSerialversionuid() {return serialVersionUID;}
}

