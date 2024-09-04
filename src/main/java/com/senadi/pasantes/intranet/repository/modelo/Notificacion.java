package com.senadi.pasantes.intranet.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "notificacion")
public class Notificacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_notificacion")
	@SequenceGenerator(name = "seq_notificacion", sequenceName = "seq_notificacion", allocationSize = 1)
	@Column(name = "ntfc_id")
	private Integer id;

	@Column(name = "ntfc_fecha_inicio")
	private LocalDateTime fechaInicio;

	@Column(name = "ntfc_fecha_fin")
	private LocalDateTime fechaFin;

	@Column(name = "ntfc_url_imagen", columnDefinition = "text")
	private String urlImagen;

	@Column(name = "ntfc_importancia")
	private String importancia;

	@Column(name = "ntfc_estado")
	private String estado;
	
	//Relaciones
	@ManyToOne()
	@JoinColumn(name = "ntfc_id_usuario")
	private Usuario usuario;
	
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
