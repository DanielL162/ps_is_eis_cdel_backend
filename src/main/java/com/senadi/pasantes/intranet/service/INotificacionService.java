package com.senadi.pasantes.intranet.service;

import java.util.List;

import com.senadi.pasantes.intranet.repository.modelo.Notificacion;
import com.senadi.pasantes.intranet.service.to.NotificacionTO;

public interface INotificacionService {

	public void insertar(NotificacionTO notificacionTO);

	public NotificacionTO buscarPorId(Integer id);
	
	public List<NotificacionTO>  buscarTodos();

	public void actualizar(NotificacionTO notificacionTO);

	public void eliminar(Integer id);

	List<NotificacionTO> obtenerNotificaciones();

	public Integer cambiarEstado(Integer idImg, Integer idAdmin);

}
