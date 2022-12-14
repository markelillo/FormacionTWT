package com.curso.jpa.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;
@Entity
public class Record implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CURSO_SEQ")
	@SequenceGenerator(sequenceName = "CURSO_SEQ", name = "CURSO_SEQ", allocationSize=1)	
	@Column(name="RECID")
	private Integer id;
	@Column(name="RECORD_NAME")
	private String  name;

	@OneToOne(mappedBy = "record")//nombre del atributo que tiene la relacion onetoone en Customer
	private Customer customer;
	
	public Record() {
		super();
	}

	public Record(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Record [Id=" + id + ", name=" + name + "]";
	}

}
