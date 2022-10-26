package com.curso.jpa.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ_CUSTOM")
	@SequenceGenerator(sequenceName = "EMPLOYEES_SEQ", name = "CUST_SEQ_CUSTOM", allocationSize=1)
	@Column(name = "ORDERID")
	private Long id;
	@Column(name = "DESCRIPTION")
	private String descripcion;
	//@Column(name = "CUSTOMER_ID")
	//private Long idCliente;
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")//foreing key,,
			//referencedColumnName = "ID")// nombre de la columna primay key en la tabla clientes 
	private Customer customer;
	
	public Order() {
		super();
	}

	public Order(Long id, String descripcion, Customer customer) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
}
