package com.curso.jpa.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.*;
@Entity
public class Customer implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CURSO_SEQ")
	@SequenceGenerator(sequenceName = "CURSO_SEQ", name = "CURSO_SEQ", allocationSize=1)	
	private Integer id;
	
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	//@Column(name="CUSTRECORD_RECID")
	//private Long recordId;
	
	@OneToOne //el tipo de relacion
	@JoinColumn(name="CUSTRECORD_RECID") // la columna que va a ser foranea
	private Record record;

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	//mappedby es el nombre de la clase order que tiene la relacion @ManyToOne
	private Collection<Order> pedidos;
	
	public Customer() {
		super();
	}

	public Customer(Integer id, String customerName, Record record) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.record = record;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}
	
	public Collection<Order> getPedidos() {
		return pedidos;
	}
	
	public void setPedidos(Collection<Order> pedidos) {
		this.pedidos = pedidos;
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
		Customer other = (Customer) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + "]";
	}

	
	
	

}
