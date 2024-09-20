package com.senadi.pasantes.intranet.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.senadi.pasantes.intranet.repository.modelo.Usuario;

public class FormularioTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private LocalDateTime fechaEmision;
	private LocalDateTime fechaTratamiento;
	private String estado;
	private Integer idDestinatario;
	private String contenido;

	// Relaciones
	private Usuario emisor;

	// Get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDateTime fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public LocalDateTime getFechaTratamiento() {
		return fechaTratamiento;
	}

	public void setFechaTratamiento(LocalDateTime fechaTratamiento) {
		this.fechaTratamiento = fechaTratamiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario getEmisor() {
		return emisor;
	}

	public void setEmisor(Usuario emisor) {
		this.emisor = emisor;
	}

	public Integer getIdDestinatario() {
		return idDestinatario;
	}

	public void setIdDestinatario(Integer idDestinatario) {
		this.idDestinatario = idDestinatario;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
