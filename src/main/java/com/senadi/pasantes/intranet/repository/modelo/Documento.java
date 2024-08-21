package com.senadi.pasantes.intranet.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "documento")
public class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_documento")
	@SequenceGenerator(name = "seq_documento", sequenceName = "seq_documento", allocationSize = 1)
	@Column(name = "docu_id")
	private String id;
	
	@Column(name = "docu_nombre")
	private String nombre;
	
	@Column(name = "docu_categoria")
	private String categoria;
	
	@Column(name="docu_fecha_creacion")
	private LocalDateTime fechaCreacion;
	
	@Column(name="docu_fecha_actualización")
	private LocalDateTime fechaActualizacion;
	
	@Column(name = "docu_documento")
	private String documento;
	
	@Column(name = "docu_documento_url")
	private String documentoURL;
	
	
	@Column (name="docu_tipo")
	private String tipo;
	
    @Column(name="docu_estado")
    private String estado;
    
    @ManyToOne
    @JoinColumn(name = "docu_id_usuario")
    private Usuario usuario;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public String getDocumentoURL() {
		return documentoURL;
	}

	public void setDocumentoURL(String documentoURL) {
		this.documentoURL = documentoURL;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	@Override
	public String toString() {
		return "Documento [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", fechaCreacion="
				+ fechaCreacion + ", fechaActualizacion=" + fechaActualizacion + ", documento=" + documento
				+ ", documentoURL=" + documentoURL + ", tipo=" + tipo + ", estado=" + estado +  "]";
	}
	

    
}
