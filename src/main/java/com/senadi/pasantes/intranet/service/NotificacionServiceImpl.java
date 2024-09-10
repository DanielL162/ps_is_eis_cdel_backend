package com.senadi.pasantes.intranet.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
	public List<NotificacionTO> buscarTodos() {
		List<Notificacion> notificacions=this.iNotificacionRepo.buscarTodos();
		List<NotificacionTO> notificacionTOs=new ArrayList<>();
		
		
		for (Notificacion noti:notificacions  ) {
			notificacionTOs.add(this.convertirATO(noti));
		}
		
		return notificacionTOs;
	}

	@Override
	public void actualizar(NotificacionTO notificacionTO) {
		this.iNotificacionRepo.actualizar(this.convertirANotificacion(notificacionTO));
	}
	
	
	
	
	
	
	
	

	@Override
	public void eliminar(Integer id) {
		this.iNotificacionRepo.eliminar(id);
	}
	
	
	@Override
	public List<NotificacionTO> obtenerNotificaciones() {
		
		LocalDateTime fechaActual= LocalDateTime.now();
		List<Notificacion> notificaciones= this.iNotificacionRepo.buscarPorfecha(fechaActual);

		List<NotificacionTO> notificacionTOs = new ArrayList<>();
		for (Notificacion notificacion : notificaciones) {
			NotificacionTO notificacionTO=  this.convertirATO(notificacion);
			notificacionTOs.add(notificacionTO);
		}
		
	
		
		return notificacionTOs;
		
	}
	
	
	
	
	
	
	

}