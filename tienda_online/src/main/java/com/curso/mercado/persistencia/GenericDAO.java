package com.curso.mercado.persistencia;

import java.util.List;

public interface GenericDAO<T> {
	//te dice que metodos va a tener el dao(data acess object)
	// T sustituyes t por el nombre de la clse qu se quiera
	public void add(T entidad);
	public List<T> getAll();
	public T getByID(int id);
	public void delete(int id);
	public void update (T entidad);

}
