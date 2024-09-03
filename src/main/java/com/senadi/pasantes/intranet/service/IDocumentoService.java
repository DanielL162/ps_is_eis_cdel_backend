package com.senadi.pasantes.intranet.service;

import java.util.List;

import com.senadi.pasantes.intranet.service.to.DocumentoListaTO;
import com.senadi.pasantes.intranet.service.to.DocumentoTO;

public interface IDocumentoService {

	public void insertar(DocumentoTO documentoTO);

	public DocumentoTO buscarPorId(Integer id);

	public void actualizar(DocumentoTO documentoTO);

	public void eliminar(Integer id);
	
	public List<DocumentoListaTO> buscarTodosDocumentoListaTO();

}
