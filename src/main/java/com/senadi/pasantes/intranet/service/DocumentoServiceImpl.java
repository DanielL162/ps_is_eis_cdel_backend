package com.senadi.pasantes.intranet.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senadi.pasantes.intranet.repository.IDocumentoRepository;
import com.senadi.pasantes.intranet.repository.modelo.Documento;
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
	public void actualizar(DocumentoTO documentoTO) {
		this.iDocumentoRepo.actualizar(this.convertirADocumento(documentoTO));
	}

	@Override
	public void eliminar(Integer id) {
		this.iDocumentoRepo.eliminar(id);
	}

}