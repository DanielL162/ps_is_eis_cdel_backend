package com.senadi.pasantes.intranet.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "formulario")
public class Formulario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_formulario")
	@SequenceGenerator(name = "seq_formulario", sequenceName = "seq_formulario", allocationSize = 1)
	@Column(name = "form_id")
	private Integer id;

	@Column(name = "form_fecha_emision")
	private LocalDateTime fechaEmision;

	@Column(name = "form_fecha_tratamiento")
	private LocalDateTime fechaTratamiento;

	@Column(name = "form_estado")
	private String estado;

	@Column(name = "form_id_destinatario")
	private Integer idDestinatario;

	// Relaciones
	@ManyToOne()
	@JoinColumn(name = "form_id_emisor")
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

}
