package com.senadi.pasantes.intranet.repository.modelo.dto;

public class NotificacionImagenDTO {

	private Integer id;

	private String urlImagen;

	public NotificacionImagenDTO() {
		super();
	}

	public NotificacionImagenDTO(Integer id, String urlImagen) {
		super();
		this.id = id;
		this.urlImagen = urlImagen;
	}

	// Get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

}
