package com.senadi.pasantes.intranet.service;

import com.senadi.pasantes.intranet.service.to.NotificacionTO;

public interface INotificacionService {

	public void insertar(NotificacionTO notificacionTO);

	public NotificacionTO buscarPorId(Integer id);

	public void actualizar(NotificacionTO notificacionTO);

	public void eliminar(Integer id);

}
