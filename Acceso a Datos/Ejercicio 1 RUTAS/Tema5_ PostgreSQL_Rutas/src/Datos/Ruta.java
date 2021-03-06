package Datos;
// Generated 03-dic-2019 12:20:45 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Ruta generated by hbm2java
 */
public class Ruta implements java.io.Serializable {

	private int numR;
	private String nomR;
	private Integer desnivell;
	private Integer desnivellAcumulat;
	private Set<Punt> punts = new HashSet<Punt>(0);

	public Ruta() {
	}

	public Ruta(int numR) {
		this.numR = numR;
	}

	public Ruta(int numR, String nomR, Integer desnivell, Integer desnivellAcumulat, Set<Punt> punts) {
		this.numR = numR;
		this.nomR = nomR;
		this.desnivell = desnivell;
		this.desnivellAcumulat = desnivellAcumulat;
		this.punts = punts;
	}

	public int getNumR() {
		return this.numR;
	}

	public void setNumR(int numR) {
		this.numR = numR;
	}

	public String getNomR() {
		return this.nomR;
	}

	public void setNomR(String nomR) {
		this.nomR = nomR;
	}

	public Integer getDesnivell() {
		return this.desnivell;
	}

	public void setDesnivell(Integer desnivell) {
		this.desnivell = desnivell;
	}

	public Integer getDesnivellAcumulat() {
		return this.desnivellAcumulat;
	}

	public void setDesnivellAcumulat(Integer desnivellAcumulat) {
		this.desnivellAcumulat = desnivellAcumulat;
	}

	public Set<Punt> getPunts() {
		return this.punts;
	}

	public void setPunts(Set<Punt> punts) {
		this.punts = punts;
	}

}
