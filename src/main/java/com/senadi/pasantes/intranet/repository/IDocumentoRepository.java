package com.senadi.pasantes.intranet.repository;

import java.util.List;

import com.senadi.pasantes.intranet.repository.modelo.Documento;
import com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoListaDTO;

public interface IDocumentoRepository {

	public void insertar(Documento documento);

	public Documento buscarPorId(Integer id);

	public void actualizar(Documento documento);

	public void eliminar(Integer id);
	
	public List<DocumentoListaDTO> consultarTodosDocumentoListaDTO();

}
