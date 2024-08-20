package com.senadi.pasantes.intranet.repository;

import com.senadi.pasantes.intranet.repository.modelo.Usuario;

public interface IUsuarioRepository {

	public void insertar(Usuario usuario);
	public Usuario seleccionar(Integer id);
	public void actualizar(Usuario usuario);
	public void eliminar(Integer id);
}
