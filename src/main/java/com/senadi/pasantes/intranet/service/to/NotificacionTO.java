package com.senadi.pasantes.intranet.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;

public class NotificacionTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	private LocalDateTime fechaInicio;

	private LocalDateTime fechaFin;

	private String urlImagen;

	private String importancia;

	private String estado;

	//Relaciones
	private UsuarioTO usuarioTO;
	
	//Get y set
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDateTime getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	public String getImportancia() {
		return importancia;
	}
	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public UsuarioTO getUsuarioTO() {
		return usuarioTO;
	}
	public void setUsuarioTO(UsuarioTO usuarioTO) {
		this.usuarioTO = usuarioTO;
	}
	
}
