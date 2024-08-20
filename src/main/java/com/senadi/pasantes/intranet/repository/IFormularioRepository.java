package com.senadi.pasantes.intranet.repository;

import com.senadi.pasantes.intranet.repository.modelo.Formulario;

public interface IFormularioRepository {

	public void insertar(Formulario formulario);
	public Formulario seleccionar(Integer id);
	public void actualizar(Formulario formulario);
	public void eliminar(Integer id);
}
