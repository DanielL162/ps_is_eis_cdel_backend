package com.senadi.pasantes.intranet.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senadi.pasantes.intranet.repository.IDocumentoRepository;
import com.senadi.pasantes.intranet.repository.modelo.Documento;
import com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoListaDTO;
import com.senadi.pasantes.intranet.service.to.DocumentoListaTO;
import com.senadi.pasantes.intranet.service.to.DocumentoTO;

@Service
public class DocumentoServiceImpl implements IDocumentoService {

	private final ModelMapper modelMapper = new ModelMapper();

	private DocumentoTO convertirATO(Documento documento) {
		return modelMapper.map(documento, DocumentoTO.class);
	}

	private Documento convertirADocumento(DocumentoTO documentoTO) {
		return modelMapper.map(documentoTO, Documento.class);
	}

	private DocumentoListaTO documentoListaDTOToDocumentoListaTO(DocumentoListaDTO documentoListaDTO) {
		return modelMapper.map(documentoListaDTO, DocumentoListaTO.class);
	}

	private DocumentoListaDTO documentoListaTOToDocumentoListaDTO(DocumentoListaTO documentoListaTO) {
		return modelMapper.map(documentoListaTO, DocumentoListaDTO.class);
	}

	@Autowired
	private IDocumentoRepository iDocumentoRepo;

	@Override
	public void insertar(DocumentoTO documentoTO) {
		this.iDocumentoRepo.insertar(this.convertirADocumento(documentoTO));
	}

	@Override
	public DocumentoTO buscarPorId(Integer id) {
		return this.convertirATO(this.iDocumentoRepo.buscarPorId(id));
	}

	@Override
	public Integer actualizar(DocumentoTO documentoTO) {
		// En ambos casos se respeta la fecha de creacion.
		// Si no se altera el documento y el tipo de documento:
		var docActualizar = this.iDocumentoRepo.buscarPorId(documentoTO.getId());
		docActualizar.setNombre(documentoTO.getNombre());
		docActualizar.setCategoria(documentoTO.getCategoria());
		docActualizar.setFechaActualizacion(documentoTO.getFechaActualizacion());
		docActualizar.setUsuario(documentoTO.getUsuario());

		// Si se coloca un nuevo documento:
		if (documentoTO.getDocumento() != null) {
			docActualizar.setDocumento(documentoTO.getDocumento());
			docActualizar.setTipo(documentoTO.getTipo());
			docActualizar.setEstado(documentoTO.getEstado());
		}

		return this.iDocumentoRepo.actualizar(docActualizar);
	}

	@Override
	public void eliminar(Integer id) {
		this.iDocumentoRepo.eliminar(id);
	}

	@Override
	public List<DocumentoListaTO> buscarTodosDocumentoListaTO() {

		List<DocumentoListaDTO> documentoListaDTO = this.iDocumentoRepo.consultarTodosDocumentoListaDTO();
		List<DocumentoListaTO> documentoListaTO = new ArrayList<>();

		for (DocumentoListaDTO docsDTO : documentoListaDTO) {
			documentoListaTO.add(this.documentoListaDTOToDocumentoListaTO(docsDTO));
		}

		return documentoListaTO;
	}

}