package com.senadi.pasantes.intranet.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senadi.pasantes.intranet.repository.modelo.dto.DocumentoArchivoDTO;
import com.senadi.pasantes.intranet.service.IDocumentoService;
import com.senadi.pasantes.intranet.service.to.DocumentoDTO_TO;
import com.senadi.pasantes.intranet.service.to.DocumentoInstructivoTO;
import com.senadi.pasantes.intranet.service.to.DocumentoListaTO;
import com.senadi.pasantes.intranet.service.to.DocumentoNormativaTO;
import com.senadi.pasantes.intranet.service.to.DocumentoTO;

@CrossOrigin
@RestController
@RequestMapping(path = "/Documentos")
public class DocumentoControllerRestful {

	@Autowired
	private IDocumentoService iDocumentoService;

	// BUSCAR POR ID
	// http://localhost:8086/API/v1.0/Intranet/Documentos/{id} GET
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DocumentoTO> buscarPorId(@PathVariable Integer id) {
		var DocumentoTo = this.iDocumentoService.buscarPorId(id);
		System.out.println(DocumentoTo);
		return ResponseEntity.status(HttpStatus.OK).body(DocumentoTo);
	}

	// BUSCAR TODOS
	// http://localhost:8086/API/v1.0/Intranet/Documentos/normativas GET
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DocumentoListaTO>> buscarTodos() {
		List<DocumentoListaTO> documentosListaTO = this.iDocumentoService.buscarTodosDocumentoListaTO();
		return ResponseEntity.status(HttpStatus.OK).body(documentosListaTO);
	}

	// CONSULTAR TODOS DTO
	// http://localhost:8086/API/v1.0/Intranet/Documentos/todosDTO GET
	@GetMapping(path = "/todosDTO", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DocumentoDTO_TO>> consultarTodosDTO() {
		var ls = this.iDocumentoService.consultarTodoDTO();
		for (DocumentoDTO_TO docu : ls) {
			Link link = linkTo(methodOn(DocumentoControllerRestful.class).buscarPorId(docu.getId())).withRel("enlaces");
			docu.add(link);

			Link linkVer = linkTo(methodOn(DocumentoControllerRestful.class).buscarPorIdSoloDocumento(docu.getId()))
					.withRel("verSoloDoc");
			docu.add(linkVer);
		}
		return ResponseEntity.status(HttpStatus.OK).body(ls);
	}

	// BUSCAR POR ID
	// http://localhost:8086/API/v1.0/Intranet/Documentos/doc/{id} GET
	@GetMapping(path = "/doc/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DocumentoArchivoDTO> buscarPorIdSoloDocumento(@PathVariable Integer id) {
		var doc = this.iDocumentoService.buscarPorIdSoloDocumento(id);
		System.out.println(doc);
		return ResponseEntity.status(HttpStatus.OK).body(doc);
	}

	// BUSCAR NORMATIVAS TO
	// http://localhost:8086/API/v1.0/Intranet/Documentos/instructivos GET
	@GetMapping(path = "/normativas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DocumentoNormativaTO>> buscarNormativasTO() {
		var ls = this.iDocumentoService.buscarNormativasTO();
		for (var docu : ls) {
			Link link = linkTo(methodOn(DocumentoControllerRestful.class).buscarPorId(docu.getId())).withRel("enlaces");
			docu.add(link);

			Link linkVer = linkTo(methodOn(DocumentoControllerRestful.class).buscarPorIdSoloDocumento(docu.getId()))
					.withRel("verSoloDoc");
			docu.add(linkVer);
		}
		return ResponseEntity.status(HttpStatus.OK).body(ls);
	}

	// BUSCAR INSTRUCTIVOS TO
	// http://localhost:8086/API/v1.0/Intranet/Documentos GET
	@GetMapping(path = "/instructivos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DocumentoInstructivoTO>> buscarInstructivosTO() {
		var ls = this.iDocumentoService.buscarInstructivosTO();
		for (var docu : ls) {
			Link link = linkTo(methodOn(DocumentoControllerRestful.class).buscarPorId(docu.getId())).withRel("enlaces");
			docu.add(link);

			Link linkVer = linkTo(methodOn(DocumentoControllerRestful.class).buscarPorIdSoloDocumento(docu.getId()))
					.withRel("verSoloDoc");
			docu.add(linkVer);
		}
		return ResponseEntity.status(HttpStatus.OK).body(ls);
	}

	// BUSCAR POR ID
	// http://localhost:8086/API/v1.0/Intranet/Documentos/byte/{id} GET
	@GetMapping(path = "/byte/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<byte[]> descargarDocumentoByte(@PathVariable Integer id) {
		var documentoTo = this.iDocumentoService.buscarPorId(id);

		if (documentoTo != null) {
			byte[] fileContent = Base64.getDecoder().decode(documentoTo.getDocumento());
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.parseMediaType(documentoTo.getTipo()));
			headers.setContentDispositionFormData("attachment", documentoTo.getNombre());
			headers.setContentLength(fileContent.length);

			return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// INSERTAR
	// http://localhost:8086/API/v1.0/Intranet/Documentos POST
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertar(@RequestBody DocumentoTO DocumentoTO) {
		this.iDocumentoService.insertar(DocumentoTO);
	}

	// ACTUALIZAR
	// http://localhost:8086/API/v1.0/Intranet/Documentos/{id} PUT
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Integer actualizar(@PathVariable Integer id, @RequestBody DocumentoTO DocumentoTO) {
		DocumentoTO.setId(id);

		return this.iDocumentoService.actualizar(DocumentoTO);
	}

	// BORRAR
	// http://localhost:8086/API/v1.0/Intranet/Documentos/{id} DELETE
	@DeleteMapping(path = "/{id}")
	public Integer eliminar(@PathVariable Integer id) {
		return this.iDocumentoService.eliminar(id);
	}

	// CAMBIAR ESTADO
	// http://localhost:8086/API/v1.0/Intranet/Documentos/6/1 POST
	@PostMapping(path = "/{idDocu}/{idAdmin}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> cambiarEstado(@PathVariable Integer idDocu, @PathVariable Integer idAdmin) {

		return ResponseEntity.status(HttpStatus.OK).body(this.iDocumentoService.cambiarEstado(idDocu, idAdmin));

	}
}