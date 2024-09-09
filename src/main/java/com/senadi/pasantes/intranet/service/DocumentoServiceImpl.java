package com.senadi.pasantes.intranet.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senadi.pasantes.intranet.repository.IDocumentoRepository;
import com.senadi.pasantes.intranet.repository.modelo.Documento;
import com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoInstructivoDTO;
import com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoListaDTO;
import com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoNormativaDTO;
import com.senadi.pasantes.intranet.service.to.DocumentoInstructivoTO;
import com.senadi.pasantes.intranet.service.to.DocumentoListaTO;
import com.senadi.pasantes.intranet.service.to.DocumentoNormativaTO;
import com.senadi.pasantes.intranet.service.to.DocumentoTO;
import com.senadi.pasantes.intranet.service.to.LogTO;

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

	private DocumentoNormativaTO documentoNormativaDTOToDocumentoNormativaTO(
			DocumentoNormativaDTO documentoNormativaDTO) {
		return modelMapper.map(documentoNormativaDTO, DocumentoNormativaTO.class);
	}

	private DocumentoNormativaDTO documentoNormativaTOToDocumentoNormativaDTO(
			DocumentoNormativaTO documentoNormativaTO) {
		return modelMapper.map(documentoNormativaTO, DocumentoNormativaDTO.class);
	}

	private DocumentoInstructivoTO documentoInstructivoDTOToDocumentoInstructivoTO(
			DocumentoInstructivoDTO documentoInstructivoDTO) {
		return modelMapper.map(documentoInstructivoDTO, DocumentoInstructivoTO.class);
	}

	private DocumentoInstructivoDTO documentoInstructivoTOToDocumentoInstructivoDTO(
			DocumentoInstructivoTO documentoInstructivoTO) {
		return modelMapper.map(documentoInstructivoTO, DocumentoInstructivoDTO.class);
	}

	@Autowired
	private IDocumentoRepository iDocumentoRepo;

	@Autowired
	private ILogService iLogService;

	@Override
	public void insertar(DocumentoTO documentoTO) {
		this.iDocumentoRepo.insertar(this.convertirADocumento(documentoTO));

		// LOGS
		LogTO logTO = new LogTO();
		String accion = String.format("Inserto: [docu_id: %s]", documentoTO.getId());

		logTO.setId(documentoTO.getId());
		logTO.setFechaAccion(LocalDateTime.now());
		logTO.setAccion(accion);
		this.iLogService.insertar(logTO);

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
    
		Integer act = -1;
		try {
			// LOGS
			LogTO logTO = new LogTO();
			String accion = String.format(
					"Modifico a partir de: [docu_id: %s, " + "docu_categoria: %s, "
							+ "docu_nombre: %s, " + "docu_fecha_actualizacion: %s]",
					documentoTO.getId(), documentoTO.getCategoria(), documentoTO.getNombre()
					, documentoTO.getFechaActualizacion());

			logTO.setFechaAccion(LocalDateTime.now());
			logTO.setAccion(accion);
			this.iLogService.insertar(logTO);

			act = this.iDocumentoRepo.actualizar(docActualizar);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return act;

	}

	@Override
	public void eliminar(Integer id) {
		this.iDocumentoRepo.eliminar(id);
	}

	@Override
	public void cambiarEstado(Integer id, Integer idAdmin) {
		Documento docu = this.iDocumentoRepo.buscarPorId(id);

		try {
			
			// LOGS
			LogTO logTO = new LogTO();
			String accion = String.format(
					"Modifico a partir de: [docu_id: %s, " + "docu_estado: %s]",
					docu.getId(), docu.getEstado());

			logTO.setFechaAccion(LocalDateTime.now());
			logTO.setAccion(accion);
			this.iLogService.insertar(logTO);
			
			if (docu.getEstado().equals("A")) {
				docu.setEstado("I");
			} else if (docu.getEstado().equals("I")) {
				docu.setEstado("A");
			}
			
			this.iDocumentoRepo.actualizar(docu);


		} catch (Exception e) {
			e.printStackTrace();
		}

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
	public List<DocumentoNormativaTO> buscarNormativasTO() {
		List<DocumentoNormativaDTO> documentoNormativaDTOs = this.iDocumentoRepo.consultarNormativasDTO();
		List<DocumentoNormativaTO> documentoNormativaTOs = new ArrayList<>();

		for (DocumentoNormativaDTO normDTO : documentoNormativaDTOs) {
			documentoNormativaTOs.add(this.documentoNormativaDTOToDocumentoNormativaTO(normDTO));
		}

		return documentoNormativaTOs;
	}

	@Override
	public List<DocumentoInstructivoTO> buscarInstructivosTO() {
		List<DocumentoInstructivoDTO> documentoInstructivoDTOs = this.iDocumentoRepo.consultarInstructivosDTO();
		List<DocumentoInstructivoTO> documentoInstructivoTOs = new ArrayList<>();

		for (DocumentoInstructivoDTO normDTO : documentoInstructivoDTOs) {
			documentoInstructivoTOs.add(this.documentoInstructivoDTOToDocumentoInstructivoTO(normDTO));
		}

		return documentoInstructivoTOs;
	}

}