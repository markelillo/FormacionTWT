package com.curso.EjemploRepaso.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.*;



@Entity
@Table(name = "REGIONS")
public class Region implements Serializable {
	@Id
	@Column(name = "REGION_ID")
	private Integer id;
	@Column(name = "REGION_NAME")
	private String nombreReg;
	@OneToMany(mappedBy = "region", fetch = FetchType.EAGER)
	//mappedby es el nombre de la clase order que tiene la relacion @ManyToOne
	private Collection<Countries> paises;
	public Region() {
		super();
	}

	public Region(Integer id, String nombreReg) {
		super();
		this.id = id;
		this.nombreReg = nombreReg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreReg() {
		return nombreReg;
	}

	public void setNombreReg(String nombreReg) {
		this.nombreReg = nombreReg;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Region other = (Region) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Region [nombreReg=" + nombreReg + "]";
	}

}
