package com.senadi.pasantes.service.to;

import java.time.LocalDateTime;

public class LogTO {
	
	private Integer id;
	
	private String accion;
	
	private LocalDateTime fechaAccion;
	
	
	
	//GET y SET

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

	@Override
	public String toString() {
		return "LogTo [id=" + id + ", accion=" + accion + ", fechaAccion=" + fechaAccion + "]";
	}
	
	
	
	
	
	

}
