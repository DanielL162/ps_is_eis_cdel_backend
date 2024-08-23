package com.senadi.pasantes.intranet.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senadi.pasantes.intranet.repository.INotificacionRepository;
import com.senadi.pasantes.intranet.repository.modelo.Notificacion;
import com.senadi.pasantes.intranet.service.to.NotificacionTO;

@Service
public class NotificacionServiceImpl implements INotificacionService {

	private final ModelMapper modelMapper = new ModelMapper();

	private NotificacionTO convertirATO(Notificacion notificacion) {
		return modelMapper.map(notificacion, NotificacionTO.class);
	}

	private Notificacion convertirANotificacion(NotificacionTO notificacionTO) {
		return modelMapper.map(notificacionTO, Notificacion.class);
	}

	@Autowired
	private INotificacionRepository iNotificacionRepo;

	@Override
	public void insertar(NotificacionTO notificacionTO) {
		this.iNotificacionRepo.insertar(this.convertirANotificacion(notificacionTO));
	}

	@Override
	public NotificacionTO buscarPorId(Integer id) {
		return this.convertirATO(this.iNotificacionRepo.buscarPorId(id));
	}

	@Override
	public void actualizar(NotificacionTO notificacionTO) {
		this.iNotificacionRepo.actualizar(this.convertirANotificacion(notificacionTO));
	}

	@Override
	public void eliminar(Integer id) {
		this.iNotificacionRepo.eliminar(id);
	}

}