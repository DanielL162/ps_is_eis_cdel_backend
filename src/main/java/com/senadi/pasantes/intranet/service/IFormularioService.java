package com.senadi.pasantes.intranet.service;

import com.senadi.pasantes.intranet.service.to.FormularioTO;

public interface IFormularioService {

	public void insertar(FormularioTO formularioTO);

	public FormularioTO buscarPorId(Integer id);

	public void actualizar(FormularioTO formularioTO);

	public void eliminar(Integer id);

}
