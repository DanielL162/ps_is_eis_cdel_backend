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

@Table(name = "log")
@Entity
public class Log {
	
	@Id
	@SequenceGenerator(name = "seq_log", sequenceName = "seq_log", allocationSize = 1 )
	@GeneratedValue(generator = "seq_log", strategy = GenerationType.SEQUENCE)
	@Column(name = "log_id")
	private Integer id;
	
	@Column(name = "log_accion")
	private String accion;
	
	@Column(name = "log_fecha_accion")
	private LocalDateTime fechaAccion;
	
	//@ManyToOne
	//@JoinColumn(name = "user_log_id")
	//private Usuario;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public LocalDateTime getFechaAccion() {
		return fechaAccion;
	}

	public void setFechaAccion(LocalDateTime fechaAccion) {
		this.fechaAccion = fechaAccion;
	}
	

	
	
	
	
	
	
	
}
