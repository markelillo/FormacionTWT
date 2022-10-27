package com.curso.EjemploRepaso.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENTS")
@NamedQueries({
	@NamedQuery(name = "Departamento.getAll", query = "SELECT d FROM Departamento d"),
	@NamedQuery(name = "Depatamneto.findByManager", query = "SELECT d FROM Departamento d WHERE d.managerId= :IdDeManager"),
	@NamedQuery(name = "Depatamneto.findSinManager", query = "SELECT d FROM Departamento d WHERE d.managerId IS NULL")
})
public class Departamento implements Serializable {

	@Id
	@Column(name = "DEPARTMENT_ID")
	private Integer id;
	
	@Column(name = "DEPARTMENT_NAME")
	private String nombreDeparmento;
	
	@Column(name = "MANAGER_ID")
	private Integer managerId;
	
	@Column(name = "LOCATION_ID")
	private Integer idLocalidad;

	public Departamento() {
		super();
	}

	public Departamento(Integer id, String nombreDeparmento, Integer managerId, Integer idLocalidad) {
		super();
		this.id = id;
		this.nombreDeparmento = nombreDeparmento;
		this.managerId = managerId;
		this.idLocalidad = idLocalidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreDeparmento() {
		return nombreDeparmento;
	}

	public void setNombreDeparmento(String nombreDeparmento) {
		this.nombreDeparmento = nombreDeparmento;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Integer idLocalidad) {
		this.idLocalidad = idLocalidad;
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
		Departamento other = (Departamento) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Departamento [nombreDeparmento=" + nombreDeparmento + ", managerId=" + managerId + ", idLocalidad="
				+ idLocalidad + "]";
	}
	
	



}
