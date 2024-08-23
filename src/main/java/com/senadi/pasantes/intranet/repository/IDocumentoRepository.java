package com.senadi.pasantes.intranet.repository;

import com.senadi.pasantes.intranet.repository.modelo.Documento;

public interface IDocumentoRepository {

	public void insertar(Documento documento);

	public Documento buscarPorId(Integer id);

	public void actualizar(Documento documento);

	public void eliminar(Integer id);

}
