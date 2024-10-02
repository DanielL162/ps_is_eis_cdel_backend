package com.senadi.pasantes.intranet.repository.modelo.dto;

public class DocumentoArchivoDTO {

	private String documento;

	private String tipo;

	public DocumentoArchivoDTO() {
		super();
	}

	public DocumentoArchivoDTO(String documento, String tipo) {
		super();
		this.documento = documento;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "DocumentoArchivoDTO [documento=" + documento + ", tipo=" + tipo + "]";
	}

	// Get y set
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

}