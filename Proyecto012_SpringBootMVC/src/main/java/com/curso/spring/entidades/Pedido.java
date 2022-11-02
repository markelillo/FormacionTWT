package com.curso.spring.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Pedido implements Serializable{
	
	private Integer id;
	private String user;
	private String desc;
	private Date fechaPedido;
	private boolean usuario;
	public Pedido() {
		super();
	}
	public Pedido(Integer id, String user, String desc, Date fechaPedido, boolean usuario) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.fechaPedido = fechaPedido;
		this.usuario = usuario;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public boolean isUsuario() {
		return usuario;
	}
	public void setUsuario(boolean usuario) {
		this.usuario = usuario;
	}
	@Override
	public int hashCode() {
		return Objects.hash(desc);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(desc, other.desc);
	}
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", user=" + user + ", desc=" + desc + ", fechaPedido=" + fechaPedido + ", usuario="
				+ usuario + "]";
	}
	
	
	

}
