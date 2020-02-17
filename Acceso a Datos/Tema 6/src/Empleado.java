
public class Empleado
{
	private String nif;
	private String nombre;
	private int departamento;
	private int edad = 0;
	private double sueldo = 0.0;
	private byte [] foto;
	private char [] curriculum;
	private Direccion Direccion;
	private String [] correus_e;
	private Telefono [] telefonos;
 
	public Empleado (){}
 
	public Empleado (String nif)
	{
		this.setNif (nif);
	}
 
	public Empleado (String nif, String nombre, int dep, int edad, double sueldo, byte [] foto, char [] curr, Direccion adr, String [] corr, Telefono [] tels) {
		this.setNif (nif);
		this.setNombre (nombre);
		this.setDepartamento (dep);
		this.setEdad (edad);
		this.setSueldo (sueldo);
		this.setFoto (foto);
		this.setCurriculum (curr);
		this.setDirección (adr);
		this.setCorreus_e (corr);
		this.setTelefonos (tels);
	}

	private void setsueldo(sdouble sueldo) {}

	public String getNif()
	{
		return nif;
	}

	public void setNif(String nif)
	{
		this.nif = nif;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento)
	{
		this.departamento = departamento;
	}

	public int getEdad()
	{
		return edad;
	}

	public void setEdad(int edad)
	{
		this.edad = edad;
	}

	public double getSueldo()
	{
		return sueldo;
	}

	public void setSueldo(double sueldo)
	{
		this.sueldo = sueldo;
	}

	public byte[] getFoto()
	{
		return foto;
	}

	public void setFoto(byte[] foto)
	{
		this.foto = foto;
	}

	public char[] getCurriculum()
	{
		return curriculum;
	}

	public void setCurriculum(char[] curriculum)
	{
		this.curriculum = curriculum;
	}

	public Direccion getDireccion()
	{
		return Direccion;
	}

	public void setDireccion(Direccion direccion)
	{
		Direccion = direccion;
	}

	public String[] getCorreus_e()
	{
		return correus_e;
	}

	public void setCorreus_e(String[] correus_e)
	{
		this.correus_e = correus_e;
	}

	public Telefono[] getTelefonos()
	{
		return telefonos;
	}

	public void setTelefonos(Telefono[] telefonos)
	{
		this.telefonos = telefonos;
	}
	
	
}