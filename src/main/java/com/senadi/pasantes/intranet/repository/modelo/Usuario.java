package com.senadi.pasantes.intranet.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)
	@Column(name = "user_id")
	private Integer id;
	@Column(name = "user_cedula")
	private String cedula;
	@Column(name = "user_identificacion_senadi")
	private String identificacionSenadi;
	@Column(name = "user_nombres")
	private String nombres;
	@Column(name = "user_apellidos")
	private String apellidos;
	@Column(name = "user_password")
	private String password;
	@Column(name = "user_email")
	private String email;
	@Column(name = "user_rol")
	private String rol;
	@Column(name = "user_departamento")
	private String departamento;
	
	@OneToMany(mappedBy = "usuario")
	private List<Notificacion> notificacions;
	
	@OneToMany(mappedBy = "usuario")
	private List<Log> logs;
	
	@OneToMany(mappedBy = "emisor")
	private List<Formulario> formularios;

	@OneToMany(mappedBy = "usuario")
	private List<Documento> documentos;
	
	//gets y sets
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getIdentificacionSenadi() {
		return identificacionSenadi;
	}

	public void setIdentificacionSenadi(String identificacionSenadi) {
		this.identificacionSenadi = identificacionSenadi;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public List<Notificacion> getNotificacions() {
		return notificacions;
	}

	public void setNotificacions(List<Notificacion> notificacions) {
		this.notificacions = notificacions;
	}

	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public List<Formulario> getFormularios() {
		return formularios;
	}

	public void setFormularios(List<Formulario> formularios) {
		this.formularios = formularios;
	}
	
	
	
}
