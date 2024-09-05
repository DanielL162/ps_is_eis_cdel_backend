package com.senadi.pasantes.intranet.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senadi.pasantes.intranet.repository.IDocumentoRepository;
import com.senadi.pasantes.intranet.repository.modelo.Documento;
import com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoListaDTO;
import com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoNormativaDTO;
import com.senadi.pasantes.intranet.service.to.DocumentoInstructivoTO;
import com.senadi.pasantes.intranet.service.to.DocumentoListaTO;
import com.senadi.pasantes.intranet.service.to.DocumentoNormativaTO;
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
	
	private DocumentoNormativaTO documentoNormativaDTOToDocumentoNormativaTO(DocumentoNormativaDTO documentoNormativaDTO) {
		return modelMapper.map(documentoNormativaDTO, DocumentoNormativaTO.class);
	}

	private DocumentoNormativaDTO documentoNormativaTOToDocumentoNormativaDTO(DocumentoNormativaTO documentoNormativaTO) {
		return modelMapper.map(documentoNormativaTO, DocumentoNormativaDTO.class);
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

	@Override
	public List<DocumentoListaTO> buscarTodosDocumentoListaTO() {
		
		List<DocumentoListaDTO> documentoListaDTO = this.iDocumentoRepo.consultarTodosDocumentoListaDTO();
		List<DocumentoListaTO> documentoListaTO = new ArrayList<>();
		
		for (DocumentoListaDTO docsDTO : documentoListaDTO) {
			documentoListaTO.add(this.documentoListaDTOToDocumentoListaTO(docsDTO));
		}
		
		
		return documentoListaTO;
	}

	@Override
	public List<DocumentoNormativaTO> consultarNormativasTO() {
		List<DocumentoNormativaDTO> documentoNormativaDTOs = this.iDocumentoRepo.consultarNormativasDTO();
		List<DocumentoNormativaTO>  documentoNormativaTOs = new ArrayList<>();
		
		for (DocumentoNormativaDTO normDTO : documentoNormativaDTOs) {
			documentoNormativaTOs.add(this.documentoNormativaDTOToDocumentoNormativaTO(normDTO));
		}
		
		
		return documentoNormativaTOs;
	}

	@Override
	public List<DocumentoInstructivoTO> consultarInstructivosTO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}