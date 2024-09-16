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

import com.senadi.pasantes.intranet.service.INotificacionService;
import com.senadi.pasantes.intranet.service.to.NotificacionTO;

@CrossOrigin
@RestController
@RequestMapping(path = "/Notificaciones")
public class NotificacionControllerRestful {

	@Autowired
	private INotificacionService iNotificacionService;

	// BUSCAR POR ID
	// http://localhost:8086/API/v1.0/Intranet/Notificaciones/{id} GET
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NotificacionTO> buscarPorId(@PathVariable Integer id) {
		var NotificacionTo = this.iNotificacionService.buscarPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(NotificacionTo);
	}

	// BUSCAR POR ID
	// http://localhost:8086/API/v1.0/Intranet/Notificaciones GET
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NotificacionTO>> buscarTodos() {
		List<NotificacionTO> notificacionesTo = this.iNotificacionService.buscarTodos();
		return ResponseEntity.status(HttpStatus.OK).body(notificacionesTo);
	}

	// INSERTAR
	// http://localhost:8086/API/v1.0/Intranet/Notificaciones POST
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertar(@RequestBody NotificacionTO NotificacionTO) {
		this.iNotificacionService.insertar(NotificacionTO);
	}

	// ACTUALIZAR
	// http://localhost:8086/API/v1.0/Intranet/Notificaciones/{id} PUT
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Integer actualizar(@PathVariable Integer id, @RequestBody NotificacionTO NotificacionTO) {
		NotificacionTO.setId(id);
		return this.iNotificacionService.actualizar(NotificacionTO);

	}

	// BORRAR
	// http://localhost:8086/API/v1.0/Intranet/Notificaciones/{id} DELETE
	@DeleteMapping(path = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		this.iNotificacionService.eliminar(id);
	}

	// CAMBIAR ESTADO
	// http://localhost:8086/API/v1.0/Intranet/Notificaciones/6/1 POST
	@PostMapping(path = "/{idImg}/{idAdmin}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> cambiarEstado(@PathVariable Integer idImg, @PathVariable Integer idAdmin) {

		return ResponseEntity.status(HttpStatus.OK).body(this.iNotificacionService.cambiarEstado(idImg, idAdmin));

	}

	// BUSCAR POR ID
	// http://localhost:8086/API/v1.0/Intranet/Notificaciones/activos GET
	@GetMapping(path = "/activos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NotificacionTO>> buscarTodosFecha() {
		List<NotificacionTO> notificacionesTo = this.iNotificacionService.obtenerNotificaciones();
		return ResponseEntity.status(HttpStatus.OK).body(notificacionesTo);
	}

}