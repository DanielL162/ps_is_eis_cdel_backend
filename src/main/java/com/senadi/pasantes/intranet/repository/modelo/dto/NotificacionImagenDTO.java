package com.senadi.pasantes.intranet.repository.modelo.dto;

import java.time.LocalDateTime;

public class NotificacionImagenDTO {

	private Integer id;

	private String urlImagen;

	private LocalDateTime fechaInicio;

	private LocalDateTime fechaFin;

	private String importancia;

	private String estado;

	public NotificacionImagenDTO() {
		super();
	}

	public NotificacionImagenDTO(Integer id, String urlImagen, LocalDateTime fechaInicio, LocalDateTime fechaFin,
			String importancia, String estado) {
		super();
		this.id = id;
		this.urlImagen = urlImagen;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.importancia = importancia;
		this.estado = estado;
	}

	// Get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
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

}
