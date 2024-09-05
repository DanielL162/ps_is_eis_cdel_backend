package com.senadi.pasantes.intranet.repository.modelo.dto;

import java.time.LocalDateTime;

public class DocumentoInstructivoDTO {

	private Integer id;
	private String nombre;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaActualizacion;
	private String documento;
	private String tipo;

	public DocumentoInstructivoDTO() {
		super();
	}

	public DocumentoInstructivoDTO(Integer id, String nombre, LocalDateTime fechaCreacion,
			LocalDateTime fechaActualizacion, String documento, String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.documento = documento;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "DocumentoNormativaDTO [id=" + id + ", nombre=" + nombre + ", fechaCreacion=" + fechaCreacion
				+ ", fechaActualizacion=" + fechaActualizacion + ", documento=" + documento + ", tipo=" + tipo + "]";
	}

}
