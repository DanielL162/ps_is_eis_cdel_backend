package com.senadi.pasantes.intranet.controller;

import java.util.Base64;

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
import com.senadi.pasantes.intranet.service.to.DocumentoTO;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(path = "/Documentos")
public class DocumentoControllerRestful {

	@Autowired
	private IDocumentoService iDocumentoService;

	// BUSCAR POR ID
	// http://localhost:8086/API/v1.0/Intranet/Documentos/{id} GET
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DocumentoTO> buscarPorId(@PathVariable Integer id) {
		var documentoTo = this.iDocumentoService.buscarPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(documentoTo);
	}

	// INSERTAR
	// http://localhost:8086/API/v1.0/Intranet/Documentos POST
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertar(@RequestBody DocumentoTO documentoTO) {
	    try {
	        // Decode the Base64 document string into a byte array
	        if (documentoTO.getDocumento() != null) {
	            byte[] documentoBytes = Base64.getDecoder().decode(documentoTO.getDocumento());
	            documentoTO.setDocumento(documentoBytes);
	        }
	        this.iDocumentoService.insertar(documentoTO);
	        return ResponseEntity.status(HttpStatus.CREATED).body("Documento insertado con éxito");
	    } catch (IllegalArgumentException e) {
	        // Handle the case where the Base64 string is invalid
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al decodificar el documento en Base64: " + e.getMessage());
	    }
	}

	// ACTUALIZAR
	// http://localhost:8086/API/v1.0/Intranet/Documentos/{id} PUT
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@PathVariable Integer id, @RequestBody DocumentoTO documentoTO) {
		documentoTO.setId(id);
		// Decode the Base64 document string into a byte array
		if (documentoTO.getDocumento() != null) {
			byte[] documentoBytes = Base64.getDecoder().decode(documentoTO.getDocumento());
			documentoTO.setDocumento(documentoBytes);
		}
		this.iDocumentoService.actualizar(documentoTO);
	}

	// BORRAR
	// http://localhost:8086/API/v1.0/Intranet/Documentos/{id} DELETE
	@DeleteMapping(path = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		this.iDocumentoService.eliminar(id);
	}

}