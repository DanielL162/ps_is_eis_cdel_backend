package com.senadi.pasantes.intranet.repository;

import com.senadi.pasantes.intranet.repository.modelo.Notificacion;

public interface INotificacionRepository {
	public void insertar(Notificacion notificacion);
	public Notificacion seleccionar(Integer id);
	public void actualizar(Notificacion notificacion);
	public void eliminar(Integer id);
}
