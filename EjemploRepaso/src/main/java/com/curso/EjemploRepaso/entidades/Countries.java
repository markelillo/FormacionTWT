package com.curso.EjemploRepaso.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;




@Entity
@Table(name = "COUNTRIES")
public class Countries implements Serializable{
	
	@Id
	@Column(name = "COUNTRY_ID")
	private String countryId;
	@Column(name = "COUNTRY_NAME")
	private String nombrePais;
	@Column(name = "REGION_ID")
	private Integer idRegion;
	
	@ManyToOne
	@JoinColumn(name = "REGION_ID")//foreing key,,
			//referencedColumnName = "ID")// nombre de la columna primay key en la tabla clientes 
	private Region region;
	
	public Countries() {
		super();
	}
	public Countries(String countryId, String nombrePais, Integer idRegion) {
		super();
		this.countryId = countryId;
		this.nombrePais = nombrePais;
		this.idRegion = idRegion;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getNombrePais() {
		return nombrePais;
	}
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	public Integer getIdRegion() {
		return idRegion;
	}
	public void setIdRegion(Integer idRegion) {
		this.idRegion = idRegion;
	}
	@Override
	public int hashCode() {
		return Objects.hash(countryId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Countries other = (Countries) obj;
		return Objects.equals(countryId, other.countryId);
	}
	@Override
	public String toString() {
		return "Countries [nombrePais=" + nombrePais + ", idRegion=" + idRegion + "]";
	}

	
}
