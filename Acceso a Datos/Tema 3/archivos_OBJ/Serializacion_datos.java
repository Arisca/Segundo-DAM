package archivos_OBJ;
import java.io.Serializable;

public class Serializacion_datos implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String nombres = null;
	private int telefono = 0;
	private String email = null;
	private double nota = 0.0;
	
	
	public Serializacion_datos (int numero, String nombres, int telefono, String email, double nota)
	{
		super();
		this.nombres = nombres;
		this.telefono = telefono;
		this.email = email;
		this.nota = nota;
	}
	
	public String getNombres() {return nombres;}

	public int getTelefono() {return telefono;}

	public String getEmail() {return email;}

	public double getNota() {return nota;}	
}
