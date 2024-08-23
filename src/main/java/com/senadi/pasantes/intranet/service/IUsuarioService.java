package com.senadi.pasantes.intranet.service;

import com.senadi.pasantes.intranet.service.to.UsuarioTO;

public interface IUsuarioService {

	public void insertar(UsuarioTO usuarioTO);

	public UsuarioTO buscarPorId(Integer id);

	public void actualizar(UsuarioTO usuarioTO);

	public void eliminar(Integer id);

}
