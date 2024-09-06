package com.senadi.pasantes.intranet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.senadi.pasantes.intranet.service.IDocumentoService;
import com.senadi.pasantes.intranet.service.to.DocumentoListaTO;
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
		return ResponseEntity.status(HttpStatus.OK).body(DocumentoTo);
	}

	// BUSCAR TODOS
	// http://localhost:8086/API/v1.0/Intranet/Documentos GET
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DocumentoListaTO>> buscarTodos() {
		List<DocumentoListaTO> documentosListaTO = this.iDocumentoService.buscarTodosDocumentoListaTO();
		return ResponseEntity.status(HttpStatus.OK).body(documentosListaTO);
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
	public void eliminar(@PathVariable Integer id) {
		this.iDocumentoService.eliminar(id);
	}
}