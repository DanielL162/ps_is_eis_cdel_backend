package com.senadi.pasantes.intranet.repository.modelo.dto;

import java.time.LocalDateTime;

public class NotificacionDTO {

	private Integer id;

	private LocalDateTime fechaInicio;

	private LocalDateTime fechaFin;

	private String importancia;

	private String estado;

	public NotificacionDTO() {
		super();
	}

	public NotificacionDTO(Integer id, LocalDateTime fechaInicio, LocalDateTime fechaFin, String importancia,
			String estado) {
		super();
		this.id = id;
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

	@Override
	public String toString() {
		return "Notificacion [id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", importancia="
				+ importancia + ", estado=" + estado + " ]";
	}

}
