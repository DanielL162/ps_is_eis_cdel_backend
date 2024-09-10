package com.senadi.pasantes.intranet.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.senadi.pasantes.intranet.repository.modelo.Notificacion;

public interface INotificacionRepository {
	
	public void insertar(Notificacion notificacion);

	public Notificacion buscarPorId(Integer id);
	
	public List<Notificacion> buscarTodos();

	public void actualizar(Notificacion notificacion);

	public void eliminar(Integer id);

	List<Notificacion> buscarPorfecha(LocalDateTime fechaActual);
}
