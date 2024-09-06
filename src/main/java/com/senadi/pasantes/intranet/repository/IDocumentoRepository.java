package com.senadi.pasantes.intranet.repository;

import java.util.List;

import com.senadi.pasantes.intranet.repository.modelo.Documento;
import com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoInstructivoDTO;
import com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoListaDTO;
import com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoNormativaDTO;

public interface IDocumentoRepository {

	public void insertar(Documento documento);

	public Documento buscarPorId(Integer id);

	public Integer actualizar(Documento documento);

	public void eliminar(Integer id);
	
	public List<DocumentoListaDTO> consultarTodosDocumentoListaDTO();
	
	public List<DocumentoNormativaDTO> consultarNormativasDTO();
	
	public List<DocumentoInstructivoDTO> consultarInstructivosDTO();

}
