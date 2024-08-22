package com.senadi.pasantes.intranet.service.to;

import java.io.Serializable;
import java.util.List;

import com.senadi.pasantes.intranet.repository.modelo.Documento;
import com.senadi.pasantes.intranet.repository.modelo.Formulario;
import com.senadi.pasantes.intranet.repository.modelo.Notificacion;

import jakarta.persistence.OneToMany;

public class UsuarioTO implements Serializable {

	private static final long serialVersionUID = 1L;

    private Integer id;
    private String cedula;
    private String identificacionSenadi;
    private String nombres;
    private String apellidos;
    private String password;
    private String email;
    private String rol;
    private String departamento;
    
    //Relaciones
	private List<NotificacionTO> notificacionesTO;
	private List<LogTO> logTO;
/* 	private List<FormularioTO> formulariosTO;
	private List<DocumentoTO> documentosTO; */

    //GET y SET
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
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
    public List<NotificacionTO> getNotificacionesTO() {
        return notificacionesTO;
    }
    public void setNotificacionesTO(List<NotificacionTO> notificacionesTO) {
        this.notificacionesTO = notificacionesTO;
    }
    public List<LogTO> getLogTO() {
        return logTO;
    }
    public void setLogTO(List<LogTO> logTO) {
        this.logTO = logTO;
    }
/*     public List<FormularioTO> getFormulariosTO() {
        return formulariosTO;
    }
    public void setFormulariosTO(List<FormularioTO> formulariosTO) {
        this.formulariosTO = formulariosTO;
    }
    public List<DocumentoTO> getDocumentosTO() {
        return documentosTO;
    }
    public void setDocumentosTO(List<DocumentoTO> documentosTO) {
        this.documentosTO = documentosTO;
    } */

}
